// Arquivo: FuncionarioRepository.java

package com.company.services.repositories;

import com.company.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findByNome(String nome);

    List<Funcionario> findByFuncao(String funcao);

    List<Funcionario> findByDataNascimentoMonthIn(int... months);

    @Query("SELECT f FROM Funcionario f ORDER BY f.nome")
    List<Funcionario> findAllByOrderByNome();

    void deleteByNome(String nome);

    BigDecimal sumSalario();

    List<Funcionario> findAllByOrderByDataNascimentoAsc();

    List<Funcionario> findAllByOrderByDataNascimentoDesc();
}
