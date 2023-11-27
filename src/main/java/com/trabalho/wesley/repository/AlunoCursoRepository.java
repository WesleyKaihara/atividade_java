package com.trabalho.wesley.repository;

import com.trabalho.wesley.Entity.AlunoCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoCursoRepository extends JpaRepository<AlunoCurso, Integer> {
    List<AlunoCurso> findAllByAluno_Id(Integer id);
}
