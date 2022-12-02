import java.util.Random;

public class PointsGenerator {

	public static double min,max;
	static Random rng=new Random();
	
	public PointsGenerator(double mini, double maxi, int seed){
		min=mini;
		max=maxi;
		rng.setSeed(seed);
	}
	
	public Point[]generate(int i){
	   int n=0;
	   Point[]arr=new Point[i];		
	   while(n<i) {
	   double coord = (rng.nextDouble() * (max - min) + min);
       double coord2= (rng.nextDouble() * (max - min) + min);
	   Point punkt=new Point(coord,coord2);
	   arr[n]=punkt;  
	   n++;
	   }	   	    
	   return arr;
	}
}
