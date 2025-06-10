package br.edu.ifnmg.lfgl.bibliotecaobra;

import java.time.LocalDate;

public class Obra {

    private String isbn;
    private String titulo;
    private String autorPrincipal;
    private int anoPublicado;
    private int quantidade;

    public Obra(String isbn, String titulo, String autorPrincipal,
            int anoPublicado, int quantidade) {
        if (isbn == null || !validarISBN(isbn)) {
            System.out.println("ISBN invalido");
            return;
        }

        if (titulo == null) {
            System.out.println("Titulo nao pode ser vazio");
            return;
        }

        if (autorPrincipal == null) {
            System.out.println("Autor nao pode ser vazio");
            return;
        }

        int anoAtual = LocalDate.now().getYear();
        if (anoPublicado <= 0 || anoPublicado > anoAtual) {
            System.out.println("Ano de publicacao invalido");
        }

        if (quantidade < 0) {
            System.out.println("Quantidade negativa de exemplares");
        }

        this.isbn = isbn;
        this.titulo = titulo;
        this.autorPrincipal = autorPrincipal;
        this.anoPublicado = anoPublicado;
        this.quantidade = quantidade;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters">
    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutorPrincipal() {
        return autorPrincipal;
    }

    public int getAnoPublicado() {
        return anoPublicado;
    }

    public int getQuantidade() {
        return quantidade;
    }

    //</editor-fold>
    public boolean estaDisponivel() {
        return quantidade > 0;
    }

    public void emprestar() {
        if (estaDisponivel()) {
            quantidade--;
        } else {
            System.out.println("Nenhum exemplar disponivel");
        }
    }

    public void devolver() {
        quantidade++;
    }

    public void imprimirInformacoes() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autorPrincipal);
        System.out.println("Ano de publicacao: " + anoPublicado);
        System.out.println("Quantidade de copias disponiveis: " + quantidade);
    }

    public boolean validarISBN(String isbn) {
        if (isbn == null || isbn.length() != 13) {
            return false;
        }
        int soma = 0;
        for (int i = 0; i < 13; i++) {
            int digito = Character.getNumericValue(isbn.charAt(i));
            if (i % 2 == 0) {
                soma += digito;
            } else {
                soma += digito * 3;
            }
        }
        return soma % 10 == 0;
    }
}
