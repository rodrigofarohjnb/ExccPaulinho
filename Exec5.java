package com.mycompany.exec5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Exec5 {

    static class Produto {
        private int codProduto;
        private String descricao;
        private String dataEntrada;
        private String ufOrigem;
        private String ufDestino;

        public Produto(int codProduto, String descricao, String dataEntrada, String ufOrigem, String ufDestino) {
            this.codProduto = codProduto;
            this.descricao = descricao;
            this.dataEntrada = dataEntrada;
            this.ufOrigem = ufOrigem;
            this.ufDestino = ufDestino;
        }

        public int getCodProduto() {
            return codProduto;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDataEntrada() {
            return dataEntrada;
        }

        public String getUfOrigem() {
            return ufOrigem;
        }

        public String getUfDestino() {
            return ufDestino;
        }

        @Override
        public String toString() {
            return "Código: " + codProduto + ", Descrição: " + descricao + ", Data de Entrada: " + dataEntrada +
                    ", UF Origem: " + ufOrigem + ", UF Destino: " + ufDestino;
        }
    }

    public static void main(String[] args) {
        final int NUM_PILHAS = 5;
        final int MAX_PRODUTOS = 10;
        List<Stack<Produto>> pilhas = new ArrayList<>(NUM_PILHAS);
        for (int i = 0; i < NUM_PILHAS; i++) {
            pilhas.add(new Stack<>());
        }

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Retirar produto");
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
                    int pilhaAdicionar = selecionarPilha(scanner, NUM_PILHAS);
                    if (pilhaAdicionar >= 0 && pilhas.get(pilhaAdicionar).size() < MAX_PRODUTOS) {
                        System.out.print("Informe o código do produto: ");
                        int codProduto = scanner.nextInt();
                        scanner.nextLine();  // Limpa o buffer
                        System.out.print("Informe a descrição do produto: ");
                        String descricao = scanner.nextLine();
                        System.out.print("Informe a data de entrada (dd/MM/yyyy): ");
                        String dataEntrada = scanner.nextLine();
                        System.out.print("Informe a UF de origem: ");
                        String ufOrigem = scanner.nextLine();
                        System.out.print("Informe a UF de destino: ");
                        String ufDestino = scanner.nextLine();

                        Produto produto = new Produto(codProduto, descricao, dataEntrada, ufOrigem, ufDestino);
                        pilhas.get(pilhaAdicionar).push(produto);
                        System.out.println("Produto \"" + descricao + "\" adicionado à pilha " + (pilhaAdicionar + 1) + ".");
                    } else {
                        System.out.println("A pilha selecionada já está cheia ou a seleção é inválida. Não é possível adicionar mais produtos.");
                    }
                    break;

                case 2:
                    listarProdutos(pilhas);
                    break;

                case 3:
                    int pilhaRemover = selecionarPilha(scanner, NUM_PILHAS);
                    if (pilhaRemover >= 0 && !pilhas.get(pilhaRemover).isEmpty()) {
                        Produto produtoRemovido = pilhas.get(pilhaRemover).pop();
                        System.out.println("Produto removido da pilha " + (pilhaRemover + 1) + ": " + produtoRemovido);
                    } else {
                        System.out.println("A pilha selecionada está vazia ou a seleção é inválida.");
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

    private static int selecionarPilha(Scanner scanner, int numPilhas) {
        System.out.print("Selecione a pilha (1 a " + numPilhas + "): ");
        int pilhaSelecionada = scanner.nextInt() - 1;
        scanner.nextLine();  // Limpa o buffer
        if (pilhaSelecionada < 0 || pilhaSelecionada >= numPilhas) {
            System.out.println("Seleção inválida.");
            return -1;
        }
        return pilhaSelecionada;
    }

    private static void listarProdutos(List<Stack<Produto>> pilhas) {
        for (int i = 0; i < pilhas.size(); i++) {
            Stack<Produto> pilha = pilhas.get(i);
            System.out.println("Pilha " + (i + 1) + ":");
            if (pilha.isEmpty()) {
                System.out.println("  (vazia)");
            } else {
                for (Produto produto : pilha) {
                    System.out.println("  " + produto);
                }
            }
        }
    }
}
