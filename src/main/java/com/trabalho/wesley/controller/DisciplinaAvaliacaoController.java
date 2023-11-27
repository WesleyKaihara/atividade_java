package com.trabalho.wesley.controller;

import com.trabalho.wesley.Entity.DisciplinaAvaliacao;
import com.trabalho.wesley.service.DisciplinaAvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/disciplina-avaliacoes")
public class DisciplinaAvaliacaoController {

    @Autowired
    private DisciplinaAvaliacaoService disciplinaAvaliacaoService;

    @GetMapping
    public ResponseEntity<List<DisciplinaAvaliacao>> listarAvaliacoes() {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaAvaliacaoService.listar());
    }

    @GetMapping("/{disciplinaId}")
    public ResponseEntity<Object> buscarAvaliacoesAlunoCurso(@PathVariable(value = "disciplinaId") Integer disciplinaId) {
        Optional<DisciplinaAvaliacao> d = disciplinaAvaliacaoService.encontrarPorId(disciplinaId);

        if(d.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(d);
        }

        DisciplinaAvaliacao disciplinaAvaliacao = d.get();
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaAvaliacao);
    }

    @PostMapping
    public ResponseEntity<DisciplinaAvaliacao> cadastrarAvaliacaoDisciplina(@RequestBody DisciplinaAvaliacao disciplinaAvaliacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaAvaliacaoService.salvar(disciplinaAvaliacao));
    }
}
