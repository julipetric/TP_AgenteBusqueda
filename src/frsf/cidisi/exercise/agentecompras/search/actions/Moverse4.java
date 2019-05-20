package frsf.cidisi.exercise.agentecompras.search.actions;

import frsf.cidisi.exercise.agentecompras.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Moverse4 extends SearchAction {
	
	EstadoAgente agState;
	
	/**
	 * This method updates a tree node state when the search process is running. It
	 * does not updates the real world state.
	 */
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		EstadoAgente agState = (EstadoAgente) s;
		this.agState = (EstadoAgente) s;

		// PreConditions
		boolean p = (agState.getposicionActual() != 4);

		if (p) {
			agState.setposicionPrevia(agState.getposicionActual());
			agState.setposicionActual(4);

			return agState;
		}

		return null;
	}

	/**
	 * This method updates the agent state and the real world state.
	 */
	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		this.execute((SearchBasedAgentState) ast);

		return null;
	}

	/**
	 * This method returns the action cost.
	 */
	@Override
	public Double getCost() {
		
		Double t = null;
		// Primero vemos que el agente no esté en el origen
		if (agState.getposicionPrevia() != -1) {

			// El costo de moverse depende del recurso a priorizar definido en el agente:
			switch (agState.getrecursoAPriorizar()) {
			// Tiempo
			case 0:
				// Se calcula segun el medio de transporte
				switch (agState.gettipoTransporte()) {
				// Bici
				case 1:
					t = (Double) (double) agState.getmapaTiempo()[0][agState.getposicionPrevia()][4];
					break;
				case 2:
					t = (Double) (double) agState.getmapaTiempo()[1][agState.getposicionPrevia()][4];
					break;
				case 3:
					t = (Double) (double) agState.getmapaTiempo()[2][agState.getposicionPrevia()][4];
					break;
				}
				break;
			// Costo
			case 1:
				switch (agState.gettipoTransporte()) {
				// Bici
				case 1:
					t = (Double) (double) 0;
					break;
				// Auto
				case 2:
					t = (Double) (double) agState.getmapaDist()[1][agState.getposicionPrevia()][4];
					t = t * agState.getprecioNafta();
					break;
				case 3:
					t = (Double) (double) agState.getmapaDist()[2][agState.getposicionPrevia()][4];
					t = t * agState.getprecioTransportePublico();
					break;
				}
				break;
			// Relacion costo-tiempo
			case 2:
				switch (agState.gettipoTransporte()) {
				// Bici
				case 1:
					t = (Double) (double) 0;
					break;
				// Auto
				case 2:
					t = (Double) (double) agState.getmapaDist()[1][agState.getposicionPrevia()][4];
					t = t * agState.getprecioNafta();
					t = t / (Double) (double) agState.getmapaTiempo()[1][agState.getposicionPrevia()][4];
					break;
				case 3:
					t = (Double) (double) agState.getmapaDist()[2][agState.getposicionPrevia()][4];
					t = t * agState.getprecioTransportePublico();
					t = t / (Double) (double) agState.getmapaTiempo()[2][agState.getposicionPrevia()][4];
					break;
				}
				break;
			}
		} else {

			// El costo de moverse depende del recurso a priorizar definido en el agente:
			switch (agState.getrecursoAPriorizar()) {
			// Tiempo
			case 0:
				// Se calcula segun el medio de transporte
				switch (agState.gettipoTransporte()) {
				// Bici
				case 1:
					t = (Double) (double) agState.gettiemposOrigen()[0][4];
					break;
				case 2:
					t = (Double) (double) agState.gettiemposOrigen()[1][4];
					break;
				case 3:
					t = (Double) (double) agState.gettiemposOrigen()[2][4];
					break;
				}
				break;
			// Costo
			case 1:
				switch (agState.gettipoTransporte()) {
				// Bici
				case 1:
					t = (Double) (double) 0;
					break;
				// Auto
				case 2:
					t = (Double) (double) agState.getdistanciasOrigen()[1][4];
					t = t * agState.getprecioNafta();
					break;
				case 3:
					t = (Double) (double) agState.getdistanciasOrigen()[2][4];
					t = t * agState.getprecioTransportePublico();
					break;
				}
				break;
			// Relacion costo-tiempo
			case 2:
				switch (agState.gettipoTransporte()) {
				// Bici
				case 1:
					t = (Double) (double) 0;
					break;
				// Auto
				case 2:
					t = (Double) (double) agState.getdistanciasOrigen()[1][4];
					t = t * agState.getprecioNafta();
					t = t / (Double) (double) agState.gettiemposOrigen()[1][4];
					break;
				case 3:
					t = (Double) (double) agState.getdistanciasOrigen()[2][4];
					t = t * agState.getprecioTransportePublico();
					t = t / (Double) (double) agState.gettiemposOrigen()[2][4];
					break;
				}
				break;
			}
		}
		return t;
	}

	/**
	 * This method is not important for a search based agent, but is essensial when
	 * creating a calculus based one.
	 */
	@Override
	public String toString() {
		String st = "Moverse0";
		st += ", Costo: " + this.getCost().toString();
		return st;
	}

	@Override
	public SearchBasedAgentState getagState() {
		return agState;
	}

	@Override
	public void setagState(SearchBasedAgentState agentState) {
		this.agState = (EstadoAgente) agentState;
		
	}

}