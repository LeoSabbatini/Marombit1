package com.marombit.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Por favor, insira um nome")
    private String name;

    @NotBlank(message = "Por favor, insira um cpf")
    @Column(unique = true)
    private String cpf;

    @NotBlank(message = "Por favor, insira sua data de nascimento")
    private LocalDate bData;

    @NotBlank(message = "A matrícula ativa é obrigatória")
    private Boolean mtcAtiva;

    @NotBlank(message = "Por favor, insira qual o plano")
    @Enumerated(EnumType.STRING)
    private Plano plano;
}
