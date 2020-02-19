package com.sclabs.multitenantauthorization.Model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Document(collection = "masters")
public class masterdataModel {

    @Id
    ObjectId id;
    String date_of_relieving;
    String user_id;
    String date_of_resignation;
    String last_working_day_as_per_notice_period;
    String personal_email_id;
    String first_name_personal_information;
    String last_name_personal_information;
    String middle_name_personal_information;
    String nationality_personal_information;
    String salutation_personal_information;
    String city_addresses;
    String phone_number_phone_information;
    String manager_job_information;
    String designation_job_information;
    List<String> skill;
    String gender;
    String date_of_birth;
    String linkedInlink;

    ObjectMapper Obj = new ObjectMapper();

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getDate_of_relieving() {
        return date_of_relieving;
    }

    public void setDate_of_relieving(String date_of_relieving) {
        this.date_of_relieving = date_of_relieving;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDate_of_resignation() {
        return date_of_resignation;
    }

    public void setDate_of_resignation(String date_of_resignation) {
        this.date_of_resignation = date_of_resignation;
    }

    public String getLast_working_day_as_per_notice_period() {
        return last_working_day_as_per_notice_period;
    }

    public void setLast_working_day_as_per_notice_period(String last_working_day_as_per_notice_period) {
        this.last_working_day_as_per_notice_period = last_working_day_as_per_notice_period;
    }

    public String getPersonal_email_id() {
        return personal_email_id;
    }

    public void setPersonal_email_id(String personal_email_id) {
        this.personal_email_id = personal_email_id;
    }

    public String getFirst_name_personal_information() {
        return first_name_personal_information;
    }

    public void setFirst_name_personal_information(String first_name_personal_information) {
        this.first_name_personal_information = first_name_personal_information;
    }

    public String getLast_name_personal_information() {
        return last_name_personal_information;
    }

    public void setLast_name_personal_information(String last_name_personal_information) {
        this.last_name_personal_information = last_name_personal_information;
    }

    public String getMiddle_name_personal_information() {
        return middle_name_personal_information;
    }

    public void setMiddle_name_personal_information(String middle_name_personal_information) {
        this.middle_name_personal_information = middle_name_personal_information;
    }

    public String getNationality_personal_information() {
        return nationality_personal_information;
    }

    public void setNationality_personal_information(String nationality_personal_information) {
        this.nationality_personal_information = nationality_personal_information;
    }

    public String getSalutation_personal_information() {
        return salutation_personal_information;
    }

    public void setSalutation_personal_information(String salutation_personal_information) {
        this.salutation_personal_information = salutation_personal_information;
    }

    public String getCity_addresses() {
        return city_addresses;
    }

    public void setCity_addresses(String city_addresses) {
        this.city_addresses = city_addresses;
    }

    public String getPhone_number_phone_information() {
        return phone_number_phone_information;
    }

    public void setPhone_number_phone_information(String phone_number_phone_information) {
        this.phone_number_phone_information = phone_number_phone_information;
    }

    public String getManager_job_information() {
        return manager_job_information;
    }

    public void setManager_job_information(String manager_job_information) {
        this.manager_job_information = manager_job_information;
    }

    public String getDesignation_job_information() {
        return designation_job_information;
    }

    public void setDesignation_job_information(String designation_job_information) {
        this.designation_job_information = designation_job_information;
    }

    public List<String> getSkill() {
        return skill;
    }

    public void setSkill(List<String> skill) {
        this.skill = skill;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getLinkedInlink() {
        return linkedInlink;
    }

    public void setLinkedInlink(String linkedInlink) {
        this.linkedInlink = linkedInlink;
    }

    @Override
    public String toString() {
        try {
            return new com.fasterxml.jackson.databind.ObjectMapper().writerWithDefaultPrettyPrinter()
                    .writeValueAsString(this);
        } catch (final com.fasterxml.jackson.core.JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}