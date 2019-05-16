package frsf.cidisi.exercise.agentecompras.search;

import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class EstadoAmbiente extends EnvironmentState {
	
    private int[][] preciosProductosComercios;
    private double costoNafta;
    private double costoTransportePublico;
    private int[][] imprevistosTiempo;
    private int[][] imprevistosDist;
    private int[][] ofertas;
    private int[][] imprevistosTiempoOrigen;
    private int[][] imprevistosDistOrigen;
	
    public EstadoAmbiente() {
        
			// imprevistosTiempo = initData3;
			// imprevistosDist = initData4;
			// ofertas = initData5;
			// imprevistosTiempoOrigen = initData6;
			// imprevistosDistOrigen = initData7;

        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {

        //Estado inicial del estado del ambiente - Escenario de entrada.
    	
		preciosProductosComercios = new int[][] {
    			{30, 70, 110, 20, 48, 188},
    			{25, 66, 115, 22, 50, 183},
    			{27, 80, 125, 18, 54, 170},
    			{29, 81, 120, 25, 52, 190},
    			{24, 75, 130, 22, 44, 179}
    	};
		
		//Asumimos que está $45 el litro de nafta, y consideramos que se recorren 14km por litro consumido.
		//Las distancias estan expresadas en metros, por lo que para calcular los costos de combustible se 
		//multiplicará costoNafta por los metros recorridos.
		costoNafta = 45/14000; 
		costoTransportePublico = 0.5*costoNafta;
    	
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method

        return str;
    }

	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
	
     public int[][] getpreciosProductosComercios(){
        return preciosProductosComercios;
     }
     public void setpreciosProductosComercios(int[][] arg){
        preciosProductosComercios = arg;
     }
     public double getcostoNafta(){
        return costoNafta;
     }
     public void setcostoNafta(double arg){
        costoNafta = arg;
     }
     public double getcostoTransportePublico(){
        return costoTransportePublico;
     }
     public void setcostoTransportePublico(double arg){
        costoTransportePublico = arg;
     }
     public int[][] getimprevistosTiempo(){
        return imprevistosTiempo;
     }
     public void setimprevistosTiempo(int[][] arg){
        imprevistosTiempo = arg;
     }
     public int[][] getimprevistosDist(){
        return imprevistosDist;
     }
     public void setimprevistosDist(int[][] arg){
        imprevistosDist = arg;
     }
     public int[][] getofertas(){
        return ofertas;
     }
     public void setofertas(int[][] arg){
        ofertas = arg;
     }
     public int[][] getimprevistosTiempoOrigen(){
        return imprevistosTiempoOrigen;
     }
     public void setimprevistosTiempoOrigen(int[][] arg){
        imprevistosTiempoOrigen = arg;
     }
     public int[][] getimprevistosDistOrigen(){
        return imprevistosDistOrigen;
     }
     public void setimprevistosDistOrigen(int[][] arg){
        imprevistosDistOrigen = arg;
     }
	

}

