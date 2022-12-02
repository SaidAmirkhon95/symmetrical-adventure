import java.util.Random;
import java.util.*;

public class ShortestCommonSuperstring {
	
	public static String generateRandomString(Random numberGenerator) {
		String alphabet = "AEIOU";
		StringBuilder builder = new StringBuilder();
		int length = 3 + numberGenerator.nextInt(4);
		while (length-- > 0) {
		int randomIdx = numberGenerator.nextInt(alphabet.length());
		builder.append(alphabet.charAt(randomIdx));
		}
		return builder.toString();
	}
	
	
	public static int stringOverlap(String A, String B) {		
		int m=A.length();
		int n=B.length();
		int max=0;
		int min=Math.min(m, n);
		for(int i=1;i<min;i++) {
			if(A.substring(m-i,m).equals(B.substring(0,i))) {
				max=i;
			}			
		}				
		return max;		
	}		
	public static String superstring(String str1, String str2) {
		int max=stringOverlap(str1,str2);
		String str3=new String();
		for(int i=max;i<str2.length();i++) {
			str3+=str2.charAt(i);
		}
		String over=str1+str3;
		return over;
	}
	
	public static void overlap(ArrayList<String> list) {
		
		int maxOverlap=0;
		while(list.size()>1) {
			
			
		}
			for(int d=0;d<list.size()-1;d++) {
				for(int i=d+1;i<list.size();i++) {
			if(stringOverlap(list.get(d),list.get(i))>stringOverlap(list.get(i),list.get(d))&&
					stringOverlap(list.get(d),list.get(i))>maxOverlap) {
				maxOverlap=stringOverlap(list.get(d),list.get(i));
			}
			else if(stringOverlap(list.get(d),list.get(i))<stringOverlap(list.get(i),list.get(d))&&
					stringOverlap(list.get(i),list.get(d))>maxOverlap){
				maxOverlap=stringOverlap(list.get(i),list.get(d));
			  }			
		     }				
			}
			for(int g=0;g<list.size()-1;g++) {
				for(int j=g+1;j<list.size();j++) {
				if(maxOverlap==stringOverlap(list.get(g),list.get(j))){					
					System.out.println("Ersetze "+list.get(g)+" und "+list.get(j)+" durch "+superstring(list.get(g),list.get(j)));
					list.add(superstring(list.get(g),list.get(j)));
					list.remove(g);
					list.remove(j);
					for(int n=0;n<list.size();n++) {
						System.out.print(list.get(n)+" ");
					}					
				}
				else if(maxOverlap==stringOverlap(list.get(j),list.get(g))) {					
					System.out.println("Ersetze "+list.get(j)+" und "+list.get(g)+" durch "+superstring(list.get(j),list.get(g)));
					list.add(superstring(list.get(j),list.get(g)));
					list.remove(j);
					list.remove(g);
					for(int n=0;n<list.size();n++) {
						System.out.print(list.get(n)+" ");
					}
				}
			  }				
			}			
	}
	
	
	public static void randomString(ArrayList<String> list) {
		int maxOverlap=0;					
		for(int d=0;d<list.size()-1;d++) {
			for(int i=d+1;i<list.size();i++) {
		if(stringOverlap(list.get(d),list.get(i))>stringOverlap(list.get(i),list.get(d))&&
				stringOverlap(list.get(d),list.get(i))>maxOverlap) {
			maxOverlap=stringOverlap(list.get(d),list.get(i));
		}
		else if(stringOverlap(list.get(d),list.get(i))<stringOverlap(list.get(i),list.get(d))&&
				stringOverlap(list.get(i),list.get(d))>maxOverlap){
			maxOverlap=stringOverlap(list.get(i),list.get(d));
		  }			
	     }				
		}
		for(int g=0;g<list.size()-1;g++) {
			for(int j=g+1;j<list.size();j++) {
			if(maxOverlap==stringOverlap(list.get(g),list.get(j))){								
				list.add(superstring(list.get(g),list.get(j)));
				list.remove(g);
				list.remove(j);					
			}
			else if(maxOverlap==stringOverlap(list.get(j),list.get(g))) {					
				list.add(superstring(list.get(j),list.get(g)));
				list.remove(j);
				list.remove(g);
			}
		  }				
		}
		System.out.println(list.get(0));		
	}
	
