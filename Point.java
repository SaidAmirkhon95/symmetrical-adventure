public class Point{
          
  public double[] arg;              

    public Point(double... pont) {
        int i =0;
    	arg=new double[pont.length];             
    	for(double dbl:pont) {
            arg[i]=dbl;
            i++;
          }
        
    }
    public double get(int i) {
        double argOfi=arg[i];
        return argOfi;
    }
    
  @Override
  public String toString() {
        
        
        StringBuilder newArg=new StringBuilder();        
        
        newArg.append("(");

        for( int i=0;i<arg.length-1;i++) {
        newArg.append(String.format("%.2f", arg[i])).append(", ");        
        }
        newArg.append(String.format("%.2f", arg[arg.length-1]));
       
        newArg.append(")");
        
        return newArg.toString();
  }
  
}