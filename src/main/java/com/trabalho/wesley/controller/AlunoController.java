package com.trabalho.wesley.controller;

import com.trabalho.wesley.Entity.Aluno;
import com.trabalho.wesley.Entity.Disciplina;
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

    @PutMapping("/{alunoId}")
    public ResponseEntity<Object> atualizarAluno(@PathVariable(value = "alunoId") Integer alunoId, @RequestBody Aluno alunoBody) {
        Optional<Aluno> d = alunoService.encontrarPorId(alunoId);

        if(d.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(d);
        }

        Aluno aluno = d.get();
        aluno.setNome(alunoBody.getNome());
        aluno.setEmail(alunoBody.getEmail());

        return ResponseEntity.status(HttpStatus.OK).body(alunoService.salvar(aluno));
    }

    @DeleteMapping("/{alunoId}")
    public ResponseEntity<Object> removerAluno(@PathVariable(value = "alunoId") Integer alunoId) {
        Optional<Aluno> d = alunoService.encontrarPorId(alunoId);

        if(d.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(d);
        }

        Aluno aluno = d.get();
        alunoService.remover(aluno);
        return ResponseEntity.status(HttpStatus.OK).body("O(A) aluno(a) com " + aluno.getNome() + " foi removido(a)!!");
    }
}
