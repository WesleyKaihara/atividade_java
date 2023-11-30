package com.trabalho.wesley.controller;

import com.trabalho.wesley.dto.Boletim.BoletimAlunoCursoDisciplina;
import com.trabalho.wesley.service.BoletimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/boletim")
public class BoletinController {

    @Autowired
    private BoletimService boletimService;

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<BoletimAlunoCursoDisciplina>> apresentarBoletim(@PathVariable(value = "alunoId") Integer alunoId) {
        return ResponseEntity.status(HttpStatus.OK).body(boletimService.apresentar(alunoId));
    }
}
