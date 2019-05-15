package frsf.cidisi.exercise.agentecompras.search;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AgenteComprasPerception extends Perception {

	//TODO: Setup Statics
    //public static int UNKNOWN_PERCEPTION = -1;   
	
	
	//TODO: Setup Sensors
	private boolean imprevisto;
	private int cambio en costos transporte;
	private int ofertas;
	
 

    public  AgenteComprasPerception() {
    	//TODO: Complete Method
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
        //EstadoAmbiente environmentState =
        //        environment.getEnvironmentState();
       
        
    }
    
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        //TODO: Complete Method

        return str.toString();
    }

    // The following methods are agent-specific:
    //TODO: Complete this section with the agent-specific methods
	
     public boolean getimprevisto(){
        return imprevisto;
     }
     public void setimprevisto(boolean arg){
        this.imprevisto = arg;
     }
     public int getcambio en costos transporte(){
        return cambio en costos transporte;
     }
     public void setcambio en costos transporte(int arg){
        this.cambio en costos transporte = arg;
     }
     public int getofertas(){
        return ofertas;
     }
     public void setofertas(int arg){
        this.ofertas = arg;
     }
	
   
}
