package frsf.cidisi.exercise.agentecompras.search;

import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidisi.exercise.agentecompras.search.actions.Comprar00;
import frsf.cidisi.exercise.agentecompras.search.actions.Comprar01;
import frsf.cidisi.exercise.agentecompras.search.actions.Comprar02;
import frsf.cidisi.exercise.agentecompras.search.actions.Comprar03;
import frsf.cidisi.exercise.agentecompras.search.actions.Comprar04;
import frsf.cidisi.exercise.agentecompras.search.actions.Comprar05;
import frsf.cidisi.exercise.agentecompras.search.actions.Moverse0;
import frsf.cidisi.exercise.agentecompras.search.actions.Moverse1;
import frsf.cidisi.exercise.agentecompras.search.actions.Moverse2;
import frsf.cidisi.exercise.agentecompras.search.actions.Moverse3;
import frsf.cidisi.exercise.agentecompras.search.actions.Moverse4;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.BreathFirstSearch;
import frsf.cidisi.faia.solver.search.Search;

public class AgenteCompras extends SearchBasedAgent {

	public AgenteCompras(ArrayList<Integer> listaProductosDeseados, int tipoTransporte, int[][] tiemposOrigen,
			int[][] distOrigen, int recurso) {

		// The Agent Goal
		ObjetivoAgente agGoal = new ObjetivoAgente();

		// The Agent State
		EstadoAgente agState = new EstadoAgente(listaProductosDeseados, tipoTransporte, tiemposOrigen, distOrigen,
				recurso);
		this.setAgentState(agState);

		// Create the operators
		Vector<SearchAction> operators = new Vector<SearchAction>();
		operators.addElement(new Moverse0());
		operators.addElement(new Moverse1());
		operators.addElement(new Moverse2());
		operators.addElement(new Moverse3());
		operators.addElement(new Moverse4());
		operators.addElement(new Comprar00());
		operators.addElement(new Comprar01());
		operators.addElement(new Comprar02());
		operators.addElement(new Comprar03());
		operators.addElement(new Comprar04());
		operators.addElement(new Comprar05());
		/*
		operators.addElement(new Comprar10());
		operators.addElement(new Comprar11());
		operators.addElement(new Comprar12());
		operators.addElement(new Comprar13());
		operators.addElement(new Comprar14());
		operators.addElement(new Comprar15());
		operators.addElement(new Comprar20());
		operators.addElement(new Comprar21());
		operators.addElement(new Comprar23());
		operators.addElement(new Comprar23());
		operators.addElement(new Comprar24());
		operators.addElement(new Comprar25());
		operators.addElement(new Comprar30());
		operators.addElement(new Comprar31());
		operators.addElement(new Comprar32());
		operators.addElement(new Comprar33());
		operators.addElement(new Comprar34());
		operators.addElement(new Comprar35());
		operators.addElement(new Comprar40());
		operators.addElement(new Comprar41());
		operators.addElement(new Comprar42());
		operators.addElement(new Comprar43());
		operators.addElement(new Comprar44());
		operators.addElement(new Comprar45());
		*/

		// Create the Problem which the agent will resolve
		Problem problem = new Problem(agGoal, agState, operators);
		this.setProblem(problem);
	}

	/**
	 * This method is executed by the simulator to ask the agent for an action.
	 */
	@Override
	public Action selectAction() {

		// Create the search strategy
		BreathFirstSearch strategy = new BreathFirstSearch();

		// Create a Search object with the strategy
		Search searchSolver = new Search(strategy);

		/*
		 * Generate an XML file with the search tree. It can also be generated in other
		 * formats like PDF with PDF_TREE
		 */
		searchSolver.setVisibleTree(Search.EFAIA_TREE);

		// Set the Search searchSolver.
		this.setSolver(searchSolver);

		// Ask the solver for the best action
		Action selectedAction = null;
		try {
			selectedAction = this.getSolver().solve(new Object[] { this.getProblem() });
		} catch (Exception ex) {
			Logger.getLogger(AgenteCompras.class.getName()).log(Level.SEVERE, null, ex);
		}

		// Return the selected action
		return selectedAction;

	}

	/**
	 * This method is executed by the simulator to give the agent a perception. Then
	 * it updates its state.
	 * 
	 * @param p
	 */
	@Override
	public void see(Perception p) {
		this.getAgentState().updateState(p);
	}
}
