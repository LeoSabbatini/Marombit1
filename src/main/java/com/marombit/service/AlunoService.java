package com.marombit.service;

import com.marombit.exception.AlunoNotFoundException;
import com.marombit.exception.CpfJaCadastradoException;
import com.marombit.exception.PlanoNotFoundException;
import com.marombit.model.Aluno;
import com.marombit.model.Plano;
import com.marombit.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public List<Aluno> listarTodos(){
        return repository.findAll();
    }

    public Aluno criarAluno(Aluno aluno){
        if (repository.existsByCpf(aluno.getCpf())){
            throw new CpfJaCadastradoException(aluno.getCpf());
        }
        return repository.save(aluno);
    }
    public Aluno attAluno(Long id, Aluno aluno){
        Aluno alunoExist = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        alunoExist.setName(aluno.getName());
        alunoExist.setCpf(aluno.getCpf());
        alunoExist.setBData(aluno.getBData());
        alunoExist.setPlano(aluno.getPlano());
        alunoExist.setMtcAtiva(aluno.getMtcAtiva());

        return repository.save(alunoExist);
    }

    public Aluno listAlunoPorID(Long id){
        return repository.findById(id).orElseThrow(() -> new AlunoNotFoundException(id));
    }

    public void DelAluno (Long id){
        repository.findById(id).orElseThrow(() -> new AlunoNotFoundException(id));
        repository.deleteById(id);
    }

    public Aluno atualizarPlano(Long id,String plano){
        Aluno aluno = listAlunoPorID(id);
        aluno.setPlano(validarPlano(plano));
        return repository.save(aluno);
    }

    private Plano validarPlano(String plano){
        return Arrays.stream(Plano.values()).filter( p -> p.name().equalsIgnoreCase(plano))
                .findFirst().orElseThrow(()-> new PlanoNotFoundException(plano));
    }
}
