package com.trabalho.wesley.service;

import com.trabalho.wesley.Entity.AlunoDisciplinaAvaliacao;
import com.trabalho.wesley.repository.AlunoDisciplinaAvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoDisciplinaAvaliacaoService {
    @Autowired
    AlunoDisciplinaAvaliacaoRepository alunoDisciplinaAvaliacaoRepository;

    public List<AlunoDisciplinaAvaliacao> listar() {
        return alunoDisciplinaAvaliacaoRepository.findAll();
    }

    public Optional<AlunoDisciplinaAvaliacao> encontrarPorId(Integer id) {
        return alunoDisciplinaAvaliacaoRepository.findById(id);
    }

    public AlunoDisciplinaAvaliacao salvar(AlunoDisciplinaAvaliacao alunoDisciplinaAvaliacao) {
        return alunoDisciplinaAvaliacaoRepository.save(alunoDisciplinaAvaliacao);
    }

}
