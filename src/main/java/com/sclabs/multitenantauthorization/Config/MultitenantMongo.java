package com.sclabs.multitenantauthorization.Config;

import java.util.HashMap;

import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.IndexDefinition;
import org.springframework.data.mongodb.core.index.MongoPersistentEntityIndexResolver;
import org.springframework.data.mongodb.core.mapping.BasicMongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.util.Assert;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;


public class MultitenantMongo extends SimpleMongoClientDbFactory{

	private final String defaultName;
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MultitenantMongo.class);

	private MongoTemplate mongoTemplate;
	private static final ThreadLocal<String> dbName = new ThreadLocal<String>();
	private static final HashMap<String, Object> databaseIndexMap = new HashMap<String, Object>();
   

	
	public MultitenantMongo(MongoClient mongoClient, String databaseName) {
		super(mongoClient, databaseName);
		logger.debug("Instantiating " + MultitenantMongo.class.getName() + " with default database name: " + databaseName);
		System.out.println("Instantiating " + MultitenantMongo.class.getName() + " with default database name: " + databaseName);
		this.defaultName = databaseName;

	}

	public void setmongoTemplate(final MongoTemplate mongoTemplate) {
		Assert.isNull(this.mongoTemplate, "You can set MongoTemplate just once");
		System.out.println("Initializing mongotemplate");
		this.mongoTemplate = mongoTemplate;
	}

	public static void setDatabaseNameForCurrentThread(final String databaseName) {
		logger.debug("Switchin to database: " + databaseName);
		System.out.println("Switchin to database: " + databaseName);
		dbName.set(databaseName);
		System.out.println("Switched to database: " + databaseName);
	}

	public static void clearDatabaseNameForCurrentThread() {
		if (logger.isDebugEnabled())
			logger.debug("Removing database [" + dbName.get() + "]");
		dbName.remove();
	}

	@Override
	public MongoDatabase getDb() throws DataAccessException {
		final String localThreadName = dbName.get();
		final String dbToUse = (localThreadName != null ? localThreadName : this.defaultName);
		logger.debug("Acquiring Database" + dbToUse);
		System.out.println("Acquiring Database: " + dbToUse);
		createIndexIfNecessary(dbToUse);
		return super.getDb();
	}

	private void createIndexIfNecessary(final String dbToUse) {
		if (this.mongoTemplate == null) {
			logger.error("MongoTemplate is null, will not create any index");
			return;
		}

		boolean needsToBeCreated = false;
		synchronized (MultitenantMongo.class) {
			final Object syncObj = databaseIndexMap.get(dbToUse);
			if (syncObj == null) {
				databaseIndexMap.put(dbToUse, new Object());
				needsToBeCreated = true;
			}

		}

		synchronized (databaseIndexMap.get(dbToUse)) {
			if (needsToBeCreated) {
				logger.debug("Creating indices for database name=[" + dbToUse + "]");
				createIndexes();
				logger.debug("Done with creating indices for database name=[" + dbToUse + "]");
			}
		}

	}

	private void createIndexes() {

		final MongoMappingContext mappingContext = (MongoMappingContext) this.mongoTemplate.getConverter()
				.getMappingContext();
		final MongoPersistentEntityIndexResolver indexResolver = new MongoPersistentEntityIndexResolver(mappingContext);
		for (BasicMongoPersistentEntity<?> persistentEntity : mappingContext.getPersistentEntities()) {
			checkForAndCreateIndexes(indexResolver, persistentEntity);
		}
	}

	private void checkForAndCreateIndexes(final MongoPersistentEntityIndexResolver indexResolver,
			final BasicMongoPersistentEntity<?> persistentEntity) {

		if(persistentEntity.findAnnotation(Document.class) != null) {
			for(IndexDefinition indexDefinitionHolder: indexResolver.resolveIndexFor(persistentEntity.getType())) {
				
				this.mongoTemplate.indexOps(persistentEntity.getType()).ensureIndex(indexDefinitionHolder);
			}
		}
	}

}
