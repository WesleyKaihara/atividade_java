package com.trabalho.wesley.service;

import com.trabalho.wesley.Entity.Aluno;
import com.trabalho.wesley.Entity.AlunoDisciplina;
import com.trabalho.wesley.Entity.Disciplina;
import com.trabalho.wesley.Entity.Key.AlunoDisciplinaKey;
import com.trabalho.wesley.dto.AlunoDisciplina.AtualizarAlunoDisciplinaDto;
import com.trabalho.wesley.repository.AlunoDisciplinaRepository;
import com.trabalho.wesley.repository.AlunoRepository;
import com.trabalho.wesley.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoDisciplinaService {
    @Autowired
    AlunoDisciplinaRepository alunoDisciplinaRepository;

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public List<AlunoDisciplina> listar() {
        return alunoDisciplinaRepository.findAll();
    }

    public List<AlunoDisciplina> listarDisciplinasAluno(Integer alunoId) {
        return alunoDisciplinaRepository.findAllByAlunoDisciplinaAlunoId(alunoId);
    }

    public AlunoDisciplina salvar(AlunoDisciplina alunoDisciplina) {
        return alunoDisciplinaRepository.save(alunoDisciplina);
    }

    public AlunoDisciplina atualizarNotaAluno(AtualizarAlunoDisciplinaDto atualizarAlunoDisciplinaDto) {
        Integer disciplinaId = atualizarAlunoDisciplinaDto.getDiscplinaId();
        Integer alunoId = atualizarAlunoDisciplinaDto.getAlunoId();

        Disciplina disciplina = disciplinaRepository.findById(disciplinaId).orElseThrow();
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();

        AlunoDisciplinaKey key = new AlunoDisciplinaKey();
        key.setDisciplina(disciplina);
        key.setAluno(aluno);
        key.setCurso(disciplina.getCurso());


        Float provas = 0f;
        Float trabalhos = 0f;

        if(atualizarAlunoDisciplinaDto.getProvas() != null) {
            provas = atualizarAlunoDisciplinaDto.getProvas();
        }

        if(atualizarAlunoDisciplinaDto.getTrabalhos() != null) {
            trabalhos = atualizarAlunoDisciplinaDto.getTrabalhos();
        }



        AlunoDisciplina a = alunoDisciplinaRepository.findByAlunoDisciplina(key);
        a.setTrabalhos(trabalhos);
        a.setProvas(provas);
        a.setRecuperacao(a.getRecuperacao());

        return alunoDisciplinaRepository.save(a);
    }

    public void remover(AlunoDisciplina alunoDisciplina) {
        alunoDisciplinaRepository.delete(alunoDisciplina);
    }
}
