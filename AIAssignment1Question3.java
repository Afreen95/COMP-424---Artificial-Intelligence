
public class AIAssignment1Question3 {
	
	public static void main(String[] args) {
		
		
		
	double maxLeftY = -Double.MAX_VALUE;
	double maxRightY = -Double.MAX_VALUE;
	double maxLeftX = 0;
	double maxRightX = 0;
	int stepsLeft = 0;
	int stepsRight = 0;
	
	
	for(double startPoint = 0.0; startPoint < 11; startPoint++ ) {
		
		for(double stepSize = 0.01; stepSize < 0.1 ; stepSize = stepSize + 0.01) {
			maxLeftY = -Double.MAX_VALUE;
			maxRightY = -Double.MAX_VALUE;
			maxLeftX = startPoint;
			stepsLeft = 0;
			stepsRight = 0;
			while(maxLeftY <= myFunction(maxLeftX) && maxLeftX >= 0.0) {
				if(maxLeftY < myFunction(maxLeftX)) {
					++stepsLeft;
				}
				maxLeftY = myFunction(maxLeftX);
				maxLeftX -= stepSize;
				
			}

			maxRightX = startPoint;
			while(maxRightY <= myFunction(maxRightX) && maxRightX <= 10) {
				
				if(maxRightY < myFunction(maxRightX)) {
					++stepsRight;
				}
				maxRightY = myFunction(maxRightX);
				maxRightX += stepSize;
			}
			
			/*
			if(maxRightY > maxLeftY) {
				System.out.println("Start Point: " + startPoint + " Step: " + Math.round((stepSize) * 100D) / 100D  + " X Value:  " + Math.round((maxRightX - stepSize) * 100D) / 100D + " corresponds to " + (Math.round(maxRightY * 10000D) / 10000D) + " with " + (stepsRight) + " steps.");
			}
			else {
				System.out.println("Start Point: " + startPoint + " Step: " + Math.round((stepSize) * 100D) / 100D + " X Value: " + Math.round((maxLeftX + stepSize) * 100D) / 100D + " corresponds to " + (Math.round(maxLeftY * 10000D) / 10000D) + " with " + (stepsLeft) + " steps.");
			}
			*/
			
			if(maxRightY > maxLeftY) {
				System.out.println(startPoint + "\t" + Math.round((stepSize) * 100D) / 100D  + "\t" + Math.round((maxRightX - stepSize) * 100D) / 100D + "\t" + (Math.round(maxRightY * 10000D) / 10000D) + "\t\t" + (stepsRight -  1));
			}
			else {
				System.out.println(startPoint + "\t" + Math.round((stepSize) * 100D) / 100D + "\t" + Math.round((maxLeftX + stepSize) * 100D) / 100D + "\t" + (Math.round(maxLeftY * 10000D) / 10000D) + "\t\t" + (stepsLeft - 1));
			}
			
			/*
			
			if(maxRightY > maxLeftY) {
				System.out.println((Math.round(maxRightY * 10000D) / 10000D));
			}
			else {
				System.out.println((Math.round(maxLeftY * 10000D) / 10000D));
			}
				*/
			}

		}
		
	}
	
	public static double myFunction(double startPoint) {
		return (Math.sin(((startPoint)*(startPoint))/2))/(Math.log(startPoint+4)/Math.log(2));
	}
}
