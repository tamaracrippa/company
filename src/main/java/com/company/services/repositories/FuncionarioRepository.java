package com.company.services.repositories;

import com.company.domain.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionarios, Long> {

    List<Funcionarios> findByNome(String nome);

    List<Funcionarios> findByFuncao(String funcao);
    @Query("SELECT f.nome FROM Funcionarios f ORDER BY f.dataNascimento")
    List<String> findNamesOrderedByBirthdate();

    @Query("SELECT f.nome FROM Funcionarios f ORDER BY f.dataNascimento ASC")
    List<Funcionarios> findByOlder();

    @Query("SELECT f FROM Funcionarios f ORDER BY f.nome")
    List<Funcionarios> findAllByOrderByNome();

    void deleteByNome(String nome);

    @Query("SELECT COALESCE(SUM(f.salario), 0) FROM Funcionarios f")
    BigDecimal sumSalario();

}
