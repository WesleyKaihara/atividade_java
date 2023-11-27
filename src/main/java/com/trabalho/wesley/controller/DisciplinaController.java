package com.trabalho.wesley.controller;


import com.trabalho.wesley.Entity.Curso;
import com.trabalho.wesley.Entity.Disciplina;
import com.trabalho.wesley.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/disciplinas")
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity<List<Disciplina>> listarDisciplinas() {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarDisciplinaPorId(@PathVariable(value = "id") Integer disciplinaId) {
        Optional<Disciplina> d = disciplinaService.encontrarPorId(disciplinaId);

        if(d.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(d);
        }

        Disciplina disciplina = d.get();
        return ResponseEntity.status(HttpStatus.OK).body(disciplina);
    }

    @PostMapping
    public ResponseEntity<Disciplina> cadastrarDisciplina(@RequestBody Disciplina disciplina) {
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.salvar(disciplina));
    }
}
