package com.marombit.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String cpf;
    private LocalDate bData;
    private Boolean mtcAtiva;
    @Enumerated(EnumType.STRING)
    private Plano plano;
}
