package com.trabalho.wesley.service;

import com.trabalho.wesley.Entity.Aluno;
import com.trabalho.wesley.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;

    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> encontrarPorId(Integer id) {
        return alunoRepository.findById(id);
    }

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

}
