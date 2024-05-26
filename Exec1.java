

package com.mycompany.exec1;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;


public class Exec1 {

 

    public static void main(String[] args) {
        Queue<String> filaPacientes = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        final int MAX_PACIENTES = 20;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar paciente");
            System.out.println("2 - Chamar próximo paciente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            // Verifica se a entrada é um número inteiro
            while (!scanner.hasNextInt()) {
                System.out.println("Opção inválida. Tente novamente.");
                System.out.print("Escolha uma opção: ");
                scanner.next();  // Descarta a entrada inválida
            }
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    if (filaPacientes.size() < MAX_PACIENTES) {
                        System.out.print("Informe o nome do paciente: ");
                        String nome = scanner.nextLine();
                        filaPacientes.add(nome);
                        System.out.println("Paciente " + nome + " adicionado à fila.");
                    } else {
                        System.out.println("A fila já está cheia. Não é possível adicionar mais pacientes.");
                    }
                    break;

                case 2:
                    if (!filaPacientes.isEmpty()) {
                        String proximoPaciente = filaPacientes.poll();
                        System.out.println("Próximo paciente: " + proximoPaciente);
                    } else {
                        System.out.println("Não há pacientes na fila.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
