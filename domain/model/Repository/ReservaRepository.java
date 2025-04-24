@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByEspacoAndData(EspacoAcademico espaco, LocalDate data);

    boolean existsByProfessorAndDataAndHorarioInicioAndHorarioFim(
            String professor, LocalDate data, LocalTime inicio, LocalTime fim
    );
}
