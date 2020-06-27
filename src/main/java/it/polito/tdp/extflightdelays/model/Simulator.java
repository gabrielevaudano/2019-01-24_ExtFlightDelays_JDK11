package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Simulator {
	// Coda degli eventi
		// 1. coda

		
		// 2. parametri di simulazione -> imposto default ed eventualmente lascio la possibilità di modificarli
		private String state;
		private Integer touristNumber;
		private Integer totalTime;
		
		public void setState(String to) {
			this.state = to;
		}
		
		// 3. Modello del mondo
		
		// 4. Valori da calcolare
		// Vengono demandati i calcoli alla classe Statistic
		
		public void run() {
			// preparazione iniziale
			
			
			// generazione degli eventi
		}
		private void processEvent(Event e) {	
			// Check for table
			switch (e.getType()) {
			}
			
		}

		
}
