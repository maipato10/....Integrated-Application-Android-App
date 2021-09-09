package com.example.intergratedapplicationhub.entities;

import java.util.Date;

public class Application {
    private String mark1,mark2,mark3,mark4,mark5,mark6,mark7,metricMark1,metricMark2,metricMark3,metricMark4,metricMark5,metricMark6,metricMark7;
    private String subject1,subject2,subject3,subject4,subject5,subject6,subject7,metricSubject1,metricSubject2,metricSubject3,metricSubject4,metricSubject5,metricSubject6,metricSubject7;
    private  String userEmail,objectId;
    private String ResidenceStatus;
    private Date created;
    private Date updated;
    private String universityName;
    private String universityCampus;
    private String applicationStatus;
    private String courses;
    private String residence;

    private String ID;
    private String houseNumber;
    private String lastName;
    private String streetName;
    private String town;
    private String city;
    private String zipCode;
    private String title;
    private String homeLanguage;
    private String gender;
    private String name;
    private String firstChoice;
    private String secondChoice;
    private String firstChoiceStatus;
    private String secondChoiceStatus;

    public Application() {
    }


    public String getSecondChoiceStatus() {
        return secondChoiceStatus;
    }

    public void setSecondChoiceStatus(String secondChoiceStatus) {
        this.secondChoiceStatus = secondChoiceStatus;
    }

    public String getFirstChoiceStatus() {
        return firstChoiceStatus;
    }

    public void setFirstChoiceStatus(String firstChoiceStatus) {
        this.firstChoiceStatus = firstChoiceStatus;
    }

    public String getFirstChoice() {
        return firstChoice;
    }

    public void setFirstChoice(String firstChoice) {
        this.firstChoice = firstChoice;
    }

    public String getSecondChoice() {
        return secondChoice;
    }

    public void setSecondChoice(String secondChoice) {
        this.secondChoice = secondChoice;
    }

    public String getSubject1() {
        return subject1;
    }

    public void setSubject1(String subject1) {
        this.subject1 = subject1;
    }

    public String getSubject2() {
        return subject2;
    }

    public void setSubject2(String subject2) {
        this.subject2 = subject2;
    }

    public String getSubject3() {
        return subject3;
    }

    public void setSubject3(String subject3) {
        this.subject3 = subject3;
    }

    public String getSubject4() {
        return subject4;
    }

    public void setSubject4(String subject4) {
        this.subject4 = subject4;
    }

    public String getSubject5() {
        return subject5;
    }

    public void setSubject5(String subject5) {
        this.subject5 = subject5;
    }

    public String getSubject6() {
        return subject6;
    }

    public void setSubject6(String subject6) {
        this.subject6 = subject6;
    }

    public String getSubject7() {
        return subject7;
    }

    public void setSubject7(String subject7) {
        this.subject7 = subject7;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHomeLanguage() {
        return homeLanguage;
    }

    public void setHomeLanguage(String homeLanguage) {
        this.homeLanguage = homeLanguage;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }


    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void setResidence(String residence )
    {
       this.residence = residence;
    }
    public String getResidence()
    {
        return residence;
    }
    public String getUniversityCampus() {
        return universityCampus;
    }

    public void setUniversityCampus(String universityCampus) {
        this.universityCampus = universityCampus;
    }

    public String getMark1() {
        return mark1;
    }

    public void setMark1(String mark1) {
        this.mark1 = mark1;
    }

    public String getMark2() {
        return mark2;
    }

    public void setMark2(String mark2) {
        this.mark2 = mark2;
    }

    public String getMark3() {
        return mark3;
    }

    public void setMark3(String mark3) {
        this.mark3 = mark3;
    }

    public String getMark4() {
        return mark4;
    }

    public void setMark4(String mark4) {
        this.mark4 = mark4;
    }

    public String getMark5() {
        return mark5;
    }

    public void setMark5(String mark5) {
        this.mark5 = mark5;
    }

    public String getMark6() {
        return mark6;
    }

    public void setMark6(String mark6) {
        this.mark6 = mark6;
    }

    public String getMark7() {
        return mark7;
    }

    public void setMark7(String mark7) {
        this.mark7 = mark7;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getMetricMark1() {
        return metricMark1;
    }

    public void setMetricMark1(String metricMark1) {
        this.metricMark1 = metricMark1;
    }

    public String getMetricMark2() {
        return metricMark2;
    }

    public void setMetricMark2(String metricMark2) {
        this.metricMark2 = metricMark2;
    }

    public String getMetricMark3() {
        return metricMark3;
    }

    public void setMetricMark3(String metricMark3) {
        this.metricMark3 = metricMark3;
    }

    public String getMetricMark4() {
        return metricMark4;
    }

    public void setMetricMark4(String metricMark4) {
        this.metricMark4 = metricMark4;
    }

    public String getMetricMark5() {
        return metricMark5;
    }

    public void setMetricMark5(String metricMark5) {
        this.metricMark5 = metricMark5;
    }

    public String getMetricMark6() {
        return metricMark6;
    }

    public void setMetricMark6(String metricMark6) {
        this.metricMark6 = metricMark6;
    }

    public String getMetricMark7() {
        return metricMark7;
    }

    public void setMetricMark7(String metricMark7) {
        this.metricMark7 = metricMark7;
    }

    public String getMetricSubject1() {
        return metricSubject1;
    }

    public void setMetricSubject1(String metricSubject1) {
        this.metricSubject1 = metricSubject1;
    }

    public String getMetricSubject2() {
        return metricSubject2;
    }

    public void setMetricSubject2(String metricSubject2) {
        this.metricSubject2 = metricSubject2;
    }

    public String getMetricSubject3() {
        return metricSubject3;
    }

    public void setMetricSubject3(String metricSubject3) {
        this.metricSubject3 = metricSubject3;
    }

    public String getMetricSubject4() {
        return metricSubject4;
    }

    public void setMetricSubject4(String metricSubject4) {
        this.metricSubject4 = metricSubject4;
    }

    public String getMetricSubject5() {
        return metricSubject5;
    }

    public void setMetricSubject5(String metricSubject5) {
        this.metricSubject5 = metricSubject5;
    }

    public String getMetricSubject6() {
        return metricSubject6;
    }

    public void setMetricSubject6(String metricSubject6) {
        this.metricSubject6 = metricSubject6;
    }

    public String getMetricSubject7() {
        return metricSubject7;
    }

    public void setMetricSubject7(String metricSubject7) {
        this.metricSubject7 = metricSubject7;
    }


    public String getResidenceStatus() {
        return ResidenceStatus;
    }

    public void setResidenceStatus(String residenceStatus) {
        ResidenceStatus = residenceStatus;
    }
}
