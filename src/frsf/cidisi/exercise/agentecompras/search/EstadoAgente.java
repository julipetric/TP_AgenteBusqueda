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
	private Double[][][] mapaTiempo;
	private Double[][][] mapaDist;
	private int tipoTransporte;
	private ArrayList<Integer> listaProductosDeseados;
	private ArrayList<Integer> listaProductos;
	private int recursoAPriorizar;
	private Double[][] tiemposOrigen;
	private Double[][] distanciasOrigen;
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
    	int imprevistosPercibida = percepcion.getimprevisto();
    	int cambioCostosTransportePercibida = percepcion.getcambioCostosTransporte();
    	
    	
    	if (ofertasPercibida==1) {
    		
    		for (int i=0; i<5; i++) 
    			for (int j=0; j<6; j++) 
    				if (percepcion.getOfertasM()[i][j] != 1.0) {
    					this.preciosProductosComercios[i][j] = 	this.preciosProductosComercios[i][j]
    															+this.preciosProductosComercios[i][j]*percepcion.getOfertasM()[i][j];
    				}			
    	}
    	
    	
    	if (imprevistosPercibida==1) {
    		
    		for (int i=0; i<3; i++) {
    			for (int j=0; j<5; j++) {
    				for (int k=0; k<5;k++){
    					this.mapaDist[i][j][k] = this.mapaDist[i][j][k] + this.mapaDist[i][j][k] * percepcion.getImprevistosDistM()[i][j][k];
    					this.mapaTiempo[i][j][k] = this.mapaTiempo[i][j][k] + this.mapaTiempo[i][j][k] * percepcion.getImprevistosTiempoM()[i][j][k];
    				}
    			}
    		}
    		
    		for (int i=0; i<3; i++) {
    			for (int j=0; j<5; j++) {
    				this.distanciasOrigen[i][j] = this.distanciasOrigen[i][j] + this.distanciasOrigen[i][j] * percepcion.getImprevistosDistOrigenM()[i][j];
    				this.tiemposOrigen[i][j] = this.tiemposOrigen[i][j] + this.tiemposOrigen[i][j] * percepcion.getImprevistosTiempoOrigenM()[i][j];
    			}
    		
    	}
    					
    	}
    	
    	
    	if (cambioCostosTransportePercibida==1) {
    		this.precioNafta = this.precioNafta + this.precioNafta * percepcion.getCambioCostoNafta();
    		this.precioTransportePublico = this.precioTransportePublico + this.precioTransportePublico * percepcion.getCambioCostoTransportePublico();
    	}
    	
    	
	}
	/**
	 * This method is optional, and sets the initial state of the agent.
	 */
	@Override
	public void initState() {
		mapaTiempo = new Double[3][][];
		mapaDist = new Double[3][][];
		listaProductos = new ArrayList<Integer>();

		this.posicionPrevia = -1;
		this.posicionActual = -1;

		Double[][] mapaTiempoBici = new Double[][] 	{ 
													{ 0.0, 4.0, 7.0, 7.0, 9.0 }, 
													{ 4.0, 0.0, 2.0, 4.0, 7.0 },
													{ 7.0, 2.0, 0.0, 2.0, 7.0 },
													{ 7.0, 4.0, 2.0, 0.0, 4.0 }, 
													{ 9.0, 7.0, 7.0, 4.0, 0.0 } 
													};

		Double[][] mapaTiempoAuto = new Double[][] 	{ 
													{ 0.0, 2.0, 3.0, 3.0, 4.0 }, 
													{ 2.0, 0.0, 1.0, 2.0, 3.0 }, 
													{ 3.0, 1.0, 0.0, 1.0, 3.0 },
													{ 3.0, 2.0, 1.0, 0.0, 2.0 }, 
													{ 4.0, 3.0, 3.0, 2.0, 0.0 } 
													};

		Double[][] mapaTiempoCole = new Double[][] 	{ 
													{ 0.0, 4.0, 6.0, 6.0, 8.0 }, 
													{ 4.0, 0.0, 2.0, 4.0, 6.0 }, 
													{ 6.0, 2.0, 0.0, 2.0, 6.0 },
													{ 6.0, 4.0, 2.0, 0.0, 4.0 }, 
													{ 8.0, 6.0, 6.0, 4.0, 0.0 } 
													};

		mapaTiempo[0] = mapaTiempoBici;
		mapaTiempo[1] = mapaTiempoAuto;
		mapaTiempo[2] = mapaTiempoCole;

		Double[][] mapaDistBici = new Double[][] 	{ 
											{ 0.0, 616.0, 924.0, 924.0, 1232.0 }, 
											{ 616.0, 0.0, 308.0, 616.0, 924.0 },
											{ 924.0, 308.0, 0.0, 308.0, 924.0 }, 
											{ 924.0, 616.0, 308.0, 0.0, 616.0 }, 
											{ 1232.0, 924.0, 924.0, 616.0, 0.0 } 
											};

		Double[][] mapaDistAuto = new Double[][] 	{ 
											{ 0.0, 480.0, 720.0, 720.0, 960.0 }, 
											{ 480.0, 0.0, 240.0, 480.0, 720.0 },
											{ 720.0, 240.0, 0.0, 240.0, 720.0 }, 
											{ 720.0, 480.0, 240.0, 0.0, 480.0 }, 
											{ 960.0, 720.0, 720.0, 480.0, 0.0 } 
											};

		Double[][] mapaDistCole = new Double[][] 	{ 
											{ 0.0, 840.0, 1260.0, 1260.0, 1680.0 }, 
											{ 840.0, 0.0, 420.0, 840.0, 1260.0 },
											{ 1260.0, 420.0, 0.0, 420.0, 1260.0 }, 
											{ 1260.0, 840.0, 420.0, 0.0, 840.0 }, 
											{ 1680.0, 1260.0, 1260.0, 840.0, 0.0 } 
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
		listaProductosDeseados.add(0);
		listaProductosDeseados.add(1);
		listaProductosDeseados.add(3);
		listaProductosDeseados.add(4);
		listaProductosDeseados.add(5);

		// Transporte preferido: auto (2)
		tipoTransporte = 2;

		// Matriz con los tiempos que lleva llegar del origen propuesto a cada uno de
		// los destinos
		// en bici, auto y transporte publico
		tiemposOrigen = new Double[][] { 
									{ 2.0, 4.0, 4.0, 4.0, 7.0 }, 
									{ 1.0, 2.0, 2.0, 2.0, 3.0 }, 
									{ 2.0, 4.0, 4.0, 4.0, 6.0 } 
									};

		// Matriz para las distancias que representa moverse del origen propuesto a cada
		// uno de los destinos
		// en bici, auto y transporte publico
		distanciasOrigen = new Double[][] 	{ 
										{ 308.0, 616.0, 616.0, 616.0, 924.0 }, 
										{ 240.0, 480.0, 480.0, 480.0, 720.0 },
										{ 420.0, 840.0, 840.0, 840.0, 1260.0 } 
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

	public Double[][][] getmapaTiempo() {
		return mapaTiempo;
	}

	public void setmapaTiempo(Double[][][] arg) {
		mapaTiempo = arg;
	}

	public Double[][][] getmapaDist() {
		return mapaDist;
	}

	public void setmapaDist(Double[][][] arg) {
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

	public Double[][] gettiemposOrigen() {
		return tiemposOrigen;
	}

	public void settiemposOrigen(Double[][] arg) {
		tiemposOrigen = arg;
	}

	public Double[][] getdistanciasOrigen() {
		return distanciasOrigen;
	}

	public void setdistanciasOrigen(Double[][] arg) {
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
