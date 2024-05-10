import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Grafo metro = new Grafo();

        metro.adicionarEstacao("Luz");
        metro.adicionarEstacao("Jurubatuba");
        metro.adicionarEstacao("Santo Amaro");
        metro.adicionarEstacao("Pinheiros");
        metro.adicionarEstacao("Santa Cruz");

        metro.adicionarConexao(2.0, "Jurubatuba", "Santo Amaro");
        metro.adicionarConexao(11.0, "Santo Amaro", "Santa Cruz");
        metro.adicionarConexao(9.0, "Santa Cruz", "Luz");
        metro.adicionarConexao(9.0, "Jurubatuba", "Pinheiros");
        metro.adicionarConexao(8.0, "Pinheiros", "Luz");

        ArrayList<Caminho> caminhos = metro.escontrar5CaminhosMaisRapidos("Luz", "Santo Amaro");

        for (int i = 0; i < caminhos.size(); i++) {
            System.out.println("Caminho " + (i+1) + ": " + caminhos.get(i));
        }

    }
}