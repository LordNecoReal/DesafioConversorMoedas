package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Carrega as taxas da API uma única vez
        ApiCambio api = new ApiCambio();
        TaxaCambio taxas = api.consumirApi();

        if (taxas == null) {
            System.out.println("Não foi possível obter as taxas de câmbio. Verifique sua conexão ou chave da API.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 9) {
            System.out.println("\n************************************************");
            System.out.println("Bem-vindo ao Conversor de Moedas!");
            System.out.println("Moeda base: USD - Dólar Americano");
            System.out.println("1. Dólar (USD) >> Peso Argentino (ARS)");
            System.out.println("2. Dólar (USD) >> Boliviano da Bolivia (BOB)");
            System.out.println("3. Dólar (USD) >> Real Brasileiro (BRL)");
            System.out.println("4. Dólar (USD) >> Peso Chileno (CLP)");
            System.out.println("5. Dólar (USD) >> Peso Colombiano (COP)");
            System.out.println("6. Dólar (USD) >> Rúpia Indiana (INR)");
            System.out.println("7. Dólar (USD) >> Iene Japonês (JPY)");
            System.out.println("8. Converter de outra moeda para Real Brasileiro (BRL)");
            System.out.println("9. Sair");
            System.out.println("************************************************");
            System.out.print("Escolha uma opção (1-9): ");

            try {
                opcao = scanner.nextInt();
                if (opcao == 9) {
                    System.out.println("Encerrando o programa. Até a próxima!");
                    break;
                }

                double valor;
                if (opcao >= 1 && opcao <= 7) {
                    System.out.print("Digite o valor em USD para converter: ");
                    valor = scanner.nextDouble();
                    converterDeUSD(opcao, valor, taxas);
                } else if (opcao == 8) {
                    converterParaBRL(scanner, taxas);
                } else {
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next(); // Limpa o buffer do scanner
            }
        }
        scanner.close();
    }

    private static void converterDeUSD(int opcao, double valor, TaxaCambio taxas) {
        String moedaDestino = "";
        switch (opcao) {
            case 1: moedaDestino = "ARS"; break;
            case 2: moedaDestino = "BOB"; break;
            case 3: moedaDestino = "BRL"; break;
            case 4: moedaDestino = "CLP"; break;
            case 5: moedaDestino = "COP"; break;
            case 6: moedaDestino = "INR"; break;
            case 7: moedaDestino = "JPY"; break;
        }

        double taxa = taxas.getConversion_rates().get(moedaDestino);
        double valorConvertido = valor * taxa;
        System.out.printf("O valor de %.2f USD corresponde a %.2f %s%n", valor, valorConvertido, moedaDestino);
    }

    private static void converterParaBRL(Scanner scanner, TaxaCambio taxas) {
        System.out.print("Digite o código da moeda de origem (ex: JPY): ");
        String moedaOrigem = scanner.next().toUpperCase();

        // Verifica o código da moeda ANTES de pedir o valor
        if (!taxas.getConversion_rates().containsKey(moedaOrigem)) {
            System.out.println("Código de moeda inválido ou não suportado. Por favor, tente novamente.");
            return; // Sai do método
        }

        System.out.print("Digite o valor para converter para BRL: ");
        double valor = scanner.nextDouble();

        // Conversão em 2 etapas: Moeda Origem -> USD -> BRL
        double taxaParaUSD = taxas.getConversion_rates().get(moedaOrigem);
        double valorEmUSD = valor / taxaParaUSD;

        double taxaParaBRL = taxas.getConversion_rates().get("BRL");
        double valorFinalBRL = valorEmUSD * taxaParaBRL;

        System.out.printf("O valor de %.2f %s corresponde a %.2f BRL%n", valor, moedaOrigem, valorFinalBRL);
    }
}