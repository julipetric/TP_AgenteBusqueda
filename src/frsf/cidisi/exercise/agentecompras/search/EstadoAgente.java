package frsf.cidisi.exercise.agentecompras.search;

import java.util.ArrayList;

import frsf.cidisi.exercise.domain.Producto;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * Represent the internal state of the Agent.
 */
public class EstadoAgente extends SearchBasedAgentState {

	// TODO: Setup Variables
	// private Other listaProductos;
	private int posicionActual;
	private int[][][] mapaTiempo;
	private int[][][] mapaDist;
	private int tipoTransporte;
	private ArrayList<Integer> listaProductosDeseados;
	private ArrayList<Integer> listaProductos;
	private int recursoAPriorizar;
	private int[][] tiemposOrigen;
	private int[][] distanciasOrigen;

	public EstadoAgente(ArrayList<Integer> listaProductosDeseados, int tipoTransporte,
			int[][] tiemposOrigen, int[][] distOrigen, int recurso) {
		this.initState();
		this.setlistaProductosDeseados(listaProductosDeseados);
		this.settipoTransporte(tipoTransporte);
		this.settiemposOrigen(tiemposOrigen);
		this.setdistanciasOrigen(distOrigen);
		this.setrecursoAPriorizar(recurso);
	}

	/**
	 * This method clones the state of the agent. It's used in the search
	 * process, when creating the search tree.
	 */
	@Override
	public SearchBasedAgentState clone() {

		// TODO: Complete Method

		return null;
	}

	/**
	 * This method is used to update the Agent State when a Perception is
	 * received by the Simulator.
	 */
	@Override
	public void updateState(Perception p) {

		// TODO: Complete Method
	}

	/**
	 * This method is optional, and sets the initial state of the agent.
	 */
	@Override
    public void initState() {
		int[][] mapaTiempoBici = new int[][] {
        		{0,	4,	7,	7,	9},
        		{4,	0,	2,	4,	7},
        		{7,	2,	0,	2,	7},
        		{7,	4,	2,	0,	4},
        		{9,	7,	7,	4,	0}
        		};
		
		int[][] mapaTiempoAuto = new int[][] {
        		{0,	2,	3,	3,	4},
        		{2,	0,	1,	2,	3},
        		{3,	1,	0,	1,	3},
        		{3,	2,	1,	0,	2},
        		{4,	3,	3,	2,	0}
        		};
        
        int[][] mapaTiempoCole = new int[][] {
        		{0,	4,	6,	6,	8},
        		{4,	0,	2,	4,	6},
        		{6,	2,	0,	2,	6},
        		{6,	4,	2,	0,	4},
        		{8,	6,	6,	4,	0}
        		};
        
        int[][][] mapaTiempo = new int[3][][];
        
        mapaTiempo[0] = mapaTiempoBici;
        mapaTiempo[1] = mapaTiempoAuto;
        mapaTiempo[2] = mapaTiempoCole;
        
        int[][] mapaDistBici = new int[][] {
        		{0,	616,	924,	924,	1232},
        		{616,	0,	308,	616,	924},
        		{924,	308,	0,	308,	924},
        		{924,	616,	308,	0,	616},
        		{1232,	924,	924,	616,	0}
        		};
		
		int[][] mapaDistAuto = new int[][] {
        		{0,	480,	720,	720,	960},
        		{480,	0,	240,	480,	720},
        		{720,	240,	0,	240,	720},
        		{720,	480,	240,	0,	480},
        		{960,	720,	720,	480,	0}
        		};
        
        int[][] mapaDistCole = new int[][] {
        		{0,	840,	1260,	1260,	1680},
        		{840,	0,	420,	840,	1260},
        		{1260,	420,	0,	420,	1260},
        		{1260,	840,	420,	0,	840},
        		{1680,	1260,	1260,	840,	0}
        		};
        
        int[][][] mapaDist = new int[3][][];
        
        mapaDist[0] = mapaDistBici;
        mapaDist[1] = mapaDistAuto;
        mapaDist[2] = mapaDistCole;

    	
    	this.posicionActual = -1;

    }

	/**
	 * This method returns the String representation of the agent state.
	 */
	@Override
	public String toString() {
		String str = "";

		// TODO: Complete Method

		return str;
	}

	/**
	 * This method is used in the search process to verify if the node already
	 * exists in the actual search.
	 */
	@Override
	public boolean equals(Object obj) {

		// TODO: Complete Method

		return true;
	}

	// TODO: Complete this section with agent-specific methods
	// The following methods are agent-specific:

	// public Other getlistaProductos(){
	// return listaProductos;
	// }
	// public void setlistaProductos(Other arg){
	// listaProductos = arg;
	// }
	public int getposicionActual() {
		return posicionActual;
	}

	public void setposicionActual(int arg) {
		posicionActual = arg;
	}

	public int[][][] getmapaTiempo() {
		return mapaTiempo;
	}

	public void setmapaTiempo(int[][][] arg) {
		mapaTiempo = arg;
	}

	public int[][][] getmapaDist() {
		return mapaDist;
	}

	public void setmapaDist(int[][][] arg) {
		mapaDist = arg;
	}

	public int gettipoTransporte() {
		return tipoTransporte;
	}

	public void settipoTransporte(int arg) {
		tipoTransporte = arg;
	}
	
	public ArrayList<Integer> getlistaProductos() {
		return listaProductos;
	}

	public ArrayList<Integer> getlistaProductosDeseados() {
		return listaProductosDeseados;
	}

	public void setlistaProductosDeseados(ArrayList<Integer> arg) {
		listaProductosDeseados = arg;
	}

	public int getrecursoAPriorizar() {
		return recursoAPriorizar;
	}

	public void setrecursoAPriorizar(int arg) {
		recursoAPriorizar = arg;
	}

	public int[][] gettiemposOrigen() {
		return tiemposOrigen;
	}

	public void settiemposOrigen(int[][] arg) {
		tiemposOrigen = arg;
	}

	public int[][] getdistanciasOrigen() {
		return distanciasOrigen;
	}

	public void setdistanciasOrigen(int[][] arg) {
		distanciasOrigen = arg;
	}

}
