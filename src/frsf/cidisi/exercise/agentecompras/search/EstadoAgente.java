package frsf.cidisi.exercise.agentecompras.search;

import java.util.ArrayList;
import java.util.Collections;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * Represent the internal state of the Agent.
 */
public class EstadoAgente extends SearchBasedAgentState {

	// TODO: Setup Variables
	// private Other listaProductos;
	private int posicionPrevia;
	private int posicionActual;
	private int[][][] mapaTiempo;
	private int[][][] mapaDist;
	private int tipoTransporte;
	private ArrayList<Integer> listaProductosDeseados;
	private ArrayList<Integer> listaProductos;
	private int recursoAPriorizar;
	private int[][] tiemposOrigen;
	private int[][] distanciasOrigen;
	private double precioNafta;
	private double precioTransportePublico;
	private Double[][] preciosProductosComercios;

	public EstadoAgente() {
		this.initState();
	}
	/*
	 * public EstadoAgente(ArrayList<Integer> listaProductosDeseados, int
	 * tipoTransporte, int[][] tiemposOrigen, int[][] distOrigen, int recurso) {
	 * mapaTiempo = new int[3][][]; mapaDist = new int[3][][]; listaProductos = new
	 * ArrayList<Integer>(); this.posicionActual = -1; this.initState();
	 * this.setlistaProductosDeseados(listaProductosDeseados);
	 * this.settipoTransporte(tipoTransporte); this.settiemposOrigen(tiemposOrigen);
	 * this.setdistanciasOrigen(distOrigen); this.setrecursoAPriorizar(recurso); }
	 */

	/**
	 * This method clones the state of the agent. It's used in the search process,
	 * when creating the search tree.
	 */
	@Override
	public SearchBasedAgentState clone() {

		EstadoAgente estado = new EstadoAgente();

		/*
		 * estado.setlistaProductos((ArrayList<Integer>) this.getlistaProductos());
		 */

		ArrayList<Integer> listaProd = new ArrayList<>();
		listaProd.addAll(this.getlistaProductos());
		estado.setlistaProductos(listaProd);
		
		estado.setposicionActual(this.getposicionActual());

		return estado;
	}

