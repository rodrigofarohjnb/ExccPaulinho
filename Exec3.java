

package com.mycompany.exec3;

import java.util.Scanner;
import java.util.Stack;


public class Exec3 {

    public static void main(String[] args) {


        class Livro {
            private String titulo;
            private String autor;

            public Livro(String titulo, String autor) {
                this.titulo = titulo;
                this.autor = autor;
            }

            public String getTitulo() {
                return titulo;
            }

            public String getAutor() {
                return autor;
            }

            @Override
            public String toString() {
                return "Título: " + titulo + ", Autor: " + autor;
            }
        }

        Stack<Livro> pilhaLivros = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Retirar livro");
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
                    System.out.print("Informe o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Informe o autor do livro: ");
                    String autor = scanner.nextLine();
                    pilhaLivros.push(new Livro(titulo, autor));
                    System.out.println("Livro \"" + titulo + "\" adicionado à pilha.");
                    break;

                case 2:
                    if (pilhaLivros.isEmpty()) {
                        System.out.println("A pilha de livros está vazia.");
                    } else {
                        System.out.println("Livros na pilha:");
                        for (Livro livro : pilhaLivros) {
                            System.out.println(livro);
                        }
                    }
                    break;

                case 3:
                    if (pilhaLivros.isEmpty()) {
                        System.out.println("A pilha de livros está vazia.");
                    } else {
                        Livro livroRemovido = pilhaLivros.pop();
                        System.out.println("Livro removido: " + livroRemovido);
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






