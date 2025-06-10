package br.edu.ifnmg.lfgl.bibliotecaobra;

public class BibliotecaObra {

    public static void main(String[] args) {
        Obra o = new Obra("9780306406157", "Tumulo do Vale", "Claudio Jr.",
                2015, 300);
        o.imprimirInformacoes();
        o.devolver();
        System.out.println(">> " + o.getQuantidade());

        Obra l = new Obra("9786589999013", "O Livro Perdido", "Clara Jane",
                1895, 65);

        Obra i = new Obra("9783161484100", "A Cova ", "Samira Pereira",
                1994, 1);
        i.imprimirInformacoes();
        i.emprestar();
        i.emprestar();
    }
}
