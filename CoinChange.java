
public class CoinChange {

	public static void main(String[]args) {
		
		if(args.length<=1||args.length>2) {
			System.out.println("FEHLER: Falsche Parameteranzahl!\r\n" + 
					"Aufruf mit : java CoinChange Euro|Mira n\r\n" + 
					"Bsp: java CoinChange Euro 100");
		}
		else {			
				if(args.length==2) {					
					try {
			            if(args[0]=="Euro") {			            
				            try {
				                if(Integer.parseInt(args[1])>0) {
				                	int [] w= {200,100,50,20,10,5,2,1};
				                    int r=0;
				                	int [] tripel=change(Integer.parseInt(args[1]),w);
				                	
				                	System.out.println("Auszugebendes Wechselgeld: "+Integer.parseInt(args[1])+" Eurocent");				                	
				                	if(tripel[0]!=0) {
				                		r=Integer.parseInt(args[1])-200*tripel[0];
				                		System.out.println("("+"200, "+tripel[0]+", "+r+")");
				                	}
				                	else if(tripel[1]!=0) {
				                		r=Integer.parseInt(args[1])-100*tripel[1];
				                		System.out.println("("+"100, "+tripel[1]+", "+r+")");
				                	}
				                	else if(tripel[2]!=0) {
				                		r=Integer.parseInt(args[1])-50*tripel[2];
				                		System.out.println("("+"50, "+tripel[2]+", "+r+")");
				                	}
				                	else if(tripel[3]!=0) {
				                		r=Integer.parseInt(args[1])-20*tripel[3];
				                		System.out.println("("+"20, "+tripel[3]+", "+r+")");
				                	}
				                	else if(tripel[4]!=0) {
				                		r=Integer.parseInt(args[1])-10*tripel[4];
				                		System.out.println("("+"10, "+tripel[4]+", "+r+")");
				                	}
				                	else if(tripel[5]!=0) {
				                		r=Integer.parseInt(args[1])-5*tripel[5];
				                		System.out.println("("+"5, "+tripel[5]+", "+r+")");
				                	}
				                	else if(tripel[6]!=0) {
				                		r=Integer.parseInt(args[1])-2*tripel[6];
				                		System.out.println("("+"2, "+tripel[6]+", "+r+")");
				                	}
				                	else if(tripel[7]!=0) {
				                		r=Integer.parseInt(args[1])-1*tripel[7];
				                		System.out.println("("+"1, "+tripel[7]+", "+r+")");
				                	}
				                	System.out.println("Ausgegebenes Wechselgeld: "+Integer.parseInt(args[1])+" Eurocent");
				                				                					                	
			                    }
				                else if(Integer.parseInt(args[1])<0&&Integer.parseInt(args[1])%1==0.0) {
				                	System.out.println("FEHLER: Wechselgeld darf nicht negativ sein!\r\n" + 
				                			"Aufruf mit : java CoinChange Euro|Mira n\r\n" + 
				                			"Bsp: java CoinChange Euro 100");
				                }			
			                 }
				                catch(Exception e) {
					                 System.out.println("FEHLER: Falscher Parametertyp fuer das Wechselgeld!\r\n" + 
					                 		"Aufruf mit : java CoinChange Euro|Mira n\r\n" + 
					                 		"Bsp: java CoinChange Euro 100");
				                }						
		                    }
			                else if(args[0]=="Mira") {			            
				              try {
				                if(Integer.parseInt(args[1])>0) {
				                	int [] w= {200,100,50,20,10,9,7,5,2,1};
				                    int r=0;
				                	int [] tripel=change(Integer.parseInt(args[1]),w);
				                	
				                	System.out.println("Auszugebendes Wechselgeld: "+Integer.parseInt(args[1])+" Eurocent");				                	
				                	if(tripel[0]!=0) {
				                		r=Integer.parseInt(args[1])-200*tripel[0];
				                		System.out.println("("+"200, "+tripel[0]+", "+r+")");
				                	}
				                	else if(tripel[1]!=0) {
				                		r=Integer.parseInt(args[1])-100*tripel[1];
				                		System.out.println("("+"100, "+tripel[1]+", "+r+")");
				                	}
				                	else if(tripel[2]!=0) {
				                		r=Integer.parseInt(args[1])-50*tripel[2];
				                		System.out.println("("+"50, "+tripel[2]+", "+r+")");
				                	}
				                	else if(tripel[3]!=0) {
				                		r=Integer.parseInt(args[1])-20*tripel[3];
				                		System.out.println("("+"20, "+tripel[3]+", "+r+")");
				                	}
				                	else if(tripel[4]!=0) {
				                		r=Integer.parseInt(args[1])-10*tripel[4];
				                		System.out.println("("+"10, "+tripel[4]+", "+r+")");
				                	}
				                	else if(tripel[5]!=0) {
				                		r=Integer.parseInt(args[1])-9*tripel[5];
				                		System.out.println("("+"9, "+tripel[5]+", "+r+")");
				                	}
				                	else if(tripel[6]!=0) {
				                		r=Integer.parseInt(args[1])-7*tripel[6];
				                		System.out.println("("+"7, "+tripel[6]+", "+r+")");
				                	}
				                	else if(tripel[7]!=0) {
				                		r=Integer.parseInt(args[1])-5*tripel[7];
				                		System.out.println("("+"5, "+tripel[7]+", "+r+")");
				                	}
				                	else if(tripel[8]!=0) {
				                		r=Integer.parseInt(args[1])-2*tripel[8];
				                		System.out.println("("+"2, "+tripel[8]+", "+r+")");
				                	}
				                	else if(tripel[9]!=0) {
				                		r=Integer.parseInt(args[1])-1*tripel[9];
				                		System.out.println("("+"1, "+tripel[9]+", "+r+")");
				                	}
				                	System.out.println("Ausgegebenes Wechselgeld: "+Integer.parseInt(args[1])+" Eurocent");					                	
			                    }
				                else if(Integer.parseInt(args[1])<0&&Integer.parseInt(args[1])%1==0.0) {
				                	System.out.println("FEHLER: Wechselgeld darf nicht negativ sein!\r\n" + 
				                			"Aufruf mit : java CoinChange Euro|Mira n\r\n" + 
				                			"Bsp: java CoinChange Euro 100");
				                }			
			                 }
				                catch(Exception e) {
					                 System.out.println("FEHLER: Falscher Parametertyp fuer das Wechselgeld!\r\n" + 
					                 		"Aufruf mit : java CoinChange Euro|Mira n\r\n" + 
					                 		"Bsp: java CoinChange Euro 100");
				                }			            	
			                }
		                }
		                catch(Exception e) {	
		                	System.out.println("FEHLER: Unbekannte Waehrung+ "+args[0]+"!");
		                	System.out.println("Aufruf mit : java CoinChange Euro|Mira n\r\n" + 
		                			"Bsp: java CoinChange Euro 100");
				     }
			    }
		   }																					
	  }

	
	
	
	public static int[] change(int b, int []w) {
		int[]output=new int[w.length];
		
		if(w.length==8) {			
			int [] arr= {0,0,0,0,0,0,0,0};
		    if(b>=200) {
		    	arr[0]=b/200;
		    	b=b%200;
		    }
		    if(b<200&&b>=100) {
		    	arr[1]=b/100;
		    	b=b%100;
		    }
		    if(b<100&&b>=50) {
		    	arr[2]=b/50;
		    	b=b%50;
		    }
		    if(b<50&&b>=20) {
		    	arr[3]=b/20;
		    	b=b%20;
		    }
		    if(b<20&&b>=10) {
		    	arr[4]=b/10;
		    	b=b%10;
		    }
		    if(b<10&&b>=5) {
		    	arr[5]=b/5;
		    	b=b%5;
		    }
		    if(b<5&&b>=2) {
		    	arr[6]=b/2;
		    	b=b%2;
		    }
		    if(b<2&&b==1) {
		    	arr[7]=b/1;		    	
		    }
			output=arr;			
		}
		else if(w.length==10) {
			int [] arr= {0,0,0,0,0,0,0,0,0,0};
		    if(b>=200) {
		    	arr[0]=b/200;
		    	b=b%200;
		    }
		    if(b<200&&b>=100) {
		    	arr[1]=b/100;
		    	b=b%100;
		    }
		    if(b<100&&b>=50) {
		    	arr[2]=b/50;
		    	b=b%50;
		    }
		    if(b<50&&b>=20) {
		    	arr[3]=b/20;
		    	b=b%20;
		    }
		    if(b<20&&b>=10) {
		    	arr[4]=b/10;
		    	b=b%10;
		    }
		    if(b<10&&b==9) {
		    	arr[5]=b/9;
		    	b=b%9;
		    }
		    if(b<9&&b>=7) {
		    	arr[6]=b/7;
		    	b=b%7;
		    }
		    if(b<7&&b>=5) {
		    	arr[7]=b/5;
		    	b=b%5;
		    }
		    if(b<5&&b>=2) {
		    	arr[8]=b/2;
		    	b=b%2;
		    }
		    if(b<2&&b==1) {
		    	arr[9]=b/1;		    	
		    }
			output=arr;	
		}
		
		
		return output;
	}
}
