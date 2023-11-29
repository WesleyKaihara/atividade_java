package com.trabalho.wesley.service;

import com.trabalho.wesley.Entity.Aluno;
import com.trabalho.wesley.Entity.AlunoCurso;
import com.trabalho.wesley.Entity.Curso;
import com.trabalho.wesley.Entity.Key.AlunoCursoKey;
import com.trabalho.wesley.dto.AlunoCurso.VincularAlunoCursoDto;
import com.trabalho.wesley.repository.AlunoCursoRepository;
import com.trabalho.wesley.repository.AlunoRepository;
import com.trabalho.wesley.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoCursoService {
    @Autowired
    AlunoCursoRepository alunoCursoRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    AlunoRepository alunoRepository;

    public List<AlunoCurso> listar() {
        return alunoCursoRepository.findAll();
    }

    public List<AlunoCurso> encontrarPorAlunoId(Integer alunoId) {
        return alunoCursoRepository.findAllByAluno_Id(alunoId);
    }

    public AlunoCurso salvar(VincularAlunoCursoDto vincularAlunoCursoDto) throws ChangeSetPersister.NotFoundException {
        Curso curso = cursoRepository.findById(vincularAlunoCursoDto.getCursoId()).orElseThrow(ChangeSetPersister.NotFoundException::new);
        cursoRepository.save(curso);

        Aluno aluno = alunoRepository.findById(vincularAlunoCursoDto.getAlunoId()).orElseThrow(ChangeSetPersister.NotFoundException::new);
        alunoRepository.save(aluno);

        System.out.println(curso.getNome());
        System.out.println(aluno.getNome());

        AlunoCursoKey alunoCursoKey = new AlunoCursoKey();
        alunoCursoKey.setAlunoId(aluno.getId());
        alunoCursoKey.setCursoId(curso.getId());


        AlunoCurso alunoCurso = new AlunoCurso();
        alunoCurso.setAlunoCurso(alunoCursoKey);
        alunoCurso.setAluno(aluno);
        alunoCurso.setCurso(curso);

        System.out.println();
        return alunoCursoRepository.save(alunoCurso);
    }

    public void remover(AlunoCurso alunoCurso) {
        alunoCursoRepository.delete(alunoCurso);
    }
}
