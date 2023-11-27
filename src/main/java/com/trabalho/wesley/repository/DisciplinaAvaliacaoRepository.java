package com.trabalho.wesley.repository;

import com.trabalho.wesley.Entity.DisciplinaAvaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaAvaliacaoRepository extends JpaRepository<DisciplinaAvaliacao, Integer> {
}
