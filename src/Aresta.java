public class Aresta {
    private double tempoViagem;
    private Vertice inicio;
    private Vertice fim;

    public Aresta(double tempoViagem, Vertice inicio, Vertice fim){
        this.tempoViagem = tempoViagem;
        this.inicio = inicio;
        this.fim = fim;
    }

    public double getTempoViagem() {
        return tempoViagem;
    }

    public Vertice getInicio() {
        return inicio;
    }

    public Vertice getFim() {
        return fim;
    }
}
