package com.trabalho.wesley.controller;

import com.trabalho.wesley.Entity.Curso;
import com.trabalho.wesley.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos() {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarCursoPorId(@PathVariable(value = "id") Integer cursoId) {
        Optional<Curso> c = cursoService.encontrarPorId(cursoId);

        if(c.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(c);
        }

        Curso curso = c.get();
        return ResponseEntity.status(HttpStatus.OK).body(curso);
    }

    @PostMapping
    public ResponseEntity<Curso> cadadastrarCurso(@RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.salvar(curso));
    }

    @PutMapping("/{cursoId}")
    public ResponseEntity<Object> atualizarCurso(@PathVariable(value = "cursoId") Integer cursoId, @RequestBody Curso cursoBody) {
        Optional<Curso> c = cursoService.encontrarPorId(cursoId);

        if(c.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(c);
        }

        Curso cursoAtualizado = c.get();
        cursoAtualizado.setNome(cursoBody.getNome());
        cursoAtualizado.setDuracao(cursoBody.getDuracao());


        return ResponseEntity.status(HttpStatus.OK).body(cursoService.salvar(cursoAtualizado));
    }

    @DeleteMapping("/{cursoId}")
    public ResponseEntity<Object> removerCurso(@PathVariable(value = "cursoId") Integer cursoId) {
        Optional<Curso> c = cursoService.encontrarPorId(cursoId);

        if(c.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(c);
        }

        Curso curso = c.get();
        cursoService.remover(curso);
        return ResponseEntity.status(HttpStatus.OK).body("O curso " + curso.getNome() + "foi removido!!");
    }
}