	public static void stringOut(String[]arr) {
		ArrayList<String> strList=new ArrayList<String>();
        for(int i=0;i<arr.length;i++) {
	    strList.add(arr[i].toUpperCase());
        }		
		for(int j=0;j<strList.size();j++) {
			System.out.print(strList.get(j)+" ");
		    }		        
		        System.out.println(" ");
		        overlap(strList);
		        System.out.println(" ");
		        System.out.println("Superstring "+strList.get(0)+" mit Laenge "+strList.get(0).length()+" gefunden.");			
	}
	
	
	
	
	public static void main(String[]args) {
		
		if(args.length<=0) {
			System.out.println("FEHLER: Es wurde kein Parameter übergeben.");
			System.out.println("Aufruf des Programms mit:\r\n" + 
					"- java ShortestCommonSuperstring n [seed]\r\n" + 
					"- java ShortestCommonSuperstring str1 str2 str3 [str4 ...]");			
		}
		
		if(args.length==2) {
			try {
				if(Integer.parseInt(args[0])>1&&Integer.parseInt(args[0])<=10) {
					try {						 
						if(Integer.parseInt(args[1])>2) {														
							String[] strArr=new String[Integer.parseInt(args[0])];
							Random rnd=new Random();
							rnd.setSeed(Integer.parseInt(args[1]));
							for(int i=0;i<strArr.length;i++) {
								strArr[i]=generateRandomString(rnd).toUpperCase();
							}
							ArrayList<String> list=new ArrayList<String>();							
							for(int i=0;i<strArr.length;i++) {
								list.add(strArr[i]);
							}														
							for(int j=0;j<list.size();j++) {
								System.out.print(list.get(j)+" ");
							}
							System.out.println(" ");
							overlap(list);
							System.out.println(" ");
							System.out.println("Superstring "+list.get(0)+" mit Laenge "+list.get(0).length()+" gefunden.");														
						}
						else {throw new Exception();}
					}
					catch(Exception e) {
						System.out.println("FEHLER: Der Seed Parameter konnte nicht gelesen werden.");
						System.out.println("Aufruf des Programms mit:\r\n" + 
								"- java ShortestCommonSuperstring n [seed]\r\n" + 
								"- java ShortestCommonSuperstring str1 str2 str3 [str4 ...]");
					}
				}
				else if(Integer.parseInt(args[0])>10) {
					try {
						if(Integer.parseInt(args[1])>2) {
							String[] strArr=new String[Integer.parseInt(args[0])];
					Random rnd=new Random();
					rnd.setSeed(Integer.parseInt(args[1]));
					for(int i=0;i<strArr.length;i++) {
						strArr[i]=generateRandomString(rnd).toUpperCase();
					}
					ArrayList<String> list=new ArrayList<String>();							
					for(int i=0;i<strArr.length;i++) {
						list.add(strArr[i]);
					}														
					randomString(list);
					System.out.println("Superstring "+list.get(0)+" mit Laenge "+list.get(0).length()+" gefunden.");								
						}
						else {throw new Exception();}													
					}
					catch(Exception e) {
						System.out.println("FEHLER: Der Seed Parameter konnte nicht gelesen werden.");
						System.out.println("Aufruf des Programms mit:\r\n" + 
								"- java ShortestCommonSuperstring n [seed]\r\n" + 
								"- java ShortestCommonSuperstring str1 str2 str3 [str4 ...]");
					  }
				 }								
			}
			catch(Exception e) {
				System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl >1 sein.");
				System.out.println("Aufruf des Programms mit:\r\n" + 
						"- java ShortestCommonSuperstring n [seed]\r\n" + 
						"- java ShortestCommonSuperstring str1 str2 str3 [str4 ...]");
			}
		}
		else if(args.length>2) {
			try {		
				String[]arr=new String[args.length];
				for(int i=0;i<args.length;i++) {				
					 if(args[i].length() > 2){
	                        arr[i] = args[i];
	                    }
				else {throw new Exception ();}				
				}
				stringOut(args);
			}
			catch(Exception e) {
				System.out.println("FEHLER: Uebergebene Strings muessen mindestens Laenge 2 haben.");
					System.out.println("Aufruf des Programms mit:\r\n" + 
							"- java ShortestCommonSuperstring n [seed]\r\n" + 
							"- java ShortestCommonSuperstring str1 str2 str3 [str4 ...]");					
			}										        									
		}
		else if(args.length==1){ 
		  try {
			if(Integer.parseInt(args[0])>1&&Integer.parseInt(args[0])<10) {
			String[] strArr=new String[Integer.parseInt(args[0])];
			Random rnd=new Random();
			rnd.setSeed(6521);
			for(int i=0;i<strArr.length;i++) {
				strArr[i]=generateRandomString(rnd).toUpperCase();
			}
			ArrayList<String> list=new ArrayList<String>();							
			for(int i=0;i<strArr.length;i++) {
				list.add(strArr[i]);
			}														
			for(int j=0;j<list.size();j++) {
				System.out.print(list.get(j)+" ");
			}
			System.out.println(" ");
			overlap(list);
			System.out.println(" ");
			System.out.println("Superstring "+list.get(0)+" mit Laenge "+list.get(0).length()+" gefunden.");					
			}
			else if(Integer.parseInt(args[0])>10) {
				String[] strArr=new String[Integer.parseInt(args[0])];
				Random rnd=new Random();
				rnd.setSeed(6521);
				for(int i=0;i<strArr.length;i++) {
					strArr[i]=generateRandomString(rnd).toUpperCase();
				}
				ArrayList<String> list=new ArrayList<String>();							
				for(int i=0;i<strArr.length;i++) {
					list.add(strArr[i]);
				}														
				randomString(list);
				System.out.println("Superstring "+list.get(0)+" mit Laenge "+list.get(0).length()+" gefunden.");
				}
			else {throw new Exception ();}
			}
			catch(Exception e) {
				System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl >1 sein.");
				System.out.println("Aufruf des Programms mit:\r\n" + 
						"- java ShortestCommonSuperstring n [seed]\r\n" + 
						"- java ShortestCommonSuperstring str1 str2 str3 [str4 ...]");
			}												
		}
	}	
}
