package br.com.aulas.projeto.repositories;

import br.com.aulas.projeto.entities.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
    @Query("SELECT aluno FROM AlunoEntity aluno WHERE lower(aluno.name) = lower(:name)")
    List<AlunoEntity> findByNameIgnoreCase(@Param("name") String name);
}