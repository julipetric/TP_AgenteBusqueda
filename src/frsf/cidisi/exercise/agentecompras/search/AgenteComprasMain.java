package frsf.cidisi.exercise.agentecompras.search;

import java.util.ArrayList;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class AgenteComprasMain {

    public static void main(String[] args) throws PrologConnectorException {

    	AgenteCompras agent = new AgenteCompras();
    	
        AmbienteAgenteCompras environment = new AmbienteAgenteCompras();

        SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(environment, agent);
        
        simulator.start();
    }
}
