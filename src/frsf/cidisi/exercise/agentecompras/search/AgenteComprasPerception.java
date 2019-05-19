package frsf.cidisi.exercise.agentecompras.search;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AgenteComprasPerception extends Perception {

    public static int UNKNOWN_PERCEPTION = -1;   
	
	
	//Setup Sensors
    //0 representa que no se perciben modificaciones, 1 que si hay modificaciones.
	private int imprevisto;
	private int cambioCostosTransporte;
	private int ofertas;
	private Double[][] ofertasM;
	
 

    public  AgenteComprasPerception() {
    	imprevisto = 0;
    	cambioCostosTransporte = 0;
    	ofertas = 0;
    }

    public AgenteComprasPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    @Override
    public void initPerception(Agent agentIn, Environment environmentIn) {
    	
    	//TODO: Complete Method
        //AgenteCompras agent = (AgenteCompras) agentIn;
        //AmbienteAgenteCompras environment = (AmbienteAgenteCompras) environmentIn;
        //EstadoAmbiente environmentState = environment.getEnvironmentState();
        
    }
    
    @Override
    public String toString() {
        //StringBuffer str = new StringBuffer();
        String str = "";
        
        if (this.ofertas==1)
        	str+="Hay ofertas / ";
        	else
        		str+="No hay ofertas / ";
        
        if (this.imprevisto==1)
        	str+="Hay imprevistos / ";
        	else
        		str+="No hay imprevistos / ";
        
        if (this.cambioCostosTransporte==1)
        	str+="Hay cambios en los cosos de transporte.";
        	else
        		str+="No hay cambios en los costos de transporte.";

        return str.toString();
    }

    // The following methods are agent-specific:
    //TODO: Complete this section with the agent-specific methods
	
     public int getimprevisto(){
        return imprevisto;
     }
     public void setimprevisto(int arg){
        this.imprevisto = arg;
     }
     public int getcambioCostosTransporte(){
        return cambioCostosTransporte;
     }
     public void setcambioCostosTransporte(int arg){
        this.cambioCostosTransporte = arg;
     }
     public int getofertas(){
        return ofertas;
     }
     public void setofertas(int arg){
        this.ofertas = arg;
     }

	public Double[][] getOfertasM() {
		return ofertasM;
	}

	public void setOfertasM(Double[][] ofertasM) {
		this.ofertasM = ofertasM;
	}
	
   
}
