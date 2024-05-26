

package com.mycompany.exec2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exec2 {

    public static void main(String[] args) {
        Queue<Cliente> filaPrioritaria = new LinkedList<>();
        Queue<Cliente> filaNormal = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        int contadorPrioritario = 0;
        int senha = 1;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Chamar próximo cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Opção inválida. Tente novamente.");
                System.out.print("Escolha uma opção: ");
                scanner.next();  // Descarta a entrada inválida
            }
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Informe o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Informe o ano de nascimento do cliente: ");
                    int anoNascimento = scanner.nextInt();
                    scanner.nextLine();  // Limpa o buffer do scanner

                    Cliente cliente = new Cliente(senha++, nome, anoNascimento);
                    if (2024 - anoNascimento > 65) {
                        filaPrioritaria.add(cliente);
                        System.out.println("Cliente " + nome + " adicionado à fila prioritária.");
                    } else {
                        filaNormal.add(cliente);
                        System.out.println("Cliente " + nome + " adicionado à fila normal.");
                    }
                    break;

                case 2:
                    if (contadorPrioritario < 2 && !filaPrioritaria.isEmpty()) {
                        Cliente proximoCliente = filaPrioritaria.poll();
                        System.out.println("Próximo cliente prioritário: " + proximoCliente);
                        contadorPrioritario++;
                    } else if (!filaNormal.isEmpty()) {
                        Cliente proximoCliente = filaNormal.poll();
                        System.out.println("Próximo cliente normal: " + proximoCliente);
                        contadorPrioritario = 0;
                    } else if (!filaPrioritaria.isEmpty()) {
                        Cliente proximoCliente = filaPrioritaria.poll();
                        System.out.println("Próximo cliente prioritário: " + proximoCliente);
                        contadorPrioritario++;
                    } else {
                        System.out.println("Não há clientes na fila.");
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
    

