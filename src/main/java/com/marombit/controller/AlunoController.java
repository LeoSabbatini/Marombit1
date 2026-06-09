package com.marombit.controller;

import com.marombit.model.Aluno;
import com.marombit.repository.AlunoRepository;
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
    private AlunoRepository repository;

    @GetMapping
    public List<Aluno> listarTodos(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Aluno> criarAluno(@Valid @RequestBody Aluno aluno){
        var salvo = repository.save(aluno);
        return ResponseEntity.status(201).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> attAluno(@Valid @PathVariable Long id, @RequestBody Aluno aluno){
        Optional<Aluno> alunoExist = repository.findById(id);
        if (alunoExist.isPresent()){
            Aluno alunoAtt = alunoExist.get();
            alunoAtt.setName(aluno.getName());
            alunoAtt.setCpf(aluno.getCpf());
            alunoAtt.setBData(aluno.getBData());
            alunoAtt.setPlano(aluno.getPlano());
            alunoAtt.setMtcAtiva(aluno.getMtcAtiva());

            Aluno salvo = repository.save(alunoAtt);
            return ResponseEntity.ok(salvo);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Aluno> DelAluno (@PathVariable Long id){
        if (!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return  ResponseEntity.status(204).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> listAlunoPorID(@PathVariable Long id){
        Optional<Aluno> alun = repository.findById(id);
        if (alun.isPresent()){
            return ResponseEntity.ok(alun.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<String> mtcStatus(@PathVariable Long id){
        Optional<Aluno> alun = repository.findById(id);

        if (!alun.isPresent()){
            return ResponseEntity.notFound().build();
        }

        if (alun.get().getMtcAtiva() == true){
            return ResponseEntity.ok("Matrícula_Ativa");
        }

        return ResponseEntity.ok("Matrícula_Inativa");
    }
}
