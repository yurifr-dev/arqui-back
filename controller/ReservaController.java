@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @PostMapping
    public ResponseEntity<?> solicitarReserva(@RequestBody ReservaDTO dto) {
        try {
            Reserva reserva = service.realizarReserva(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> listar() {
        return ResponseEntity.ok(service.listarReservas());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Reserva> atualizarStatus(@PathVariable Long id, @RequestParam Reserva.StatusReserva status) {
        return ResponseEntity.ok(service.atualizarStatus(id, status));
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelar(@PathVariable Long id) {
        service.cancelarReserva(id);
        return ResponseEntity.noContent().build();
    }
}
