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
	
 

    public  AgenteComprasPerception() {
    	imprevisto = UNKNOWN_PERCEPTION;
    	cambioCostosTransporte = UNKNOWN_PERCEPTION;
    	ofertas = UNKNOWN_PERCEPTION;
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
        StringBuffer str = new StringBuffer();

        //TODO: Complete Method

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
     public int get (){
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
	
   
}
