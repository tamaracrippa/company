package com.company.domain;

import com.company.domain.Pessoa;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
public class Funcionario extends Pessoa {

    private BigDecimal salario;
    private String funcao;


    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    // Getters e Setters
    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
