package com.company.services;

import com.company.domain.Funcionarios;
import com.company.services.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Consulta implements CommandLineRunner {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    private List<Funcionarios> funcionarios;

    @Override
    public void run(String... args) {
        funcionarioRepository.deleteByNome("João");

        funcionarios = funcionarioRepository.findAll();
        System.out.println(funcionarios);

        aplicarAumentoSalario(10);

        Map<String, List<Funcionarios>> funcionariosAgrupados = agruparPorFuncao();
        imprimirFuncionariosAgrupadosPorFuncao(funcionariosAgrupados);

        imprimirAniversariantes();
        imprimirMaiorIdade();
        imprimirFuncionariosOrdemAlfabetica();
        imprimirTotalSalarios();
        imprimirSalariosMinimos();
    }

    private void imprimirFuncionarios() {
        funcionarios.forEach(System.out::println);
    }

    private void aplicarAumentoSalario(double percentualAumento) {
        funcionarios.forEach(funcionario -> {
            BigDecimal novoSalario = funcionario.getSalario().multiply(BigDecimal.valueOf(1 + percentualAumento / 100));
            funcionario.setSalario(novoSalario);
        });
        funcionarioRepository.saveAll(funcionarios);
    }

    private Map<String, List<Funcionarios>> agruparPorFuncao() {
        return funcionarios.stream().collect(Collectors.groupingBy(Funcionarios::getFuncao));
    }

    private void imprimirFuncionariosAgrupadosPorFuncao(Map<String, List<Funcionarios>> funcionariosAgrupados) {
        funcionariosAgrupados.forEach((funcao, listaFuncionarios) -> {
            System.out.println("Função: " + funcao);
            listaFuncionarios.forEach(System.out::println);
            System.out.println();
        });
    }

    private void imprimirAniversariantes() {
        List<String> nomes = funcionarioRepository.findNamesOrderedByBirthdate();
        nomes.forEach(System.out::println);
    }

    private void imprimirMaiorIdade() {
        List<Funcionarios> funcionariosMaisVelhos = funcionarioRepository.findByOlder();

        if (!funcionariosMaisVelhos.isEmpty()) {
            Funcionarios funcionarioMaisVelho = funcionariosMaisVelhos.get(0);
            System.out.println("Funcionário mais velho:");
            System.out.println(funcionarioMaisVelho);
        } else {
            System.out.println("Nenhum funcionário encontrado.");
        }
    }


    private void imprimirFuncionariosOrdemAlfabetica() {
        List<Funcionarios> funcionariosOrdenados = funcionarioRepository.findAllByOrderByNome();
        funcionariosOrdenados.forEach(System.out::println);
    }

    private void imprimirTotalSalarios() {
        BigDecimal totalSalarios = funcionarioRepository.sumSalario();
        System.out.println("Total dos salários: " + totalSalarios);
    }

    private void imprimirSalariosMinimos() {
        BigDecimal salarioMinimo = BigDecimal.valueOf(1212.00);
        funcionarios.forEach(funcionario -> {
            BigDecimal salariosMinimos = funcionario.getSalario()
                    .divide(salarioMinimo, 2, RoundingMode.DOWN);
            System.out.println(funcionario.getNome() + " ganha " + salariosMinimos + " salários mínimos");
        });
    }

    public void imprimirTodosFuncionarios() {
        List<Funcionarios> funcionarios = funcionarioRepository.findAll();

        System.out.println("Lista de Funcionários:");
        for (Funcionarios funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }
}

