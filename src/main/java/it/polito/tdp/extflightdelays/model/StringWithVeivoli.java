package it.polito.tdp.extflightdelays.model;

public class StringWithVeivoli {
	private String stato;
	private double veivoli;
	public String getStato() {
		return stato;
	}
	public double getVeivoli() {
		return veivoli;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
		long temp;
		temp = Double.doubleToLongBits(veivoli);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StringWithVeivoli other = (StringWithVeivoli) obj;
		if (stato == null) {
			if (other.stato != null)
				return false;
		} else if (!stato.equals(other.stato))
			return false;
		if (Double.doubleToLongBits(veivoli) != Double.doubleToLongBits(other.veivoli))
			return false;
		return true;
	}
	public StringWithVeivoli(String stato, double veivoli) {
		super();
		this.stato = stato;
		this.veivoli = veivoli;
	}
	@Override
	public String toString() {
		return "stato di destinazione " + stato + ", con numero veivoli " + veivoli ;
	}
	
	
}
