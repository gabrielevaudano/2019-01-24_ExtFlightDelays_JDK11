package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;

public class Simulator {
	// Coda degli eventi
		// 1. coda
		PriorityQueue<Event> coda;
		
		// 2. parametri di simulazione -> imposto default ed eventualmente lascio la possibilità di modificarli

		private Integer time; 
		
		private Graph<String, DefaultWeightedEdge> grafo;
		private Map<String, Integer> stateTourists = new HashMap<>();;
		
		public Map<String, Integer> getStateTourists() {
			return stateTourists;
		}

		// 3. Modello del mondo
		private Integer touristNumber;
		private Integer totalTime;
		
		// 4. Valori da calcolare
		// Vengono demandati i calcoli alla classe Statistic
		
		public void init(Graph<String, DefaultWeightedEdge> crato, String partenza, int totTime, int totTourists) {
			this.grafo = crato;
			this.touristNumber = totTourists;
			this.totalTime = totTime;
			
			for (String s : crato.vertexSet())
				stateTourists.put(s, 0);
			
			// preparazione iniziale
			coda = new PriorityQueue<Event>();
			stateTourists.put(partenza, touristNumber);

			// generazione degli eventi
			coda.add(new Event(0, touristNumber, partenza));
		}
		
		public void run() {
			while (!coda.isEmpty()) {
				Event e  = coda.poll();
				if (e.getTime() <= totalTime)
					processEvent(e);
			}
		}	
		
		private void processEvent(Event e) {	
			
			for (String s : Graphs.successorListOf(grafo, e.getState())) {
				int nuoviTuristi =  (int) (e.getNumTourists() * (grafo.getEdgeWeight(grafo.getEdge(e.getState(), s)) / pesoTotale(e.getState())));
				
				stateTourists.put(s, stateTourists.get(s) + nuoviTuristi);
				stateTourists.put(e.getState(), stateTourists.get(e.getState()) - nuoviTuristi);
				
				coda.add(new Event(e.getTime()+1, stateTourists.get(s), s));
			}
		}
		
		private double pesoTotale(String state) {
			double tot = 0.0;
			for (DefaultWeightedEdge e : grafo.outgoingEdgesOf(state))
				tot += grafo.getEdgeWeight(e);
			
			return tot;
		}
		
}
