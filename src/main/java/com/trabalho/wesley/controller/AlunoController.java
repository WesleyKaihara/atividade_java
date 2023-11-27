package com.trabalho.wesley.controller;

import com.trabalho.wesley.Entity.Aluno;
import com.trabalho.wesley.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> listarAlunos() {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarAlunoPorId(@PathVariable(value = "id") Integer cursoId) {
        Optional<Aluno> a = alunoService.encontrarPorId(cursoId);

        if(a.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(a);
        }

        Aluno aluno = a.get();
        return ResponseEntity.status(HttpStatus.OK).body(aluno);
    }

    @PostMapping
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.salvar(aluno));
    }
}
