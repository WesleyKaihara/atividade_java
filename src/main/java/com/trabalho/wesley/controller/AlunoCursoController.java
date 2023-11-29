package com.trabalho.wesley.controller;

import com.trabalho.wesley.Entity.Aluno;
import com.trabalho.wesley.Entity.AlunoCurso;
import com.trabalho.wesley.dto.AlunoCurso.VincularAlunoCursoDto;
import com.trabalho.wesley.service.AlunoCursoService;
import com.trabalho.wesley.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/alunos-cursos")
public class AlunoCursoController {

    @Autowired
    private AlunoCursoService alunoCursoService;

    @GetMapping
    public ResponseEntity<List<AlunoCurso>> listarAlunos() {
        return ResponseEntity.status(HttpStatus.OK).body(alunoCursoService.listar());
    }

    @GetMapping("/by/aluno/{alunoId}")
    public ResponseEntity<Object> buscarAlunoCursoPorAlunoId(@PathVariable(value = "alunoId") Integer alunoId) {
        List<AlunoCurso> alunoCursos = alunoCursoService.encontrarPorAlunoId(alunoId);

        return ResponseEntity.status(HttpStatus.OK).body(alunoCursos);
    }

    @PostMapping
    public ResponseEntity<AlunoCurso> adicionarAlunoCurso(@RequestBody VincularAlunoCursoDto vincularAlunoCursoDto) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoCursoService.salvar(vincularAlunoCursoDto));
    }
}
