package com.marombit.controller;

import com.marombit.exception.CpfJaCadastradoException;
import com.marombit.model.Aluno;
import com.marombit.repository.AlunoRepository;
import com.marombit.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
@Tag(name = "Alunos", description = "Endpoints para o gerenciamento dos alunos da academia")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    @Operation(summary = "Listar todos os alunos", description = "Retorna uma lista completa de alunos cadastrados")
    public List<Aluno> listarTodos(){
        return alunoService.listarTodos();
    }

    @PostMapping
    @Operation(summary = "Cadastrar um novo aluno", description = "Cadastra um novo aluno na academia")
    @ApiResponse(responseCode = "200", description = "Retorna o aluno salvo")
    @ApiResponse(responseCode = "409", description = "CPF do aluno já cadastrado")
    public ResponseEntity<Aluno> criarAluno(@Valid @RequestBody Aluno aluno){
        return ResponseEntity.status(201).body(alunoService.criarAluno(aluno));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar as informações de uma aluno", description = "Recadastro das informações de um aluno da academia")
    public ResponseEntity<Aluno> attAluno(@Valid @PathVariable Long id, @RequestBody Aluno aluno){
        return ResponseEntity.ok(alunoService.attAluno(id, aluno));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um aluno", description = "Remove o aluno da lista de alunos")
    public ResponseEntity<Void> DelAluno (@PathVariable Long id){
        alunoService.DelAluno(id);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Listar  aluno por ID", description = "Retorna o aluno desejado")
    public ResponseEntity<Aluno> listAlunoPorID(@PathVariable Long id){
            return ResponseEntity.ok(alunoService.listAlunoPorID(id));
    }

    @GetMapping("/{id}/status")
    @Operation(summary = "Verificar matricula", description = "Verifica o status da matricula do aluno desejado")
    public ResponseEntity<String> mtcStatus(@PathVariable Long id){
        Aluno alun = alunoService.listAlunoPorID(id);

        if (alun.getMtcAtiva()){
            return ResponseEntity.ok("Matrícula_Ativa");
        }

        return ResponseEntity.ok("Matrícula_Inativa");
    }
}
