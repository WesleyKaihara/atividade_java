package com.trabalho.wesley.service;

import com.trabalho.wesley.Entity.Disciplina;
import com.trabalho.wesley.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {
    @Autowired
    DisciplinaRepository disciplinaRepository;

    public List<Disciplina> listar() {
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> encontrarPorId(Integer id) {
        return disciplinaRepository.findById(id);
    }

    public Disciplina salvar(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

}
