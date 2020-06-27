package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	ExtFlightDelaysDAO dao;
	Graph<String, DefaultWeightedEdge> grafo;
	Set<String> idMapstates;
	
	public Model() {
		dao = new ExtFlightDelaysDAO();
	}
	
	public void creaGrafo() {
		idMapstates = new HashSet<String>();
		grafo = new DefaultDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(grafo, dao.loadVertices(idMapstates));
		
		for (Adiacenza a : dao.loadAdiacenze(idMapstates))
			Graphs.addEdgeWithVertices(grafo, a.getStatoPartenza(), a.getStatoArrivo(), a.getWeight());
		
	}

	public Graph<String, DefaultWeightedEdge> getGrafo() {
		if (grafo == null)
			throw new NullPointerException("Il grafo non è ancora stato creato.");
			return grafo;
			
			
	}
	
	public List<StringWithVeivoli> visualizzaVeivoli(String state) {
		List<StringWithVeivoli>  swv = new ArrayList<StringWithVeivoli>();
		
		for (DefaultWeightedEdge e : grafo.outgoingEdgesOf(state))
			swv.add(new StringWithVeivoli(Graphs.getOppositeVertex(grafo, e, state), grafo.getEdgeWeight(e)));
		
		swv.sort(new Comparator<StringWithVeivoli>() {

			@Override
			public int compare(StringWithVeivoli o1, StringWithVeivoli o2) {
				// TODO Auto-generated method stub
				return (int) (- o1.getVeivoli()-o2.getVeivoli());
			}
			
		});
		return swv;
	}
	
	public List<StateWithTourists> getTourists(int time, int people, String partenza) {
		Simulator m = new Simulator();
		List<StateWithTourists> list = new ArrayList<StateWithTourists>();
		Map<String, Integer> mappa = m.getStateTourists();
		
		m.init(grafo, partenza, time, people);
		m.run();
		
		for (String key : mappa.keySet())
			list.add(new StateWithTourists(key, mappa.get(key)));
		
		return list;
	}
}
