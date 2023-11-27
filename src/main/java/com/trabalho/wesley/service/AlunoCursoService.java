package com.trabalho.wesley.service;

import com.trabalho.wesley.Entity.AlunoCurso;
import com.trabalho.wesley.repository.AlunoCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoCursoService {
    @Autowired
    AlunoCursoRepository alunoCursoRepository;

    public List<AlunoCurso> listar() {
        return alunoCursoRepository.findAll();
    }

    public List<AlunoCurso> encontrarPorAlunoId(Integer alunoId) {
        return alunoCursoRepository.findAllByAluno_Id(alunoId);
    }

    public AlunoCurso salvar(AlunoCurso alunoCurso) {
        return alunoCursoRepository.save(alunoCurso);
    }

}
