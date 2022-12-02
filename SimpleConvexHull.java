import java.util.*;

public class SimpleConvexHull{
    public static LinkedList<Point> computeHull(Point[] p){
        LinkedList<Line> line= new LinkedList<Line>();
        LinkedList<Line> temp = new LinkedList<Line>();
        LinkedList<Point> point = new LinkedList<Point>();
        for( int i = 0; i < p.length; i++){         //List of lines
            for( int k = 1; k <p.length; k++){
                line.add(new Line(p[i], p[k]));
            }
        }
        //for every point except point in line
       for( int a= 0; a < line.size(); a++){
            boolean valid = true;
            for( int i = 0; i < p.length; i++){
                if( p[i] != line.get(a).getStart() && p[i] != line.get(a).getEnd()){
                    if( line.get(a).side(p[i])==-1){
                        valid = false;
                    }
                }
            } 
            if( valid == true){
                temp.add(line.get(a));
            } 
       }
       for( int j = 0; j < temp.size(); j++){
           point.add(temp.get(j).getStart());
           point.add(temp.get(j).getEnd());
       }
       return point;

    }
    public static LinkedList<Line> kante(LinkedList<Point> p){ //line of convexHull
        LinkedList<Line> k = new LinkedList<Line>();
        for( int i =0; i < p.size(); i+=2){
            k.add(new Line(p.get(i), p.get(i+1)));
        }
        return k;
    }
    public static void main(String[] args){
        if( args.length <=1){
            System.out.println("Falscher Parameteranzahl! \r\n" +
                                "Aufruf mit : java SimpleConvexHull numberOfPoint seed \r\n"+
                                "oder mit gerader Anzahl Koordinatien: java SimpleConvexHull p1x p1y p2x p2y ... \r\n" +
                                "Bsp: java SimpleConvexHull 100 1337");
        }
        if(args.length==3||args.length==4||args.length==5) {
			System.out.println("Falsche Parameteranzahl!\r\n" + 
					"Aufruf mit : java SimpleConvexHull numberOfPoints seed\r\n" + 
					"oder mit gerader Anzahl Koordinaten: java SimpleConvexHull p1x p1y p2x p2y ...\r\n" + 
					"Bsp: java SimpleConvexHull 100 1337");
        }
        if( args.length == 2){
            try{
                if( Integer.parseInt(args[0]) <=2 && Integer.parseInt(args[0]) % 1 == 0.0){
                    System.out.println("Anzahl der Punkte muss groesser als 2 sein. \r\n" +
                    "Aufruf mit : java SimpleConvexHull numberOfPoints seed\r\n" +
                    " oder mit gerader Anzahl koordinaten: java SimpleConvexHull p1x p1y p2x p2y ...\r\n"+
                    "Bsp: java SimpleConvexHull 100 1337");
                }
                else{
                    if( Integer.parseInt(args[0]) > 2){
                        try {
                            if( Integer.parseInt(args[1]) > 2 ){
                                PointsGenerator gen = new PointsGenerator(0.0,100.00, Integer.parseInt(args[1]));
                                Point[] arr = gen.generate(Integer.parseInt(args[0]));
                                LinkedList<Point> p = computeHull(arr);
                                LinkedList<Line> aussenkante = kante(p);
                                for( int i = 0; i < aussenkante.size(); i++){
                                    System.out.println("Neue Aussenkante gefunden: " + aussenkante.get(i).toString());
                                }
                            }
                        }
                        catch(Exception e){
                            System.out.println("Falscher Parameter! Als Seed sind nur Integer erlaubt.\r\n" + 
                            "Aufruf mit : java SimpleConvexHull numberOfPoints seed\r\n" + 
                            "oder mit gerader Anzahl Koordinaten: java Application p1x p1y p2x p2y ...\r\n" + 
                            "Bsp: java SimpleConvexHull 100 1337");
                        }

                    }
                }
            }
            catch(Exception e){
                System.out.println("Falscher Parameter! Nur Integer groesser 2 sind erlaubt.\r\n" + 
	    	 		"Aufruf mit : java SimpleConvexHull numberOfPoints seed\r\n" + 
	    	 		"oder mit gerader Anzahl Koordinaten: java SimpleConvexHull p1x p1y p2x p2y ...\r\n" + 
	    	 		"Bsp: java SimpleConvexHull 100 1337");
            }

        }
        if( args.length > 5){
            try{
                double [] doub =new double[args.length];
				int j=0;
				for(int i=0;i<args.length;i++){
				  doub[j]=Double.parseDouble(args[i]);
				  j++;									
				}
                Point[] p = new Point[doub.length/2];
                for( int i = 0; i < doub.length; i+=2){
                    p[i] = new Point(doub[i], doub[i+1]);
                }
                LinkedList<Point> point = computeHull(p);
                LinkedList<Line> k = kante(point);
                for( int t =0; t < k.size(); t++){
                    System.out.println("Neue Aussenkante:" + k.get(t).toString());
                }

            }
            catch(Exception e){
                System.out.println("Es war nicht moeglich, alle Punkte einzulesen.\r\n" + 
						"Aufruf mit : java SimpleConvexHull numberOfPoints seed\r\n" + 
						"oder mit gerader Anzahl Koordinaten: java SimpleConvexHull p1x p1y p2x p2y ...\r\n" + 
						"Bsp: java SimpleConvexHull 100 1337");
            }
        }
       
    }
}