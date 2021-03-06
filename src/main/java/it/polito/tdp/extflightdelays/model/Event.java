package it.polito.tdp.extflightdelays.model;

public class Event implements Comparable<Event> {
	private int time;
	private int numTourists;
	private String state;
	
	
	public Event(int time, int numTourists, String state) {
		super();
		this.time = time;
		this.numTourists = numTourists;
		this.state = state;
	}
	public int getTime() {
		return time;
	}
	public int getNumTourists() {
		return numTourists;
	}
	public String getState() {
		return state;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + time;
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
		Event other = (Event) obj;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (time != other.time)
			return false;
		return true;
	}
	@Override
	public int compareTo(Event o) {
		return this.time-o.time;
	}
	
	
}
