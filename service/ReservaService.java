@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private EspacoAcademicoRepository espacoRepository;

    public Reserva realizarReserva(ReservaDTO dto) {
        EspacoAcademico espaco = espacoRepository.findById(dto.getEspacoId())
                .orElseThrow(() -> new RuntimeException("Espaço não encontrado"));


        boolean existe = reservaRepository.existsByProfessorAndDataAndHorarioInicioAndHorarioFim(
                dto.getProfessor(), dto.getData(), dto.getHorarioInicio(), dto.getHorarioFim()
        );
        if (existe) throw new RuntimeException("Já existe uma reserva para este professor neste horário");


        Reserva reserva = new Reserva();
        reserva.setProfessor(dto.getProfessor());
        reserva.setEspaco(espaco);
        reserva.setData(dto.getData());
        reserva.setHorarioInicio(dto.getHorarioInicio());
        reserva.setHorarioFim(dto.getHorarioFim());
        reserva.setStatus(Reserva.StatusReserva.PENDENTE);

        return reservaRepository.save(reserva);
    }

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    public Reserva atualizarStatus(Long id, Reserva.StatusReserva status) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
        reserva.setStatus(status);
        return reservaRepository.save(reserva);
    }

    public void cancelarReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
        reserva.setStatus(Reserva.StatusReserva.CANCELADA);
        reservaRepository.save(reserva);
    }
}
