package frsf.cidisi.exercise.agentecompras.search;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AmbienteAgenteCompras extends Environment {

    public AmbienteAgenteCompras() {
        // Create the environment state
        this.environmentState = new EstadoAmbiente();
    }

    public EstadoAmbiente getEnvironmentState() {
        return (EstadoAmbiente) super.getEnvironmentState();
    }

    /**
     * This method is called by the simulator. Given the Agent, it creates
     * a new perception reading, for example, the agent position.
     * @param agent
     * @return A perception that will be given to the agent by the simulator.
     */
    @Override
    public  AgenteComprasPerception getPercept() {
        // Create a new perception to return
         AgenteComprasPerception perception = new AgenteComprasPerception();
		
         int n= (int) (Math.random()*10);

         if (n==0 || n==1) {
        	 //Hay un 20% de probabilidad de que haya ofertas.
        	 perception.setofertas(1);
        	 perception.setcambioCostosTransporte(0);
        	 perception.setimprevisto(0);
        	 
           	 Double[][] matriz = new Double[][] 	{ 
													{ -0.5, -0.15, -0.5, 0.0, 0.0, 0.0 },
													{ 0.0, -0.5, 0.0, -0.2, 0.0, 0.0 },
													{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
													{ 0.0, -0.3, -0.2, 0.0, -0.15, -0.1 },
													{ 0.0, 0.0, 0.0, 0.0, -0.4, 0.0 } 
													};	
			perception.setOfertasM(matriz);
         }
         else if (n==2) {
        	 //Hay un 10% de probabilidad de que haya imprevistos.
        	 
        	 perception.setofertas(0);
        	 perception.setcambioCostosTransporte(0);
        	 perception.setimprevisto(1);
        	
        	 Double[][][] imprevistosDist = new Double[3][][];
        	 
     		 Double[][] imprevistosDistBici = new Double[][] 	{ 
     															{ 0.0, 0.1, 0.2, 0.0, 0.15 }, 
     															{ 0.1, 0.0, 0.0, 0.0, 0.3 },
     															{ 0.2, 0.0, 0.0, 0.2, 0.0 }, 
     															{ 0.0, 0.0, 0.2, 0.0, 0.1 }, 
     															{ 0.15, 0.3, 0.0, 0.1, 0.0 } 
																};

			 Double[][] imprevistosDistAuto = new Double[][] 	{ 
																{ 0.0, 0.3, 0.2, 0.0, 0.15 }, 
																{ 0.3, 0.0, 0.4, 0.0, 0.6 },
																{ 0.2, 0.4, 0.0, 0.0, 0.35 }, 
																{ 0.0, 0.0, 0.0, 0.0, 0.4 }, 
																{ 0.15, 0.6, 0.35, 0.4, 0.0 } 
																};

			 Double[][] imprevistosDistCole = new Double[][] 	{ 
																{ 0.0, 0.1, 0.2, 0.1, 0.0 }, 
																{ 0.1, 0.0, 0.0, 0.0, 0.3 },
																{ 0.2, 0.0, 0.0, 0.2, 0.0 }, 
																{ 0.1, 0.0, 0.2, 0.0, 0.1 }, 
																{ 0.0, 0.3, 0.0, 0.1, 0.0 } 
																};
			imprevistosDist[0] = imprevistosDistBici;
			imprevistosDist[1] = imprevistosDistAuto;
			imprevistosDist[2] = imprevistosDistCole;
			perception.setImprevistosDistM(imprevistosDist);
			
			
			
			Double[][][] imprevistosTiempo = new Double[3][][];
    	 
    		Double[][] imprevistosTiempoBici = new Double[][] 	{ 
    															{ 0.0, 0.1, 0.2, 0.0, 0.15 }, 
    															{ 0.1, 0.0, 0.0, 0.0, 0.3 },
    															{ 0.2, 0.0, 0.0, 0.2, 0.35 }, 
    															{ 0.0, 0.0, 0.2, 0.0, 0.1 }, 
    															{ 0.15, 0.3, 0.35, 0.1, 0.0 } 
																};

			Double[][] imprevistosTiempoAuto = new Double[][] 	{ 
																{ 0.0, 0.3, 0.2, 0.0, 0.15 }, 
																{ 0.3, 0.0, 0.0, 0.0, 0.3 },
																{ 0.2, 0.0, 0.0, 0.0, 0.35 }, 
																{ 0.0, 0.0, 0.0, 0.0, 0.4 }, 
																{ 0.15, 0.3, 0.35, 0.4, 0.0 } 
																};

			Double[][] imprevistosTiempoCole = new Double[][] 	{ 
																{ 0.0, 0.1, 0.2, 0.1, 0.0 }, 
																{ 0.1, 0.0, 0.1, 0.0, 0.3 },
																{ 0.2, 0.1, 0.0, 0.2, 0.0 }, 
																{ 0.1, 0.0, 0.2, 0.0, 0.1 }, 
																{ 0.0, 0.3, 0.0, 0.1, 0.0 } 
																};
			imprevistosTiempo[0] = imprevistosTiempoBici;
			imprevistosTiempo[1] = imprevistosTiempoAuto;
			imprevistosTiempo[2] = imprevistosTiempoCole;
			perception.setImprevistosTiempoM(imprevistosTiempo);
			
			
			Double [][] imprevistosDistanciaOrigen = new Double[][] 	{ 
																		{ 0.1, 0.1, 0.0, 0.0, 0.25 }, 
																		{ 0.2, 0.4, 0.0, 0.0, 0.1 }, 
																		{ 0.1, 0.2, 0.0, 0.3, 0.0 } 
																		};
			perception.setImprevistosDistOrigenM(imprevistosDistanciaOrigen);
																		
			Double [][] imprevistosTiemposOrigen = new Double[][] 		{ 
																		{ 0.1, 0.0, 0.0, 0.0, 0.0 }, 
																		{ 0.2, 0.0, 0.0, 0.1, 0.0 }, 
																		{ 0.0, 0.25, 0.0, 0.1, 0.0 } 
																		};
			perception.setImprevistosTiempoOrigenM(imprevistosTiemposOrigen);
																	
         }
         else if (n==3) {
        	 //Hay un 10% de probabilidad de que haya cambios en los costos de transporte.
        	 perception.setofertas(0);
        	 perception.setcambioCostosTransporte(1);
        	 perception.setimprevisto(0);
        	 
        	 perception.setCambioCostoNafta(0.1);
        	 perception.setCambioCostoTransportePublico(-0.1);
         }
         else {
        	 //Hay un 60% de probabilidad de que no pase nada.
        	 perception.setofertas(0);
        	 perception.setcambioCostosTransporte(0);
        	 perception.setimprevisto(0);
         }
        
        // Return the perception
        return perception;
    }

    
    public String toString() {
        return ""; //environmentState.toString();
    }

    
    public boolean agentFailed(Action actionReturned) {

        EstadoAmbiente envState =
                this.getEnvironmentState();

        // TODO: Complete Method        

        return false;
    }

	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
    
    
}
