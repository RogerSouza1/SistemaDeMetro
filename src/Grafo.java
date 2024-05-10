import java.util.ArrayList;
import java.util.Comparator;

public class Grafo {
    private final ArrayList<Vertice> estacoes;
    private final ArrayList<Aresta> conexoes;

    public Grafo() {
        this.conexoes = new ArrayList<>();
        this.estacoes = new ArrayList<>();
    }

    public void adicionarEstacao(String nomeEstacao) {
        estacoes.add(new Vertice(nomeEstacao));
    }

    public void adicionarConexao(double tempoViagem, String nomeEstacaoInicio, String nomeEstacaoFim) {
        Vertice inicio = buscarEstacao(nomeEstacaoInicio);
        Vertice fim = buscarEstacao(nomeEstacaoFim);

        if (inicio != null && fim != null) {
            conexoes.add(new Aresta(tempoViagem, inicio, fim));
            conexoes.add(new Aresta(tempoViagem, fim, inicio));
        } else {
            throw new IllegalArgumentException("Estação de origem ou destino não encontrada");
        }
    }

    public ArrayList<Caminho> escontrar5CaminhosMaisRapidos(String nomeEstacaoOrigem, String nomeEstacaoDestino) {
        ArrayList<Caminho> caminhos = encontrarTodosOsCaminhosMaisRapidos(nomeEstacaoOrigem, nomeEstacaoDestino);
        if (caminhos == null || caminhos.isEmpty()) {
            System.out.printf("Não foi possível encontrar caminho entre as estações: %s e %s%n", nomeEstacaoOrigem, nomeEstacaoDestino);
        }

        int tamanhoSublista = Math.min(5, caminhos.size());
        return new ArrayList<>(caminhos.subList(0, tamanhoSublista));
    }

    private ArrayList<Caminho> encontrarTodosOsCaminhosMaisRapidos(String nomeEstacaoOrigem, String nomeEstacaoDestino) {
        Vertice origem = buscarEstacao(nomeEstacaoOrigem);
        Vertice destino = buscarEstacao(nomeEstacaoDestino);
        if (origem == null || destino == null) {
            throw new IllegalArgumentException("Estação de origem ou destino não encontrada");
        }

        ArrayList<Caminho> todosCaminhos = new ArrayList<>();
        ArrayList<Vertice> caminhoAtual = new ArrayList<>();
        boolean[] visitados = new boolean[estacoes.size()];

        // Inicia a busca em profundidade
        dfs(origem, destino, 0, todosCaminhos, caminhoAtual, visitados);

        // Ordena os caminhos pelo tempo de viagem
        todosCaminhos.sort(Comparator.comparingDouble(Caminho::getTempoViagem));

        return todosCaminhos;
    }

    private void dfs(Vertice atual, Vertice destino, double tempoAtual, ArrayList<Caminho> todosCaminhos, ArrayList<Vertice> caminhoAtual, boolean[] visitados) {
        // Adiciona o vértice atual ao caminho atual
        caminhoAtual.add(atual);
        visitados[estacoes.indexOf(atual)] = true;

        // Se chegarmos ao destino, adicionamos o caminho atual à lista de caminhos
        if (atual.equals(destino)) {
            todosCaminhos.add(new Caminho(new ArrayList<>(caminhoAtual), tempoAtual));
        } else {
            // Continua a busca em profundidade
            for (Aresta aresta : getConexoesSaindoDe(atual)) {
                if (!visitados[estacoes.indexOf(aresta.getFim())]) {
                    double tempoViagem = aresta.getTempoViagem();
                    dfs(aresta.getFim(), destino, tempoAtual + tempoViagem, todosCaminhos, caminhoAtual, visitados);
                }
            }
        }

        // Remove o vértice atual do caminho atual e marca como não visitado
        caminhoAtual.remove(caminhoAtual.size() - 1);
        visitados[estacoes.indexOf(atual)] = false;
    }


    private ArrayList<Aresta> getConexoesSaindoDe(Vertice vertice) {
        ArrayList<Aresta> conexoesSaindoDe = new ArrayList<>();

        for (Aresta conexao : conexoes) {
            if (conexao.getInicio().equals(vertice)) {
                conexoesSaindoDe.add(conexao);
            }
        }
        return conexoesSaindoDe;
    }

    private int encontrarProximoVertice(double[] distancias, boolean[] visitados) {
        double minDistancia = Double.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distancias.length; i++) {
            if (!visitados[i] && distancias[i] < minDistancia) {
                minDistancia = distancias[i];
                minIndex = i;
            }
        }
        return minIndex == -1 ? Integer.MAX_VALUE : minIndex;
    }

    private Vertice buscarEstacao(String nomeEstacao) {
        for (Vertice estacao : estacoes) {
            if (estacao.getNomeEstacao().equals(nomeEstacao)) {
                return estacao;
            }
        }
        return null;
    }


}
