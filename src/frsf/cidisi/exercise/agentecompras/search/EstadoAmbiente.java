package frsf.cidisi.exercise.agentecompras.search;

import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class EstadoAmbiente extends EnvironmentState {
	
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

