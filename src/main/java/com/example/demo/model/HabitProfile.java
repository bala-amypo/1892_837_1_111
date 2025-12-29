package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SleepSchedule sleepSchedule;

    @Enumerated(EnumType.STRING)
    private CleanlinessLevel cleanlinessLevel;

    @Enumerated(EnumType.STRING)
    private NoiseTolerance noiseTolerance;

    @Enumerated(EnumType.STRING)
    private SocialPreference socialPreference;

    /* ===== INNER ENUMS (TESTS EXPECT THIS) ===== */

    public enum SleepSchedule {
        EARLY_BIRD,
        NIGHT_OWL
    }

    public enum CleanlinessLevel {
        LOW,
        MEDIUM,
        HIGH
    }

    public enum NoiseTolerance {
        LOW,
        MEDIUM,
        HIGH
    }

    public enum SocialPreference {
        INTROVERT,
        AMBIVERT,
        EXTROVERT
    }

    /* ===== Getters & Setters ===== */

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public SleepSchedule getSleepSchedule() { return sleepSchedule; }
    public void setSleepSchedule(SleepSchedule sleepSchedule) { this.sleepSchedule = sleepSchedule; }

    public CleanlinessLevel getCleanlinessLevel() { return cleanlinessLevel; }
    public void setCleanlinessLevel(CleanlinessLevel cleanlinessLevel) { this.cleanlinessLevel = cleanlinessLevel; }

    public NoiseTolerance getNoiseTolerance() { return noiseTolerance; }
    public void setNoiseTolerance(NoiseTolerance noiseTolerance) { this.noiseTolerance = noiseTolerance; }

    public SocialPreference getSocialPreference() { return socialPreference; }
    public void setSocialPreference(SocialPreference socialPreference) { this.socialPreference = socialPreference; }
}
