

package frsf.cidisi.exercise.agentecompras.search;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoAgente extends GoalTest {

    @Override
    public boolean isGoalState (AgentState agentState) {

    	EstadoAgente e = (EstadoAgente) agentState;
    	
        if  (e.getlistaProductos().size()==e.getlistaProductosDeseados().size() && e.getlistaProductos().containsAll(e.getlistaProductosDeseados()) && e.getposicionActual()== -1) //(listaProductos=listaProductosDeseada) 
        	{
            	return true;
        	}
        		return false;
			}
}