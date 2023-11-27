package com.trabalho.wesley.service;

import com.trabalho.wesley.Entity.AlunoDisciplinaAvaliacao;
import com.trabalho.wesley.Entity.DisciplinaAvaliacao;
import com.trabalho.wesley.repository.AlunoDisciplinaAvaliacaoRepository;
import com.trabalho.wesley.repository.DisciplinaAvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaAvaliacaoService {
    @Autowired
    DisciplinaAvaliacaoRepository disciplinaAvaliacaoRepository;

    public List<DisciplinaAvaliacao> listar() {
        return disciplinaAvaliacaoRepository.findAll();
    }

    public Optional<DisciplinaAvaliacao> encontrarPorId(Integer id) {
        return disciplinaAvaliacaoRepository.findById(id);
    }

    public DisciplinaAvaliacao salvar(DisciplinaAvaliacao disciplinaAvaliacao) {
        return disciplinaAvaliacaoRepository.save(disciplinaAvaliacao);
    }

}
