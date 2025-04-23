@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String professor;

    private LocalDate data;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;

    @Enumerated(EnumType.STRING)
    private StatusReserva status;

    @ManyToOne
    private EspacoAcademico espaco;

    public enum StatusReserva {
        PENDENTE, APROVADA, REJEITADA, CANCELADA
    }

}
