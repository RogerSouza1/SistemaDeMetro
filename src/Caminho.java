import java.util.ArrayList;


public class Caminho {
    private final ArrayList<Vertice> vertices;
    private final double tempoViagem;

    public Caminho (ArrayList<Vertice> vertices, double tempoViagem) {
        this.vertices = vertices;
        this.tempoViagem = tempoViagem;
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public double getTempoViagem() {
        return tempoViagem;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Tempo de Viagem: ").append(tempoViagem).append(" estações]: ");
        for (Vertice vertice : vertices) {
            sb.append(vertice).append(" -> ");
        }
        sb.delete(sb.length() - 4, sb.length());
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Caminho caminho = (Caminho) obj;
    return vertices.equals(caminho.vertices);
    }

}
