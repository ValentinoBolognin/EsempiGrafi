import org.jgrapht.graph.DefaultWeightedEdge;

public class Collegamento extends DefaultWeightedEdge {
	
	private int linea;
	
	public Collegamento() {
		super();
	}
	
	public Collegamento(int linea) {
		this.linea = linea;
	}

	public int getLinea() {
		return linea;
	}

	public void setLinea(int linea) {
		this.linea = linea;
	}

	@Override
	public String toString() {
		return "linea: " + linea;
	}

}
