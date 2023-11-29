package com.trabalho.wesley.service;

import com.trabalho.wesley.Entity.Curso;
import com.trabalho.wesley.Entity.Disciplina;
import com.trabalho.wesley.dto.Disciplina.VincularDisciplinaDto;
import com.trabalho.wesley.repository.CursoRepository;
import com.trabalho.wesley.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {
    @Autowired
    DisciplinaRepository disciplinaRepository;

    @Autowired
    CursoRepository cursoRepository;

    public List<Disciplina> listar() {
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> encontrarPorId(Integer id) {
        return disciplinaRepository.findById(id);
    }

    public Disciplina salvar(VincularDisciplinaDto vincularDisciplinaDto) throws ChangeSetPersister.NotFoundException {
        Curso curso = cursoRepository.findById(vincularDisciplinaDto.getCursoId()).orElseThrow(ChangeSetPersister.NotFoundException::new);
        cursoRepository.save(curso);

        Disciplina disciplina = vincularDisciplinaDto.getDisciplina();
        disciplina.setCurso(curso);
        System.out.println(disciplina.getCurso().getNome());
        return disciplinaRepository.save(vincularDisciplinaDto.getDisciplina());
    }

    public Disciplina atualizar(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public void remover(Disciplina disciplina) {
        disciplinaRepository.delete(disciplina);
    }
}
