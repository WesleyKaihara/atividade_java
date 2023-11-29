package com.trabalho.wesley.controller;


import com.trabalho.wesley.Entity.Curso;
import com.trabalho.wesley.Entity.Disciplina;
import com.trabalho.wesley.dto.Disciplina.VincularDisciplinaDto;
import com.trabalho.wesley.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
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
    public ResponseEntity<Disciplina> cadastrarDisciplina(@RequestBody VincularDisciplinaDto vincularDisciplinaDto) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.salvar(vincularDisciplinaDto));
    }

    @PutMapping("/{disciplinaId}")
    public ResponseEntity<Object> atualizarDisciplina(@PathVariable(value = "disciplinaId") Integer disciplinaId, @RequestBody Disciplina disciplinaBody) {
        Optional<Disciplina> d = disciplinaService.encontrarPorId(disciplinaId);

        if(d.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(d);
        }

        Disciplina disciplina = d.get();
        disciplina.setNome(disciplinaBody.getNome());

        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.atualizar(disciplina));
    }

    @DeleteMapping("/{disciplinaId}")
    public ResponseEntity<Object> removerDisciplina(@PathVariable(value = "disciplinaId") Integer disciplinaId) {
        Optional<Disciplina> d = disciplinaService.encontrarPorId(disciplinaId);

        if(d.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(d);
        }

        Disciplina disciplina = d.get();
        disciplinaService.remover(disciplina);
        return ResponseEntity.status(HttpStatus.OK).body("A disciplina " + disciplina.getNome() + " foi removida!!");
    }
}
