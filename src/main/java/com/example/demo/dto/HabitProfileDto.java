package com.example.demo.dto;

public class HabitProfileDto {
    private Integer cleanlinessLevel;
    private Integer noisePreference;
    private String sleepTime;
    private String wakeTime;
    private String studyStyle;

    // Getters and Setters
    public Integer getCleanlinessLevel() { return cleanlinessLevel; }
    public void setCleanlinessLevel(Integer cleanlinessLevel) { this.cleanlinessLevel = cleanlinessLevel; }
    public Integer getNoisePreference() { return noisePreference; }
    public void setNoisePreference(Integer noisePreference) { this.noisePreference = noisePreference; }
    public String getSleepTime() { return sleepTime; }
    public void setSleepTime(String sleepTime) { this.sleepTime = sleepTime; }
    public String getWakeTime() { return wakeTime; }
    public void setWakeTime(String wakeTime) { this.wakeTime = wakeTime; }
    public String getStudyStyle() { return studyStyle; }
    public void setStudyStyle(String studyStyle) { this.studyStyle = studyStyle; }
}