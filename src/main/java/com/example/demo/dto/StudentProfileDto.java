package com.example.demo.dto;

public class StudentProfileDto {
    private String name;
    private Integer age;
    private String course;
    private Integer yearOfStudy;
    private String gender;
    private String roomTypePreference;

    // Standard Getters and Setters for all fields
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    public Integer getYearOfStudy() { return yearOfStudy; }
    public void setYearOfStudy(Integer yearOfStudy) { this.yearOfStudy = yearOfStudy; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getRoomTypePreference() { return roomTypePreference; }
    public void setRoomTypePreference(String roomTypePreference) { this.roomTypePreference = roomTypePreference; }
}