package com.ucsal.arqui_back.domain.repository;
@Repository
public interface EspacoAcademicoRepository extends JpaRepository<EspacoAcademico, Long> {
    Optional<EspacoAcademico> findBySigla(String sigla);
}
