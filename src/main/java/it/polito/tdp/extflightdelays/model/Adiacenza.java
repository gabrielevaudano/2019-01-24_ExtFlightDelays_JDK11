package it.polito.tdp.extflightdelays.model;

public class Adiacenza {
	String statoPartenza;
	String statoArrivo;
	int weight;
	
	
	
	@Override
	public String toString() {
		return "Adiacenza [statoPartenza=" + statoPartenza + ", statoArrivo=" + statoArrivo + ", weight=" + weight
				+ "]";
	}

	public Adiacenza(String statoPartenza, String statoArrivo, int i) {
		super();
		this.statoPartenza = statoPartenza;
		this.statoArrivo = statoArrivo;
		this.weight = i;
	}

	public String getStatoPartenza() {
		return statoPartenza;
	}
	
	public String getStatoArrivo() {
		return statoArrivo;
	}
	
	public int getWeight() {
		return weight;
	}
	
	
}
