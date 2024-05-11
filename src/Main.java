import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Grafo metro = new Grafo();

        // Linha 1 - Azul
        metro.adicionarEstacao("Tucuruvi");
        metro.adicionarEstacao("Luz");
        metro.adicionarEstacao("Sé");
        metro.adicionarEstacao("Paraíso");
        metro.adicionarEstacao("Ana Rosa");
        metro.adicionarEstacao("Santa Cruz");
        metro.adicionarEstacao("Jabaquara");

        metro.adicionarConexao(8, "Tucuruvi", "Luz");
        metro.adicionarConexao(2, "Luz", "Sé");
        metro.adicionarConexao(4, "Sé", "Paraíso");
        metro.adicionarConexao(1, "Paraíso", "Ana Rosa");
        metro.adicionarConexao(2, "Ana Rosa", "Santa Cruz");
        metro.adicionarConexao(5, "Santa Cruz", "Jabaquara");

        // Linha 2 - Verde
        metro.adicionarEstacao("Vila Madalena");
        metro.adicionarEstacao("Paulista-Consolação");
        metro.adicionarEstacao("Chácara Klabin");
        metro.adicionarEstacao("Tamanduateí");
        metro.adicionarEstacao("Vila Prudente");

        metro.adicionarConexao(3, "Vila Madalena", "Paulista-Consolação");
        metro.adicionarConexao(3, "Paulista-Consolação", "Paraíso");
        metro.adicionarConexao(1, "Paraíso", "Ana Rosa");
        metro.adicionarConexao(1, "Ana Rosa", "Chácara Klabin");
        metro.adicionarConexao(4, "Chácara Klabin", "Tamanduateí");
        metro.adicionarConexao(1, "Tamanduateí", "Vila Prudente");

        // Linha 3 - Vermelha
        metro.adicionarEstacao("Palmeiras-Barra Funda");
        metro.adicionarEstacao("República");
        metro.adicionarEstacao("Brás");
        metro.adicionarEstacao("Tatuapé");
        metro.adicionarEstacao("Corinthians-Itaquera");

        metro.adicionarConexao(3, "Palmeiras-Barra Funda", "República");
        metro.adicionarConexao(2, "República", "Sé");
        metro.adicionarConexao(2, "Sé", "Brás");
        metro.adicionarConexao(3, "Brás", "Tatuapé");
        metro.adicionarConexao(7, "Tatuapé", "Corinthians-Itaquera");

        // Linha 4 - Amarela
        metro.adicionarEstacao("Vila Sônia");
        metro.adicionarEstacao("Pinheiros");

        metro.adicionarConexao(3, "Vila Sônia", "Pinheiros");
        metro.adicionarConexao(4, "Pinheiros", "Paulista-Consolação");
        metro.adicionarConexao(2, "Paulista-Consolação", "República");
        metro.adicionarConexao(1, "República", "Luz");

        // Linha 5 - Lilás
        metro.adicionarEstacao("Capão Redondo");
        metro.adicionarEstacao("Santo Amaro");

        metro.adicionarConexao(4, "Capão Redondo", "Santo Amaro");
        metro.adicionarConexao(11, "Santo Amaro", "Santa Cruz");
        metro.adicionarConexao(1, "Santa Cruz", "Chácara Klabin");

        // Linha 7 - Rubi
        metro.adicionarEstacao("Jundiaí");

        metro.adicionarConexao(16, "Jundiaí", "Palmeiras-Barra Funda");
        metro.adicionarConexao(1, "Palmeiras-Barra Funda", "Luz");

        // Linha 8 - Diamante
        metro.adicionarEstacao("Amador Bueno");
        metro.adicionarEstacao("Itapevi");
        metro.adicionarEstacao("Osasco");
        metro.adicionarEstacao("Presidente Altino");
        metro.adicionarEstacao("Júlio Prestes");

        metro.adicionarConexao(2, "Amador Bueno", "Itapevi");
        metro.adicionarConexao(13, "Itapevi", "Osasco");
        metro.adicionarConexao(1, "Osasco", "Presidente Altino");
        metro.adicionarConexao(4, "Presidente Altino", "Palmeiras-Barra Funda");
        metro.adicionarConexao(1, "Palmeiras-Barra Funda", "Júlio Prestes");

        // Linha 9 - Esmeralda
        metro.adicionarEstacao("Jurubatuba");
        metro.adicionarEstacao("Mendes-Vila Natal");

        metro.adicionarConexao(1,"Osasco", "Presidente Altino");
        metro.adicionarConexao(4, "Presidente Altino", "Pinheiros");
        metro.adicionarConexao(8, "Pinheiros", "Santo Amaro");
        metro.adicionarConexao(2, "Santo Amaro", "Jurubatuba");
        metro.adicionarConexao(4, "Jurubatuba", "Mendes-Vila Natal");

        // Linha 10 - Turquesa
        metro.adicionarEstacao("Rio Grande da Serra");

        metro.adicionarConexao(1, "Luz", "Brás");
        metro.adicionarConexao(3, "Brás", "Tamanduateí");
        metro.adicionarConexao(9, "Tamanduateí", "Rio Grande da Serra");

        // Linha 11 - Coral
        metro.adicionarEstacao("Calmon Viana");
        metro.adicionarEstacao("Estudantes");

        metro.adicionarConexao(1, "Luz", "Brás");
        metro.adicionarConexao(1, "Brás", "Tatuapé");
        metro.adicionarConexao(1, "Tatuapé", "Corinthians-Itaquera");
        metro.adicionarConexao(7, "Corinthians-Itaquera", "Calmon Viana");
        metro.adicionarConexao(5, "Calmon Viana", "Estudantes");

        // Linha 12 - Safira
        metro.adicionarEstacao("Engenheiro Goulart");

        metro.adicionarConexao(1, "Brás", "Tatuapé");
        metro.adicionarConexao(1, "Tatuapé", "Engenheiro Goulart");
        metro.adicionarConexao(10, "Engenheiro Goulart", "Calmon Viana");

        // Linha 13 - Jade
        metro.adicionarEstacao("Aeroporto-Guarulhos");

        metro.adicionarConexao(1, "Engenheiro Goulart", "Aeroporto-Guarulhos");

        // Linha 15 - Prata
        metro.adicionarEstacao("Jardim Colonial");

        metro.adicionarConexao(10, "Vila Prudente", "Jardim Colonial");




        ArrayList<Caminho> caminhos = metro.escontrar5CaminhosMaisRapidos("Jurubatuba", "Vila Prudente");

        for (int i = 0; i < caminhos.size(); i++) {
            System.out.println("Caminho " + (i+1) + ": " + caminhos.get(i));
        }

    }
}