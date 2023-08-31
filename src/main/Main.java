package main;

import classes.Biblioteca;
import classes.Livro;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Presets:
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        // Instanciando a biblioteca:
        Biblioteca biblioteca = new Biblioteca();

        // Loop Principal:
        int option;
        do {
            // Impressão do menu:
            System.out.print(
                """
                ================== BIBLIOTECA ==================
                \u001b[1;34m[ 1 ]\u001b[m Adicionar Livro;
                \u001b[1;34m[ 2 ]\u001b[m Buscar livro;
                \u001b[1;34m[ 3 ]\u001b[m Atualizar livro:
                \u001b[1;34m[ 4 ]\u001b[m Remover livro;
                \u001b[1;34m[ 5 ]\u001b[m Listar livros;
                \u001b[1;31m[ 0 ]\u001b[m Sair.
                
                \u001b[1;32m>>> \u001b[m"""
            );

            // Lendo a opção:
            option = input.nextInt();

            // Tratamento de opções:
            switch (option) {
                // Adicionar livro:
                case 1 -> {
                    // Lendo as informações do livro:
                    System.out.println("Informe as seguintes informações");

                    System.out.print("N° Registro: ");
                    int registro = input.nextInt();
                    System.out.print("Nome do livro: ");
                    input.nextLine();  // correção de bug do input;
                    String nomeLivro = input.nextLine();
                    System.out.print("Nome do autor: ");
                    String autor = input.nextLine();
                    System.out.print("Data de lançamento [AAAA-MM-DD]: ");
                    LocalDate data = LocalDate.parse(input.nextLine());

                    // Adicionando o novo objeto livro à biblioteca:
                    biblioteca.adicionar(new Livro(registro, nomeLivro, autor, data));

                    // Após isso, ele exibe uma mensagem de confirmação se o livro foi ou não cadastrado.
                }

                // Buscar livro:
                case 2 -> {
                    // Lendo o registro a ser procurado:
                    System.out.print("Informe o n° de registro do livro procurado: ");
                    int registro = input.nextInt();

                    // Buscando o livro:
                    biblioteca.buscar(registro);  // O método já imprime as informações do livro;
                }

                // Atualizar informações:
                case 3 -> {
                    // Lendo o n° de registro do livro:
                    System.out.print("Informe o n° de registro do livro a ser alterado: ");
                    int registro = input.nextInt();

                    // Buscando o livro:
                    if (!biblioteca.buscar(registro)) break;  // quebra o switch caso não seja encontrado.

                    // Lendo as novas informações do livro:
                    System.out.println("Informe as novas informações do livro: ");

                    System.out.print("Nome do livro: ");
                    input.nextLine();  // correção de bug do input;
                    String nomeLivro = input.nextLine();
                    System.out.print("Nome do autor: ");
                    String autor = input.nextLine();
                    System.out.print("Data de lançamento [AAAA-MM-DD]: ");
                    LocalDate data = LocalDate.parse(input.nextLine());

                    // Alterando as informações:
                    biblioteca.atualizar(registro, nomeLivro, autor, data);
                }

                // Remover livro:
                case 4 -> {
                    // Lendo o registro do livro a ser removido:
                    System.out.print("Informe o n° de registro do livro a ser removido: ");
                    int registro = input.nextInt();

                    // Remove o livro:
                    biblioteca.remover(registro);  // Imprime mensagem de erro caso não encontrado;
                }

                // Listar livros:
                case 5 -> biblioteca.listarLivros();

                // Sair:
                case 0 -> {
                    System.out.println("Volte sempre! :D");
                    Thread.sleep(700);
                }

                // Opção inválida:
                default -> {
                    System.out.println("\u001b[1;31mErro: Informe uma opção válida.\u001b[m");
                    Thread.sleep(700);
                }
            }
        } while (option != 0);
    }
}
