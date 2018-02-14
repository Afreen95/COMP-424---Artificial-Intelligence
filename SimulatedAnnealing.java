import java.util.Random;

public class SimulatedAnnealing {

    // Calculate the acceptance probability
    public static double acceptanceProbability(double energy, double newEnergy, double temperature) {
        // If the new solution is worse, calculate an acceptance probability
        return Math.exp((energy - newEnergy) / temperature);
    }

    public static void main(String[] args) {
        // Set initial temp
        double temp;
        // Cooling rate
        double coolingRate = 0.003;
        	
        	for(double startPoint = 0.0; startPoint < 11; startPoint++ ) {
        		
        		for(double stepSize = 0.05; stepSize < 0.1 ; stepSize = stepSize + 0.01) {
        			
        			double nextIndex = randomIndex(startPoint, stepSize);
        			double maxEnergy = myFunction(startPoint + stepSize);
        			double maxEnergyIndex = startPoint + stepSize;
        			double currentIndex = startPoint + stepSize;
        			double energy = myFunction(currentIndex);
        			int step = 0;
        			temp = 10000;
        			
        			while (temp > 1) {
        				
        				nextIndex = randomIndex(startPoint, stepSize);
        				energy = myFunction(nextIndex);
        				
        				if(energy > maxEnergy) {
        					maxEnergy = energy;
        					maxEnergyIndex = nextIndex;
        					
        				}
        				
        				if(energy < myFunction(currentIndex)) {
        					energy = myFunction(currentIndex);
        					//TODO
        					nextIndex = currentIndex;
        					
        				}
        				else{
        					if (acceptanceProbability(energy, myFunction(currentIndex), temp) > Math.random()) {
        						energy = myFunction(currentIndex);
            					nextIndex = currentIndex;  
        		            }
        				}

        	            // Cool system
        	            temp -= 42;
        	            step++;
        			}
        			
        			System.out.println(startPoint + "\t" + Math.round((stepSize) * 100D) / 100D  + "\t" + Math.round((maxEnergyIndex) * 100D) / 100D + "\t" + (Math.round(maxEnergy * 10000D) / 10000D) + "\t\t" + step);

        		}
            
        	}	
        }
    
    public static double randomIndex(double startPoint, double stepSize) {
    	double randomStep = startPoint + stepSize*randomInteger()*30;
    	
    	if(randomStep >=0  && randomStep <= 10) {
    		return randomStep;
    	}
    	else {
    		return randomIndex(startPoint, stepSize);
    	}
    }
    
    public static double randomInteger() {
    	Random rng = new Random();
    	// to get a double between -1 and 1
    	return rng.nextDouble() * 2 - 1;
    }
    
    public static double randomCoolingInteger() {
    	Random rng = new Random();
    	// to get a double between -1 and 1
    	return rng.nextDouble();
    }

    
public static double myFunction(double startPoint) {
	return (Math.sin(((startPoint)*(startPoint))/2))/(Math.log(startPoint+4)/Math.log(2));
	}
}