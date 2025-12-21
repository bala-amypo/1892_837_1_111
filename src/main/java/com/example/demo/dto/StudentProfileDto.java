@Entity
@Table(name = "student_profiles")
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String studentId;

    private String fullName;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    private String department;
    private Integer yearLevel;
    private Boolean active;
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters...
}