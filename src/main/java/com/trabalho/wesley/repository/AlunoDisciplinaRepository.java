package com.trabalho.wesley.repository;

import com.trabalho.wesley.Entity.Aluno;
import com.trabalho.wesley.Entity.AlunoDisciplina;
import com.trabalho.wesley.Entity.Disciplina;
import com.trabalho.wesley.Entity.Key.AlunoDisciplinaKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoDisciplinaRepository extends JpaRepository<AlunoDisciplina, Integer> {
    List<AlunoDisciplina> findAllByAlunoDisciplinaAlunoId(Integer alunoId);

    AlunoDisciplina findByAlunoDisciplina (AlunoDisciplinaKey alunoDisciplinaKey);
}
