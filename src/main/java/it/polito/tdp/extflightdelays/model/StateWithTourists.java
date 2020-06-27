package it.polito.tdp.extflightdelays.model;

public class StateWithTourists {
	private String state;
	private Integer tourists;
	
	public String getState() {
		return state;
	}
	
	public Integer getTourists() {
		return tourists;
	}
	
	public StateWithTourists(String state, Integer tourists) {
		super();
		this.state = state;
		this.tourists = tourists;
	}

	public void setTourists(Integer tourists) {
		this.tourists = tourists;
	}

	@Override
	public String toString() {
		return "StateWithTourists [state=" + state + ", tourists=" + tourists + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		StateWithTourists other = (StateWithTourists) obj;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	
	
	
}
