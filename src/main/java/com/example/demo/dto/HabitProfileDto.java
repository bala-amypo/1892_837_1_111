@Entity
@Table(name = "habit_profiles")
public class HabitProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long studentId; // Link to StudentProfile ID

    @Enumerated(EnumType.STRING)
    private SleepSchedule sleepSchedule; // EARLY, REGULAR, LATE

    private Integer studyHoursPerDay;

    @Enumerated(EnumType.STRING)
    private Level cleanlinessLevel; // LOW, MEDIUM, HIGH

    // Add other fields: noiseTolerance, socialPreference, etc.
    
    private LocalDateTime updatedAt = LocalDateTime.now();

    // Getters and Setters...
}