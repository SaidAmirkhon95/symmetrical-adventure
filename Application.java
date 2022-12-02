
public class Application {

	public static void main(String[]args) {
		

		if(args.length<=1/*args.length<=0*/) {
			System.out.println("Falsche Parameteranzahl!\r\n" + 
					"Aufruf mit : java Application numberOfPoints seed\r\n" + 
					"oder mit gerader Anzahl Koordinaten: java Application p1x p1y p2x p2y ...\r\n" + 
					"Bsp: java Application 100 1337");
		}
		 
		else {
			try{
				if(args.length==2&&Integer.parseInt(args[0])<=2&&Integer.parseInt(args[0])%1==0.0) {
			throw new Exception();
		}
			}
			catch(Exception e) {
				System.out.println("Anzahl der Punkte muss groesser als 2 sein.\r\n" + 
					"Aufruf mit : java Application numberOfPoints seed\r\n" + 
					"oder mit gerader Anzahl Koordinaten: java Application p1x p1y p2x p2y ...\r\n" + 
					"Bsp: java Application 100 1337");
			}
			
		}
		
		if(args.length == 3) {
			System.out.println("Falsche Parameteranzahl!\r\n" + 
					"Aufruf mit : java Application numberOfPoints seed\r\n" + 
					"oder mit gerader Anzahl Koordinaten: java Application p1x p1y p2x p2y ...\r\n" + 
					"Bsp: java Application 100 1337");
			
		}
		
		if(args.length==2) {
	     try { 
	      if(Integer.parseInt(args[0])>2) {
		   try {
			if(Integer.parseInt(args[1])>2) {
				PointsGenerator gen=new PointsGenerator(0.0,100.0,Integer.parseInt(args[1]));
			    Point[]arr=gen.generate(Integer.parseInt(args[0]));					
			    Line lin=new Line(arr[0],arr[1]);			
			    System.out.println("Vergleiche Punkte mit der Geraden "+lin);
			
			    for(int i=2;i<arr.length;i++) {
				System.out.print("Punkte"+arr[i].toString());
				if(isBetween(arr[0],arr[1],arr[i])) {
					System.out.println("liegt zwischen"+arr[0].toString()+"und"+arr[1].toString());
				}else if(Line.side(arr[i])==0) { 
					System.out.println("liegt auf der Linie.");
				}else if(Line.side(arr[i])<0) {
					System.out.println("liegt rechts der Linie.");
				}
				else {
					System.out.println("liegt links der Linie.");
				}
			  }
			}else {
				throw new Exception();
			}
						
		    }catch(Exception e) {
				System.out.println("Falscher Parameter! Als Seed sind nur Integer erlaubt.\r\n" + 
						"Aufruf mit : java Application numberOfPoints seed\r\n" + 
						"oder mit gerader Anzahl Koordinaten: java Application p1x p1y p2x p2y ...\r\n" + 
						"Bsp: java Application 100 1337");
			}
		  }
	    	 else if (Integer.parseInt(args[0])>2&&Integer.parseInt(args[0])%1!=0.0){
	    		 throw new Exception();
	    	 } 
	     }
	     catch(Exception e) {
	    	 System.out.println("Falscher Parameter! Nur Integer groesser 2 sind erlaubt.\r\n" + 
	    	 		"Aufruf mit : java Application numberOfPoints seed\r\n" + 
	    	 		"oder mit gerader Anzahl Koordinaten: java Application p1x p1y p2x p2y ...\r\n" + 
	    	 		"Bsp: java Application 100 1337");
	        }		  		  								
		}
				
		
		
		if(args.length>=4) {
			//try {
                
				double []dblArr=new double[args.length];
				int j=0;
				for(int i=0;i<args.length;i++){
				  dblArr[j]=Double.parseDouble(args[i]);			//Double.parseDouble(String s)
				  j++;									
				}
				
				Point[]poArr=new Point[dblArr.length/2];
			    int n=0;
			    for(int k=0; k<dblArr.length;k+=2) {
				 poArr[n]=new Point(dblArr[k],dblArr[k+1]);
				 n++;				
				}
						
				Line lin=new Line(poArr[0],poArr[1]);
			
				System.out.println("Vergleiche Punkte mit der Geraden "+lin);
			
				for(int m=2;m<poArr.length;m++) {
					System.out.print("Punkte"+poArr[m].toString());
					if(isBetween(poArr[0],poArr[1],poArr[m])) {
					System.out.println("liegt zwischen"+poArr[0].toString()+"und"+poArr[1].toString());
					}
					else if(Line.side(poArr[m])==0) { 
					System.out.println("liegt auf der Linie.");
					}
					else if(Line.side(poArr[m])<0) {
					System.out.println("liegt rechts der Linie.");
					}
					else {
					System.out.println("liegt links der Linie.");
					}
				}												
				
			//}
			// catch(Exception e) {
			// 	System.out.println("Es war nicht moeglich, alle Punkte einzulesen.\r\n" + 
			// 			"Aufruf mit : java Application numberOfPoints seed\r\n" + 
			// 			"oder mit gerader Anzahl Koordinaten: java Application p1x p1y p2x p2y ...\r\n" + 
			// 			"Bsp: java Application 100 1337");
			// }
						
            
			
		}		 						
		
	}
	
	public static boolean isBetween(Point i, Point j, Point k) {
		
		double ia=i.get(0);
		double ib=i.get(1);
		double ja=j.get(0);
		double jb=j.get(1);
		double ka=k.get(0);
		double kb=k.get(1);		
		double ika=Math.abs(ia-ka);
		double ikb=Math.abs(ib-kb);
		double jka=Math.abs(ja-ka);
		double jkb=Math.abs(jb-kb);
		double ijka=Math.abs(ika+jka);
		double ijkb=Math.abs(ikb+jkb);
		double ija=Math.abs(ja-ia);
		double ijb=Math.abs(jb-ib);
		Point kk=new Point(ijka,ijkb);
		Point kkk=new Point (ija,ijb);
		return 	kk==kkk;					
	}
}