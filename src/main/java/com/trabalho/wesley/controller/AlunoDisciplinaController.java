package com.trabalho.wesley.controller;

import com.trabalho.wesley.Entity.AlunoCurso;
import com.trabalho.wesley.Entity.AlunoDisciplina;
import com.trabalho.wesley.service.AlunoCursoService;
import com.trabalho.wesley.service.AlunoDisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alunos-disciplinas")
public class AlunoDisciplinaController {

    @Autowired
    private AlunoDisciplinaService alunoDisciplinaService;

    @GetMapping
    public ResponseEntity<List<AlunoDisciplina>> listarAlunosDisciplinas() {
        return ResponseEntity.status(HttpStatus.OK).body(alunoDisciplinaService.listar());
    }

    @PostMapping
    public ResponseEntity<AlunoDisciplina> adicionarDisciplinaAluno(@RequestBody AlunoDisciplina alunoDisciplina) {
        System.out.println(alunoDisciplina);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoDisciplinaService.salvar(alunoDisciplina));
    }
}
