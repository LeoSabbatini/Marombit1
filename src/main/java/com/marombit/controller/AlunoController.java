package com.marombit.controller;

import com.marombit.exception.CpfJaCadastradoException;
import com.marombit.model.Aluno;
import com.marombit.repository.AlunoRepository;
import com.marombit.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> listarTodos(){
        return alunoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Aluno> criarAluno(@Valid @RequestBody Aluno aluno){
        return ResponseEntity.status(201).body(alunoService.criarAluno(aluno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> attAluno(@Valid @PathVariable Long id, @RequestBody Aluno aluno){
        return ResponseEntity.ok(alunoService.attAluno(id, aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DelAluno (@PathVariable Long id){
        alunoService.DelAluno(id);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> listAlunoPorID(@PathVariable Long id){
            return ResponseEntity.ok(alunoService.listAlunoPorID(id));
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<String> mtcStatus(@PathVariable Long id){
        Aluno alun = alunoService.listAlunoPorID(id);

        if (alun.getMtcAtiva()){
            return ResponseEntity.ok("Matrícula_Ativa");
        }

        return ResponseEntity.ok("Matrícula_Inativa");
    }
}
