package frsf.cidisi.exercise.agentecompras.search;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

/**
 * This class can be used in any search strategy like Uniform Cost.
 */
public class CostFunction implements IStepCostFunction {

	/**
	 * This method calculates the cost of the given NTree node.
	 */
	@Override
	public double calculateCost(NTree node) {
		/*
		 * if(node.getParent() != null) { if(node.getParent().getAction() == null) {
		 * return 0; } else { double costo = node.getAction().getCost(); costo +=
		 * calculateCost(node.getParent()); return costo; } } else { return
		 * node.getAction().getCost(); }
		 */
		((EstadoAgente) node.getAction().getagState()).setpreciosProductosComercios(
				((EstadoAgente) node.getParent().getAgentState()).getpreciosProductosComercios());
		
		((EstadoAgente) node.getAction().getagState()).setmapaDist(
				((EstadoAgente) node.getParent().getAgentState()).getmapaDist());
		
		((EstadoAgente) node.getAction().getagState()).setmapaTiempo(
				((EstadoAgente) node.getParent().getAgentState()).getmapaTiempo());
		
		((EstadoAgente) node.getAction().getagState()).setdistanciasOrigen(
				((EstadoAgente) node.getParent().getAgentState()).getdistanciasOrigen());
		
		((EstadoAgente) node.getAction().getagState()).settiemposOrigen(
				((EstadoAgente) node.getParent().getAgentState()).gettiemposOrigen());
		
		((EstadoAgente) node.getAction().getagState()).setprecioNafta(
				((EstadoAgente) node.getParent().getAgentState()).getprecioNafta());
		
		((EstadoAgente) node.getAction().getagState()).setprecioTransportePublico(
				((EstadoAgente) node.getParent().getAgentState()).getprecioTransportePublico());
		
		return node.getAction().getCost();
	}
}
