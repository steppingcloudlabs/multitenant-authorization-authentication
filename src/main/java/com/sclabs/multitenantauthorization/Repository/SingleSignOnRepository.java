package com.sclabs.multitenantauthorization.Repository;

import com.sclabs.multitenantauthorization.Model.Users;

public interface SingleSignOnRepository {
	
	Users sso(String username);

}
