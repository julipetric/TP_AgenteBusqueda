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

	public AgenteCompras() {
		// Robot agent goal
		ObjetivoAgente goal = new ObjetivoAgente();

		// Robot agent state
		EstadoAgente agentState = new EstadoAgente();
		this.setAgentState(agentState);

		// Robot agent actions
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

		// Robot agent problem
		Problem problem = new Problem(goal, agentState, operators);
		this.setProblem(problem);
	}

	@Override
	public Action selectAction() {
		// Breath first strategy
		BreathFirstSearch searchStrategy = new BreathFirstSearch();
//        DepthFirstSearch searchStrategy = new DepthFirstSearch();

		Search searchSolver = new Search(searchStrategy);

		// Set the search tree to be written in an XML file
		searchSolver.setVisibleTree(Search.EFAIA_TREE);

		// Set the search solver
		this.setSolver(searchSolver);

		// Run the actions selection process
		Action selectedAction = null;
		try {
			selectedAction = this.getSolver().solve(new Object[] { this.getProblem() });
		} catch (Exception ex) {
			Logger.getLogger(EstadoAgente.class.getName()).log(Level.SEVERE, null, ex);
		}

		// Return the selected action
		return selectedAction;
	}

	@Override
	public void see(Perception perception) {
		this.getAgentState().updateState(perception);
	}
}