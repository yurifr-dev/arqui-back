package com.ucsal.arqui_back.domain.model;

@Entity
public class EspacoAcademico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sigla;
    private String nome;
    private String descricao;
    private Integer capacidade;
    private String tipo; // Ex: Sala, Laboratório etc.

    // Getters e setters
}

}
