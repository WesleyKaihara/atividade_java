package com.trabalho.wesley.repository;

import com.trabalho.wesley.Entity.AlunoDisciplinaAvaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoDisciplinaAvaliacaoRepository extends JpaRepository<AlunoDisciplinaAvaliacao, Integer> {
}
