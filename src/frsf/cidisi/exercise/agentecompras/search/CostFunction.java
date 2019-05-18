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

		if(node.getParent() != null) {
			double costo = node.getAction().getCost();
			costo += calculateCost(node.getParent());
			return costo;
		} else {
			return node.getAction().getCost();
		}
	}
}
