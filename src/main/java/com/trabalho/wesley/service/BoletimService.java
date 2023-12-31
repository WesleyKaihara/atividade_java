package com.trabalho.wesley.service;

import com.trabalho.wesley.Entity.AlunoDisciplina;
import com.trabalho.wesley.Entity.Key.AlunoDisciplinaKey;
import com.trabalho.wesley.dto.Boletim.BoletimAlunoCursoDisciplina;
import com.trabalho.wesley.repository.AlunoDisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoletimService {

    @Autowired
    private AlunoDisciplinaRepository alunoDisciplinaRepository;

    public List<BoletimAlunoCursoDisciplina> apresentar(Integer alunoId) {
        List<AlunoDisciplina> disciplinasAluno = alunoDisciplinaRepository.findAllByAlunoDisciplinaAlunoId(alunoId);

        List<BoletimAlunoCursoDisciplina> boletimAluno = new ArrayList<>();

        for (AlunoDisciplina alunoDisciplina: disciplinasAluno) {
            AlunoDisciplinaKey key = alunoDisciplina.getAlunoDisciplina();

            BoletimAlunoCursoDisciplina itemBoletim = new BoletimAlunoCursoDisciplina();
            itemBoletim.setCurso(key.getCurso());
            itemBoletim.setAlunoDisciplina(alunoDisciplina);

            String status;

            if(alunoDisciplina.getProvas() == null && alunoDisciplina.getTrabalhos() == null) {
                status = "ativo";
            } else {
                status = getStatusDisciplina(calculaNotaFinal(alunoDisciplina));
            }

            itemBoletim.setStatus(status);

            boletimAluno.add(itemBoletim);
        }


        return boletimAluno;
    }

    private String getStatusDisciplina(Float notaFinal) {
        if(notaFinal >= 70) {
            return "Aprovado";
        } else if(notaFinal >= 40) {
            return "Recuperação";
        }
        return "Reprovado";
    }

    private Float calculaNotaFinal(AlunoDisciplina alunoDisciplina) {
        Float trabalhos = 0f;
        Float provas = 0f;

        if(alunoDisciplina.getTrabalhos() != null) {
            trabalhos = alunoDisciplina.getTrabalhos();
        }

        if(alunoDisciplina.getProvas() != null) {
            provas = alunoDisciplina.getProvas();
        }

        Float notaAluno = trabalhos + provas;

        boolean realizouRecuperacao = alunoDisciplina.getRecuperacao() != null;

        if(realizouRecuperacao && alunoDisciplina.getRecuperacao() > notaAluno) {
            return alunoDisciplina.getRecuperacao();
        }

        return notaAluno;
    }
}
