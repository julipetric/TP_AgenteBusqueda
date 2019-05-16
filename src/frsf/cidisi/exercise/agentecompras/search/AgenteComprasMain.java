package frsf.cidisi.exercise.agentecompras.search;

import java.util.ArrayList;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class AgenteComprasMain {

    public static void main(String[] args) throws PrologConnectorException {
        
    	//DEFINICION DE PARAMETROS INICIALES PARTICULARES DE UN CASO DE EJECUCION
    	//Productos deseados: 2, 4 y 5
    	ArrayList<Integer> listaProductosDeseados = new ArrayList<Integer>();
    	listaProductosDeseados.add(2);
    	listaProductosDeseados.add(4);
    	listaProductosDeseados.add(5);
    	
    	//Transporte preferido: indefinido
    	int tipoTransporte = 0;
    	
    	//Matriz con los tiempos que lleva llegar del origen propuesto a cada uno de los destinos 
    	//en bici, auto y transporte publico
    	int [][] tiemposOrigen = new int[][] {
    			{2,	4,	4,	4,	7},
    			{1,	2,	2,	2,	3},
    			{2,	4,	4,	4,	6}
    	};
    	
    	//Matriz para las distancias que representa moverse del origen propuesto a cada uno de los destinos 
    	//en bici, auto y transporte publico
    	int[][] distOrigen = new int[][] {
    			{308,	616,	616,	616,	924},
    			{240,	480,	480,	480,	720},
    			{420,	840,	840,	840,	1260}
    	};
    	
    	//Definicion recurso a priorizar: costo mínimo total
    	int recurso = 1;
    	//FIN DEFINICION PARAMETROS INCIALES
    	
    	
    	AgenteCompras agent = new AgenteCompras(listaProductosDeseados, tipoTransporte, tiemposOrigen, distOrigen, recurso);
    	
        AmbienteAgenteCompras environment = new AmbienteAgenteCompras();

        SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(environment, agent);
        
        simulator.start();
    }

}