	/**
	 * This method is used to update the Agent State when a Perception is received
	 * by the Simulator.
	 */
	@Override
	public void updateState(Perception p) {

    	AgenteComprasPerception percepcion = (AgenteComprasPerception) p;
    	
    	int ofertasPercibida = percepcion.getofertas();
    	//int imprevistosPercibida = percepcion.getimprevisto();
    	//int cambioCostosTransportePercibida = percepcion.getcambioCostosTransporte();
    	
    	if (ofertasPercibida==1) {
    		
    		for (int i=0; i<2; i++) 
    			for (int j=0; j<6; j++) 
    				if (percepcion.getOfertasM()[i][j] != 1.0) {
    					this.preciosProductosComercios[i][j] = 	this.preciosProductosComercios[i][j]
    															+this.preciosProductosComercios[i][j]*percepcion.getOfertasM()[i][j];
    				}			
    	}
	}
	/**
	 * This method is optional, and sets the initial state of the agent.
	 */
	@Override
	public void initState() {
		mapaTiempo = new int[3][][];
		mapaDist = new int[3][][];
		listaProductos = new ArrayList<Integer>();

		this.posicionPrevia = -1;
		this.posicionActual = -1;

		int[][] mapaTiempoBici = new int[][] 	{ 
												{ 0, 4, 7, 7, 9 }, 
												{ 4, 0, 2, 4, 7 },
												{ 7, 2, 0, 2, 7 },
												{ 7, 4, 2, 0, 4 }, 
												{ 9, 7, 7, 4, 0 } 
												};

		int[][] mapaTiempoAuto = new int[][] 	{ 
												{ 0, 2, 3, 3, 4 }, 
												{ 2, 0, 1, 2, 3 }, 
												{ 3, 1, 0, 1, 3 },
												{ 3, 2, 1, 0, 2 }, 
												{ 4, 3, 3, 2, 0 } 
												};

		int[][] mapaTiempoCole = new int[][] 	{ 
												{ 0, 4, 6, 6, 8 }, 
												{ 4, 0, 2, 4, 6 }, 
												{ 6, 2, 0, 2, 6 },
												{ 6, 4, 2, 0, 4 }, 
												{ 8, 6, 6, 4, 0 } 
												};

		mapaTiempo[0] = mapaTiempoBici;
		mapaTiempo[1] = mapaTiempoAuto;
		mapaTiempo[2] = mapaTiempoCole;

		int[][] mapaDistBici = new int[][] 	{ 
											{ 0, 616, 924, 924, 1232 }, 
											{ 616, 0, 308, 616, 924 },
											{ 924, 308, 0, 308, 924 }, 
											{ 924, 616, 308, 0, 616 }, 
											{ 1232, 924, 924, 616, 0 } 
											};

		int[][] mapaDistAuto = new int[][] 	{ 
											{ 0, 480, 720, 720, 960 }, 
											{ 480, 0, 240, 480, 720 },
											{ 720, 240, 0, 240, 720 }, 
											{ 720, 480, 240, 0, 480 }, 
											{ 960, 720, 720, 480, 0 } 
											};

		int[][] mapaDistCole = new int[][] 	{ 
											{ 0, 840, 1260, 1260, 1680 }, 
											{ 840, 0, 420, 840, 1260 },
											{ 1260, 420, 0, 420, 1260 }, 
											{ 1260, 840, 420, 0, 840 }, 
											{ 1680, 1260, 1260, 840, 0 } 
											};

		mapaDist[0] = mapaDistBici;
		mapaDist[1] = mapaDistAuto;
		mapaDist[2] = mapaDistCole;

		// Asumimos que está $45 el litro de nafta, y consideramos que se recorren 8km
		// por litro consumido.
		// Las distancias estan expresadas en metros, por lo que para calcular los
		// costos de combustible se
		// multiplicará costoNafta por los metros recorridos.
		precioNafta = 45 / 8;
		precioTransportePublico = 0.5 * precioNafta;

		preciosProductosComercios = new Double[][] 	{ 
													{ 30.0, 70.0, 110.0, 20.0, Double.MAX_VALUE, 188.0 },
													{ 25.0, 66.0, Double.MAX_VALUE, 22.0, 50.0, 183.0 },
													{ 27.0, Double.MAX_VALUE, 125.0, 18.0, 54.0, 170.0 },
													{ Double.MAX_VALUE, 81.0, 120.0, 25.0, 52.0, 190.0 },
													{ 24.0, 75.0, 130.0, 22.0, 44.0, Double.MAX_VALUE } 
													};

		// DEFINICION DE PARAMETROS INICIALES INGRESADOS POR EL USUARIO
		// Productos deseados: 1, 2 y 5
		listaProductosDeseados = new ArrayList<Integer>();
		listaProductosDeseados.add(1);
		listaProductosDeseados.add(0);

		// Transporte preferido: auto (2)
		tipoTransporte = 2;

		// Matriz con los tiempos que lleva llegar del origen propuesto a cada uno de
		// los destinos
		// en bici, auto y transporte publico
		tiemposOrigen = new int[][] { 
									{ 2, 4, 4, 4, 7 }, 
									{ 1, 2, 2, 2, 3 }, 
									{ 2, 4, 4, 4, 6 } 
									};

		// Matriz para las distancias que representa moverse del origen propuesto a cada
		// uno de los destinos
		// en bici, auto y transporte publico
		distanciasOrigen = new int[][] 	{ 
										{ 308, 616, 616, 616, 924 }, 
										{ 240, 480, 480, 480, 720 },
										{ 420, 840, 840, 840, 1260 } 
										};

		// Definicion recurso a priorizar: tiempo (0) 
										//costo mínimo total (1)
		recursoAPriorizar = 1;
		// FIN DEFINICION PARAMETROS INCIALES
	}

	/**
	 * This method returns the String representation of the agent state.
	 */
	@Override
	public String toString() {

		String str = "\n";
		str += "Posicion actual: ";
		str += this.getposicionActual() + "\n";
		str += "listaProductos: ";
		str += this.getlistaProductos();

		return str;
	}

	/**
	 * This method is used in the search process to verify if the node already
	 * exists in the actual search.
	 */
	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof EstadoAgente)) {
			return false;
		} else {
			ArrayList<Integer> aux1 = (ArrayList<Integer>) this.getlistaProductos().clone();
			Collections.sort(aux1);
			ArrayList<Integer> aux2 = (ArrayList<Integer>) ((EstadoAgente) obj).getlistaProductos().clone();
			Collections.sort(aux2);

			boolean b1 = (aux1.size() == aux2.size());
			boolean b2 = aux1.containsAll(aux2);
			boolean b3 = (this.getposicionActual() == ((EstadoAgente) obj).getposicionActual());
			boolean b = (b1 && b2 &&  b3);

			return b;
		}

	}

	// The following methods are agent-specific:
	public int getposicionActual() {
		return posicionActual;
	}

	public void setposicionActual(int arg) {
		posicionActual = arg;
	}
	
	public int getposicionPrevia() {
		return posicionPrevia;
	}

	public void setposicionPrevia(int arg) {
		posicionPrevia = arg;
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

	public void setlistaProductos(ArrayList<Integer> arg) {
		listaProductos = arg;
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

	public double getprecioNafta() {
		return precioNafta;
	}

	public void setprecioNafta(double arg) {
		precioNafta = arg;
	}

	public double getprecioTransportePublico() {
		return precioTransportePublico;
	}

	public void setprecioTransportePublico(double arg) {
		precioTransportePublico = arg;
	}

	public Double[][] getpreciosProductosComercios() {
		return preciosProductosComercios;
	}

	public void setpreciosProductosComercios(Double[][] arg) {
		preciosProductosComercios = arg;
	}

}
