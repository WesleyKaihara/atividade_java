package com.trabalho.wesley.controller;

import com.trabalho.wesley.Entity.AlunoDisciplinaAvaliacao;
import com.trabalho.wesley.service.AlunoDisciplinaAvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/alunos-disciplina-avaliacoes")
public class AlunoDisciplinaAvaliacaoController {

    @Autowired
    private AlunoDisciplinaAvaliacaoService alunoDisciplinaAvaliacaoService;

    @GetMapping
    public ResponseEntity<List<AlunoDisciplinaAvaliacao>> listarAvaliacoes() {
        return ResponseEntity.status(HttpStatus.OK).body(alunoDisciplinaAvaliacaoService.listar());
    }

    @GetMapping("/{alunoId}/{cursoId}")
    public ResponseEntity<Object> buscarAvaliacoesAlunoCurso(@PathVariable(value = "alunoId") Integer alunoId, @PathVariable(value = "cursoId") Integer cursoId) {
        Optional<AlunoDisciplinaAvaliacao> a = alunoDisciplinaAvaliacaoService.encontrarPorId(alunoId);

        if(a.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(a);
        }

        AlunoDisciplinaAvaliacao alunoDisciplinaAvaliacao = a.get();
        return ResponseEntity.status(HttpStatus.OK).body(alunoDisciplinaAvaliacao);
    }

    @PostMapping
    public ResponseEntity<AlunoDisciplinaAvaliacao> cadastrarAlunoDisciplinaAvaliacao(@RequestBody AlunoDisciplinaAvaliacao alunoDisciplinaAvaliacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoDisciplinaAvaliacaoService.salvar(alunoDisciplinaAvaliacao));
    }
}
