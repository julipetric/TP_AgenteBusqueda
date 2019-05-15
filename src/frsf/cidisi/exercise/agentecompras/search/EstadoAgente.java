package frsf.cidisi.exercise.agentecompras.search;

import java.util.ArrayList;

import frsf.cidisi.exercise.domain.Producto;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * Represent the internal state of the Agent.
 */
public class EstadoAgente extends SearchBasedAgentState {
	
	//TODO: Setup Variables
    //private Other listaProductos;
    private int posicionActual;
    private int[][] mapaTiempo;
    private int[][] mapaDist;
    private int tipoTransporte;
    private int[] listaProductosDeseados;
    private int[] listaProductos;
    private String recursoAPriorizar;
    private int[][] tiemposOrigen;
    private int[][] distanciasOrigen;
	

    public EstadoAgente(int[] productosDeseados, int tipoTransporte) {
    
			// posicionActual = initData1;
			// mapaTiempo = initData2;
			// mapaDist = initData3;
			// tipoTransporte = initData4;
			// listaProductosDeseada = initData5;
			// recursoAPriorizar = initData6;
			// tiemposOrigen = initData7;
			// distanciasOrigen = initData8;
        this.initState();
        this.setlistaProductosDeseados(productosDeseados);
        this.settipoTransporte(tipoTransporte);
    }

    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
		//TODO: Complete Method
		
        return null;
    }

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        
        //TODO: Complete Method
    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
        
    	this.posicionActual = -1;

    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method

        return str;
    }

    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
       
       //TODO: Complete Method
        
        return true;
    }

    //TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
   	
//     public Other getlistaProductos(){
//        return listaProductos;
//     }
//     public void setlistaProductos(Other arg){
//        listaProductos = arg;
//     }
     public int getposicionActual(){
        return posicionActual;
     }
     public void setposicionActual(String arg){
        posicionActual = arg;
     }
     public int[][] getmapaTiempo(){
        return mapaTiempo;
     }
     public void setmapaTiempo(int[][] arg){
        mapaTiempo = arg;
     }
     public int[][] getmapaDist(){
        return mapaDist;
     }
     public void setmapaDist(int[][] arg){
        mapaDist = arg;
     }
     public int gettipoTransporte(){
        return tipoTransporte;
     }
     public void settipoTransporte(int arg){
        tipoTransporte = arg;
     }
     public int[] getlistaProductosDeseados(){
        return listaProductosDeseados;
     }
     public void setlistaProductosDeseados(int[] arg){
        listaProductosDeseados = arg;
     }
     public String getrecursoAPriorizar(){
        return recursoAPriorizar;
     }
     public void setrecursoAPriorizar(String arg){
        recursoAPriorizar = arg;
     }
     public int[][] gettiemposOrigen(){
        return tiemposOrigen;
     }
     public void settiemposOrigen(int[][] arg){
        tiemposOrigen = arg;
     }
     public int[][] getdistanciasOrigen(){
        return distanciasOrigen;
     }
     public void setdistanciasOrigen(int[][] arg){
        distanciasOrigen = arg;
     }
	
}

