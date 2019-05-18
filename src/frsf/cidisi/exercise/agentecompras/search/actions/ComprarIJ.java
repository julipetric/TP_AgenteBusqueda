package frsf.cidisi.exercise.agentecompras.search.actions;

import frsf.cidisi.exercise.agentecompras.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class ComprarIJ extends SearchAction {

	EstadoAgente agState;
	/**
	 * This method updates a tree node state when the search process is running. It
	 * does not updates the real world state.
	 */
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		EstadoAgente agState = (EstadoAgente) s;

		// Preconditions
		boolean p1 = (agState.getpreciosProductosComercios()[I][J] != Double.MAX_VALUE);
		boolean p2 = (agState.getposicionActual() == I);
		boolean p3 = (!agState.getlistaProductos().contains(J));
		boolean p4 = (agState.getlistaProductosDeseados().contains(J));
		boolean p5 = (agState.getposicionActual() != -1);
		boolean p = (p1 && p2 && p3 && p4 && p5);

		if (p) {
			agState.getlistaProductos().add(J);
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
		Double p = null;
		// El costo de comprar depende del recurso a priorizar definido en el agente:
		switch (agState.getrecursoAPriorizar()) {
		// Tiempo
		case 0:
			p = 0.0;
			break;
		// Costo
		case 1:
			p = agState.getpreciosProductosComercios()[I][J];
			break;
		// Relacion costo-tiempo
		case 2:
			p = agState.getpreciosProductosComercios()[I][J];
			break;
		}
		return p;
	}

	/**
	 * This method is not important for a search based agent, but is essensial when
	 * creating a calculus based one.
	 */
	@Override
	public String toString() {
		return "ComprarIJ";
	}
}