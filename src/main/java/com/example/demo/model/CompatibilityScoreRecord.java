@Entity
@Data
public class CompatibilityScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;
    private Double score;

    @Enumerated(EnumType.STRING)
    private CompatibilityLevel compatibilityLevel;

    private LocalDateTime computedAt;
    private String detailsJson;

    public enum CompatibilityLevel {
        LOW, MEDIUM, HIGH, EXCELLENT
    }
}
