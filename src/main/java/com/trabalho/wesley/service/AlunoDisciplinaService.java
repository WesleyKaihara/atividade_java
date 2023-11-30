package com.trabalho.wesley.service;

import com.trabalho.wesley.Entity.Aluno;
import com.trabalho.wesley.Entity.AlunoDisciplina;
import com.trabalho.wesley.repository.AlunoDisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoDisciplinaService {
    @Autowired
    AlunoDisciplinaRepository alunoDisciplinaRepository;

    public List<AlunoDisciplina> listar() {
        return alunoDisciplinaRepository.findAll();
    }

    public List<AlunoDisciplina> listarDisciplinasAluno(Integer alunoId) {
        return alunoDisciplinaRepository.findAllByAlunoDisciplinaAlunoId(alunoId);
    }

    public AlunoDisciplina salvar(AlunoDisciplina alunoDisciplina) {
        return alunoDisciplinaRepository.save(alunoDisciplina);
    }

    public void remover(AlunoDisciplina alunoDisciplina) {
        alunoDisciplinaRepository.delete(alunoDisciplina);
    }
}
