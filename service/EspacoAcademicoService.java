package com.ucsal.arqui_back.service;

@Service
public class EspacoAcademicoService {

    @Autowired
    private EspacoAcademicoRepository repository;

    public EspacoAcademico salvar(EspacoAcademico espaco) {
        return repository.save(espaco);
    }

    public List<EspacoAcademico> listarTodos() {
        return repository.findAll();
    }

    public Optional<EspacoAcademico> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
