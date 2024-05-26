

package com.mycompany.exec4;

import java.util.Scanner;
import java.util.Stack;


public class Exec4 {

    public static void main(String[] args) {
         class Produto {
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

        Stack<Produto> pilhaProdutos = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        final int MAX_PRODUTOS = 10;

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
                    if (pilhaProdutos.size() < MAX_PRODUTOS) {
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
                        pilhaProdutos.push(produto);
                        System.out.println("Produto \"" + descricao + "\" adicionado à pilha.");
                    } else {
                        System.out.println("A pilha já está cheia. Não é possível adicionar mais produtos.");
                    }
                    break;

                case 2:
                    if (pilhaProdutos.isEmpty()) {
                        System.out.println("A pilha de produtos está vazia.");
                    } else {
                        System.out.println("Produtos na pilha:");
                        for (Produto produto : pilhaProdutos) {
                            System.out.println(produto);
                        }
                    }
                    break;

                case 3:
                    if (pilhaProdutos.isEmpty()) {
                        System.out.println("A pilha de produtos está vazia.");
                    } else {
                        Produto produtoRemovido = pilhaProdutos.pop();
                        System.out.println("Produto removido: " + produtoRemovido);
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
    

