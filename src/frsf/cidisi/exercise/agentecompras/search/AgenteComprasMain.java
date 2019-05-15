package frsf.cidisi.exercise.agentecompras.search;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class AgenteComprasMain {

    public static void main(String[] args) throws PrologConnectorException {
        
    	//DEFINICION DE PARAMETROS INICIALES
    	//Prodcutos deseados: 2, 4 y 5
    	int [] listaProductosDeseados = new int[] {2, 4, 5};
    	
    	//Trasnporte preferido: indefinido
    	int tipoTransporte = 0;
    	
    	//Matriz con los tiempos que lleva llegar del origen propuesto a cada uno de los destinos 
    	//en bici, auto o transporte publico
    	int [][] tiemposOrigen = new int[][] {
    			{2,	4,	4,	4,	7},
    			{1,	2,	2,	2,	3},
    			{2,	4,	4,	4,	6}
    	};
    	
    	
    	//FIN DEFINICION PARAMETROS INCIALES
    	
    	AgenteCompras agent = new AgenteCompras(listaProductosDeseados, tipoTransporte);
    	


        AmbienteAgenteCompras environment = new AmbienteAgenteCompras();

        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(environment, agent);
        
        simulator.start();
    }

}
