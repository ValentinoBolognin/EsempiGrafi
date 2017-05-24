import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedMultigraph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.builder.DirectedWeightedGraphBuilder;

public class EsempioGrafo {
	
	/*
	 * grado non diretto, semplice e non pesato
	 */
	void esempio1(){
		UndirectedGraph<Integer, DefaultEdge> grafo = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
		
		// Aggiungo i vertici
		for (int i = 1; i<=6; i++)
			grafo.addVertex(i);
			
		System.out.println(grafo);
		
		// Aggiungo gli archi
		grafo.addEdge(1, 2);
		grafo.addEdge(2, 3);
		grafo.addEdge(1, 3);
		
		grafo.addEdge(5, 6);
	
		System.out.println(grafo);
		
		// Questo arco verrà scartato
		grafo.addEdge(5, 6);
		
		System.out.println(grafo);
	}

	/*
	 * grafo diretto, multi, pesato
	 */
	void esempio2(){
		DirectedWeightedMultigraph<Integer, DefaultWeightedEdge> grafo = new DirectedWeightedMultigraph<Integer, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		System.out.println("Esempio2");
		
		// Aggiungo i vertici
		for (int i = 1; i<=6; i++)
			grafo.addVertex(i);
			
		System.out.println(grafo);
		
		// Aggiungo gli archi
		DefaultWeightedEdge e = grafo.addEdge(1, 2);
		grafo.setEdgeWeight(e, 0.5);
		
		e = grafo.addEdge(2, 3);
		grafo.setEdgeWeight(e, 0.2);
		
		e = grafo.addEdge(1, 3);
		grafo.setEdgeWeight(e, 0.1);
				
		e = grafo.addEdge(5, 6);
		grafo.setEdgeWeight(e, 0.6);
		
		System.out.println(grafo);

		grafo.addEdge(5, 6);
		
		System.out.println(grafo);
		
		// Itero sugli archi
		for(DefaultWeightedEdge arch : grafo.edgeSet()) {
			System.out.println(arch);
			System.out.format("%d - %d peso: %f\n", grafo.getEdgeSource(arch), grafo.getEdgeTarget(arch), grafo.getEdgeWeight(arch));
		}
	
		// Itero sui vertici
			for(Integer vertex : grafo.vertexSet()) {
				System.out.format("vertex: %d\n", vertex);
				for(DefaultWeightedEdge arch : grafo.edgesOf(vertex)) {
				
					System.out.format("--adiacent vertex: %d\n",Graphs.getOppositeVertex(grafo, arch, vertex));
					
					if(grafo.getEdgeSource(arch) == vertex){
						System.out.format("adiacent vertex: %d\n", grafo.getEdgeTarget(arch));
					} else {
						System.out.format("adiacent vertex: %d\n", grafo.getEdgeSource(arch));
					}
				}
				System.out.format("inDegree: %d -- outDegree %d\n",
						grafo.inDegreeOf(vertex),
						grafo.outDegreeOf(vertex));
				
			}
			
			System.out.println("\nneighborList of 3");
			System.out.println(Graphs.neighborListOf(grafo, 3));
			
			System.out.println("\nsuccessor of 3");
			System.out.println(Graphs.successorListOf(grafo, 3));
			
			System.out.println("\npredecessor of 3");
			System.out.println(Graphs.predecessorListOf(grafo, 3));
			
	}

	
	public static void main(String[] args) {
		
		EsempioGrafo eg = new EsempioGrafo();
		eg.esempio1();
		eg.esempio2();

	}

}
