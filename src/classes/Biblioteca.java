package classes;

import java.time.LocalDate;
import java.util.HashMap;

public class Biblioteca {
    // Datastructure para armazenar os livros:
    private final HashMap<Integer, Livro> livros = new HashMap<>();

    public Biblioteca() {
        // Construtor vazio;
    }

    public void adicionar(Livro livro) throws InterruptedException {
        if (livros.containsKey(livro.getRegistro())) {  // verifica se o livro já está cadastrado:
            System.out.println("\u001b[1;31mErro: Livro já cadastrado.\u001b[m");
            Thread.sleep(700);
            return;  // interrompe a execução caso o livro já tenha sido cadastrado.
        }

        // Cadastrando o livro:
        livros.put(livro.getRegistro(), livro);  // cadastro na DataStructure;
        System.out.println("\u001b[1;32mLivro cadastrado com sucesso!\u001b[m");  // Mensagem de confirmação;
        Thread.sleep(700);
    }

    public boolean buscar(int registro) throws InterruptedException {
        // Buscando o livro:
        if (!livros.containsKey(registro)) {  // Verificando se ele está cadastrado:
            System.out.println("\u001b[1;31mLivro não encontrado.\u001b[m");
            Thread.sleep(700);
            return false;  // Interrompe caso não encontre.
        }

        // Caso o livro tenha sido encontrado:
        System.out.println("\u001b[1;32mLivro encontrado!\u001b[m");  // Mensagem de confirmação;
        Thread.sleep(700);
        System.out.println(livros.get(registro));  // Imprimindo as informações do livro;
        Thread.sleep(700);
        return true;  // afirmando que o livro foi encontrado;
    }

    public void atualizar(int registro, String nome, String autor, LocalDate data) throws InterruptedException {
        // Buscando o livro:
        if (!livros.containsKey(registro)) {  // Verificando se ele está cadastrado:
            System.out.println("\u001b[1;31mLivro não encontrado.\u001b[m");
            Thread.sleep(700);
            return;  // Interrompe caso não encontre.
        }

        // Inserindo as novas informações do livro:
        livros.get(registro).setNome(nome);  // Alterando o autor;
        livros.get(registro).setAutor(autor);  // Auterando o nome do livro;
        livros.get(registro).setDataPublicacao(data);  // Alterando a data;

        // Mensagem de confirmação:
        System.out.println("\u001b[1;32mInformações do livro alteradas com sucesso!\u001b[m");
    }

    public void remover(int registro) throws InterruptedException {
        // Buscando o livro:
        if (!livros.containsKey(registro)) {  // Verificando se ele está cadastrado:
            System.out.println("\u001b[1;31mErro: Não foi possível remover livro não cadastrado.\u001b[m");
            Thread.sleep(700);
            return;  // Interrompe caso não encontre.
        }

        // Removendo o livro do registro:
        livros.remove(registro);
        System.out.println("\u001b[1;32mLivro removido com sucesso!\u001b[m");  // Mensagem de confirmação;
        Thread.sleep(700);
    }

    public void listarLivros() {
        System.out.println("Livros = [");
        for (Livro livro : livros.values()) {  // Percorre todos os livros, como uma lista;
            System.out.println(livro.toString().indent(4));   // imprime o toString() dos livros, indentado em 4.
        }
        System.out.println("]");
    }
}
