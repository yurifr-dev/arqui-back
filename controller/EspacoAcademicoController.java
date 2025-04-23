package com.ucsal.arqui_back.controller;

@RestController
@RequestMapping("/espacos")
public class EspacoAcademicoController {

    @Autowired
    private EspacoAcademicoService service;

    @PostMapping
    public ResponseEntity<EspacoAcademico> cadastrar(@RequestBody EspacoAcademico espaco) {
        EspacoAcademico salvo = service.salvar(espaco);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<EspacoAcademico>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
