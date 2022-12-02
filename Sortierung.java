import java.util.Random;

public class Sortierung {
	
	public static int count=0;
	
	public static void insertionSort(int[]array) {
    	
    	
    	for(int j=1;j<array.length;j++) {
    		int key=array[j];
    		int i=j-1; 
    		int l=0;
    		if(array[l]<=key) {count++;l++;}
    	    	while(i>=0&&array[i]>key) {   
    			count++;
    			array[i+1]=array[i];
    			i=i-1;        			        			          			        			
    		}  
    	    	array[i+1]=key;      	  
    	}        	
    }
	
	public static boolean isSorted(int[]array) {
    	
    	for(int i=1;i<array.length;i++) {
    		if(array[i]<array[i-1]) {
    			return false;
    		}
    	}
    	return true;
    }
	
	public static void mergeSort(int[] array) {
		int[] tmpArray = new int[array.length];
		mergeSort(array, tmpArray, 0, array.length-1);
		assert isSorted(array);			    
	}
	
	public static void mergeSort(int[]array,int[]tmpArray,int left,int right) {
		
		if(left<right) {
		int middle=(left+right)/2;					
		mergeSort(array,tmpArray,left,middle);
	    mergeSort(array,tmpArray,middle+1,right);
	    merge(array,left,middle,right);	
		}								    		
	}
	
   
	public static void merge(int[] array, int left, int middle, int right) {
	    int leftArray[] = new int[middle - left + 1];
	    int rightArray[] = new int[right - middle];

	    for (int i = 0; i < leftArray.length; i++)
	        leftArray[i] = array[left + i];
	    for (int i = 0; i < rightArray.length; i++)
	        rightArray[i] = array[middle + i + 1];
	    int leftIndex = 0;
	    int rightIndex = 0;
	    for (int i = left; i < right + 1; i++) {
	        if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
	        	if (leftArray[leftIndex] < rightArray[rightIndex]) {
	        		count++;
	        		array[i] = leftArray[leftIndex];
	               leftIndex++;
	            } else {
	                array[i] = rightArray[rightIndex];
	                rightIndex++;
	            }
	        } else if (leftIndex < leftArray.length) {
	            count++;
	            array[i] = leftArray[leftIndex];
	            leftIndex++;
	        } else if (rightIndex < rightArray.length) {
	            array[i] = rightArray[rightIndex];
	            rightIndex++;
	        }
	    }
	}
   
   
   public static void main(String[]args) {
	   
	   
	   if(args.length<=0||args.length>3) {
		   System.out.println("FEHLER: Es muessen zwischen 1 und 3 Parameter angegeben werden. \r\n" + 
		   		        				"Aufruf mit: java Sortierung n [insert|merge [auf|ab|rand]]\r\n" + 
		   		        				"Beispiel: java Sortierung 10000 merge rand");
	   }
	   else {
		   try {
			   if(Integer.parseInt(args[0])<0) {
      			 throw new Exception();
      		   } 
		   }
		   catch(Exception e) {
			   System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl sein.");
           	   System.out.println("Aufruf mit: java Sortierung n [insert|merge [auf|ab|rand]]");
           	   System.out.println("Beispiel: java Sortierung 10000 merge rand");
		   }
	   }
	   
	   
         if(args.length==1&&Integer.parseInt(args[0])>=0&&Integer.parseInt(args[0])<=100) {
		   int[]newArr=new int[Integer.parseInt(args[0])];
		    Random rnd=new Random();
			rnd.setSeed(951);
			 for(int i=0;i<newArr.length;i++) {			
			   int j=rnd.nextInt();
			   newArr[i]=j;
			   System.out.print(newArr[i]+ " ");
			}
			System.out.println("");
			mergeSort(newArr);
			  if(Integer.parseInt(args[0])<=100) {
				for(int i=0;i<newArr.length;i++) {
    		    System.out.print(newArr[i]+ " ");         				
			   }          			   
			}  
			    System.out.println(" ");
			    
			    assert isSorted(newArr);			    
			    if(isSorted(newArr)) {
			      System.out.println("Feld ist sortiert!");
			    }
			    else {
			      System.out.println("FEHLER: Feld ist NICHT sortiert!");
			    }
			    System.out.println("Das Sortieren des Arrays hat " +count+ " Vergleiche benoetigt.");	     
	   }	   
	   
	   else if(args.length==1&&Integer.parseInt(args[0])>100) {
	    	 int[]newArr=new int[Integer.parseInt(args[0])];
	    	 Random rnd=new Random();
	    	 rnd.setSeed(951);	    	 
	    	   for(int i=0;i<newArr.length;i++) {
	    		  int j=rnd.nextInt();
	    		  newArr[i]=j;
	    	 }
	    	    mergeSort(newArr);	    	          			             			    
  			    assert isSorted(newArr); 			    
  			      if(isSorted(newArr)) {
  			        System.out.println("Feld ist sortiert!");
  			    }
  			    else {
  			    	System.out.println("FEHLER: Feld ist NICHT sortiert!");
  			    }
  			    System.out.println("Das Sortieren des Arrays hat " +count+ " Vergleiche benoetigt.");	
	     }
         

         
         
	   else if(args.length==3&&args[1].equals("merge")||args.length==3&&args[1].equals("insert")){   
         if(args.length==3&&Integer.parseInt(args[0])>=0&&Integer.parseInt(args[0])<=100&&args[1].equals("merge")) {
          if(args[1].equals("merge")) {		    		
		   try {
			   if(args[2].equals("auf")) {
				   int[]newArr=new int[Integer.parseInt(args[0])];
				   int j=1;
				   for(int i=0;i<newArr.length;i++) {
					   newArr[i]=j;
					   j++;
					   System.out.print(newArr[i]+" ");
				   }
				   System.out.println("");
				   mergeSort(newArr);				   
				   assert isSorted(newArr);
				   for(int i=0;i<newArr.length;i++) {
					System.out.print(newArr[i]+" ");
		           }
				   System.out.println("");
				   if(isSorted(newArr)) {
					   System.out.println("Feld ist sortiert!");					   
				   }
				   else {
					   System.out.println("FEHLER: Feld ist NICHT sortiert!");
				   }
				   System.out.println("Das Sortieren des Arrays hat " +count+ " Vergleiche benoetigt.");				   								   
			   }
			   
			   else if(args[2].equals("ab")) {
				   int[]newArr=new int[Integer.parseInt(args[0])];
				   int j=newArr.length;
				   for(int i=0;i<newArr.length;i++) {
					   newArr[i]=j;
					   j--;
					   System.out.print(newArr[i]+" ");
				   }
				   System.out.println("");
				   mergeSort(newArr);				   
				   assert isSorted(newArr);
				   for(int i=0;i<newArr.length;i++) {
					System.out.print(newArr[i]+" ");
		           }
				   System.out.println("");
				   if(isSorted(newArr)) {
					   System.out.println("Feld ist sortiert!");					   
				   }
				   else {
					   System.out.println("FEHLER: Feld ist NICHT sortiert!");
				   }
				   System.out.println("Das Sortieren des Arrays hat " +count+ " Vergleiche benoetigt.");				   								   
			   }
			   
			   else if(args[2].equals("rand")) {
				   int[]newArr=new int[Integer.parseInt(args[0])];
				   Random rnd=new Random();
				   rnd.setSeed(951);
				   for(int i=0;i<newArr.length;i++) {
					   int j=rnd.nextInt();
					   newArr[i]=j;
					   System.out.print(newArr[i]+" ");
				   }
				   mergeSort(newArr);				   
				   assert isSorted(newArr);
				   for(int i=0;i<newArr.length;i++) {
					   System.out.print(newArr[i]+" ");
				   }
				   System.out.println("");
				   if(isSorted(newArr)) {
					   System.out.println("Feld ist sortiert!");					   
				   }
				   else {
					   System.out.println("FEHLER: Feld ist NICHT sortiert!");
				   }
				   System.out.println("Das Sortieren des Arrays hat " +count+ " Vergleiche benoetigt.");				   								   
			   }
			   else if(!args[2].equals("auf")||!args[2].equals("ab")||!args[2].equals("rand"))
			   {throw new Exception();}
			   			   			 			   
		   }catch(Exception e) {
			   System.out.println("FEHLER: Unbekanntes Vorsortierverfahren: " + args[2]);
			   System.out.println("Aufruf mit: java Sortierung n [insert|merge [auf|ab|rand]]");  
        	   System.out.println("Beispiel: java Sortierung 10000 merge rand");
		   }		   		   
	   }
         }   
	   else if((args.length==3&&Integer.parseInt(args[0])>=0&&Integer.parseInt(args[0])<=100&&args[1].equals("insert"))) {			   
           try { 
        	  if(args[2].equals("auf")) {   			
   			  int []newarr=new int[Integer.parseInt(args[0])];  			
   			  int j=1;
   			  for(int i=0;i<newarr.length;i++) {   			
   			  newarr[i]=j;
   			  j++;
   			  System.out.print(newarr[i]+ " ");
   			  }
   			  System.out.println("");
   			  insertionSort(newarr);
   			  for(int i=0;i<newarr.length;i++) {
   				System.out.print(newarr[i]+" ");
   			}
   			    System.out.println("");  			    
   			    assert isSorted(newarr);  			    
   			    if(isSorted(newarr)) {
   			       System.out.println("Feld ist sortiert!");
   			    }
   			    else {
   			    	System.out.println("FEHLER: Feld ist NICHT sortiert!");
   			    }
   			    System.out.println("Das Sortieren des Arrays hat " +count+ " Vergleiche benoetigt.");
   			  }
        	  
        	  else if(args[2].equals("ab")) {     	    	 
      	    	int []newarr=new int[Integer.parseInt(args[0])];       			
      	    	int j=newarr.length;
      	    	for(int i=0;i<newarr.length;i++) {       			
       			newarr[i]=j;
       			j--;
       			System.out.print(newarr[i]+" ");
       			}
       			System.out.println("");
       			insertionSort(newarr);
       			for(int i=0;i<newarr.length;i++) {
       				System.out.print(newarr[i]+" ");
       			}
       			    System.out.println("");      			    
       			    assert isSorted(newarr);      			    
       			    if(isSorted(newarr)) {
       			       System.out.println("Feld ist sortiert!");
       			    }
       			    else {
       			    	System.out.println("FEHLER: Feld ist NICHT sortiert!");
       			    }
       			    System.out.println("Das Sortieren des Arrays hat " +count+ " Vergleiche benoetigt.");
      	     }       	  
        	  else if(args[2].equals("rand")) {     	    	 
      	    	int []newarr=new int[Integer.parseInt(args[0])];
        			Random rnd=new Random();
        			rnd.setSeed(951);          			      	    	        			
        			for(int i=0;i<newarr.length;i++) {
        			int j=rnd.nextInt();
        			newarr[i]=j;
        			System.out.print(newarr[i]+" ");
        			}
      	    	System.out.println("");
        			insertionSort(newarr);        			
        			if(Integer.parseInt(args[0])<=100) {
        				for(int i=0;i<newarr.length;i++) {
            		    System.out.print(newarr[i]+" ");         				
        			}    
        				}     			   
        			    System.out.println("");       			    
        			    assert isSorted(newarr);       			    
        			    if(isSorted(newarr)) {
        			       System.out.println("Feld ist sortiert!");
        			    }
        			    else {
        			    	System.out.println("FEHLER: Feld ist NICHT sortiert!");
        			    }
        			    System.out.println("Das Sortieren des Arrays hat " +count+ " Vergleiche benoetigt.");
        			}
        	  else if(!args[2].equals("auf")||!args[2].equals("ab")||!args[2].equals("rand")) {throw new Exception();}
           }
           catch(Exception e) {
        	   System.out.println("FEHLER: Unbekanntes Vorsortierverfahren: " + args[2]);
        	   System.out.println("Aufruf mit: java Sortierung n [insert|merge [auf|ab|rand]]"); 
        	   System.out.println("Beispiel: java Sortierung 10000 merge rand");        	   
           }
	   }
	   else if(args.length==3&&Integer.parseInt(args[0])>100&&args[1].equals("merge")) {
		   try {
			   if(args[2].equals("auf")) {
				   int[]newArr=new int[Integer.parseInt(args[0])];
				   int j=1;
				   for(int i=0;i<newArr.length;i++) {
					   newArr[i]=j;
					   j++;
				   }
				   mergeSort(newArr);				   
				   assert isSorted(newArr);				 
				   System.out.println("");
				   if(isSorted(newArr)) {
					   System.out.println("Feld ist sortiert!");					   
				   }
				   else {
					   System.out.println("FEHLER: Feld ist NICHT sortiert!");
				   }
				   System.out.println("Das Sortieren des Arrays hat " +count+ " Vergleiche benoetigt.");
			   }
			   else if(args[2].equals("ab")) {
				     int []newarr=new int[Integer.parseInt(args[0])];		             
		             int j=newarr.length;
		             for(int i=0;i<newarr.length;i++) { 			             
		             newarr[i]=j;
		             j--; 
		             }		             
		             mergeSort(newarr);        
		             assert isSorted(newarr);		            			    
		             if(isSorted(newarr)) {
		             System.out.println("Feld ist sortiert!");
		              }
		             else {
		    	     System.out.println("FEHLER: Feld ist NICHT sortiert!");
		             }
		             System.out.println("Das Sortieren des Arrays hat " +count+ "  Vergleiche benoetigt.");
			   }
			   else if(args[2].equals("rand")) {
				   int[]newarr=new int[Integer.parseInt(args[0])];
      	    	   Random rnd=new Random();
      	    	   rnd.setSeed(951);     	    	 
      	    	    for(int i=0;i<newarr.length;i++) {
      	    		 int j=rnd.nextInt();
      	    		 newarr[i]=j;                       
      	    	  }
      	    	        mergeSort(newarr);     	    	          			              			    
         			    assert isSorted(newarr);         			    
         			    if(isSorted(newarr)) {
         			       System.out.println("Feld ist sortiert!");
         			    }
         			    else {
         			    	System.out.println("FEHLER: Feld ist NICHT sortiert!");
         			    }
         			    System.out.println("Das Sortieren des Arrays hat " +count+ " Vergleiche benoetigt.");				   
			   }
			   else if(!args[2].equals("auf")||!args[2].equals("ab")||!args[2].equals("rand")) {throw new Exception();}			   
		   }
		   catch(Exception e) {
			   System.out.println("FEHLER: Unbekanntes Vorsortierverfahren: " + args[2]);
			   System.out.println("Aufruf mit: java Sortierung n [insert|merge [auf|ab|rand]]");  
        	   System.out.println("Beispiel: java Sortierung 10000 merge rand");
		   }		   
	   }	   	   
	   else if(args.length==3&&Integer.parseInt(args[0])>100&&args[1].equals("insert")) {
	    	try {
        	    if(args[2].equals("auf")) {     			
     			int []newarr=new int[Integer.parseInt(args[0])];     			
     			int j=1;
     			for(int i=0;i<newarr.length;i++) {         			
     			newarr[i]=j;
     			j++;         				          			  
     			}
     			insertionSort(newarr);         			     			
     			assert isSorted(newarr);     			            			    
     			    if(isSorted(newarr)) {
     			       System.out.println("Feld ist sortiert!");
     			    }
     			    else {
     			    	System.out.println("FEHLER: Feld ist NICHT sortiert!");
     			    }
     			    System.out.println("Das Sortieren des Arrays hat " +count+ " Vergleiche benoetigt.");
     			  }       
    	     else if(args[2].equals("ab")) {			
			             int []newarr=new int[Integer.parseInt(args[0])];			             
			             int j=newarr.length;
			             for(int i=0;i<newarr.length;i++) { 			             
			             newarr[i]=j;
			             j--; 
			             }			             
			             insertionSort(newarr);         
			              assert isSorted(newarr);			            			    
			             if(isSorted(newarr)) {
			             System.out.println("Feld ist sortiert!");
			              }
			             else {
			    	     System.out.println("FEHLER: Feld ist NICHT sortiert!");
			             }
			             System.out.println("Das Sortieren des Arrays hat " +count+ "  Vergleiche benoetigt.");
			        }   	      
    	     else if(args[2].equals("rand")) {
    	    	 int[]newarr=new int[Integer.parseInt(args[0])];
    	    	 Random rnd=new Random();
    	    	 rnd.setSeed(951);   	    	 
    	    	 for(int i=0;i<newarr.length;i++) {
    	    		 int j=rnd.nextInt();
    	    		 newarr[i]=j;                       
    	    	 }
    	    	 insertionSort(newarr);    	    	          			              			    
       			    assert isSorted(newarr);       			    
       			    if(isSorted(newarr)) {
       			       System.out.println("Feld ist sortiert!");
       			    }
       			    else {
       			    	System.out.println("FEHLER: Feld ist NICHT sortiert!");
       			    }
       			    System.out.println("Das Sortieren des Arrays hat " +count+ " Vergleiche benoetigt.");
    	     }
        	   
    	         else if(!args[2].equals("auf")||!args[2].equals("ab")||!args[2].equals("rand")){
    		     throw new Exception();  
    	      } 
           }
           catch(Exception e) {
        	   System.out.println("FEHLER: Unbekanntes Vorsortierverfahren: " + args[2]);
        	   System.out.println("Aufruf mit: java Sortierung n [insert|merge [auf|ab|rand]]"); 
        	   System.out.println("Beispiel: java Sortierung 10000 merge rand");
         }
	   }
     }
	   else  {
		   if(args.length==3&&!args[1].equals("merge")||
			   args.length==3&&!args[1].equals("insert")){
      	 System.out.println("FEHLER: Unbekanntes Sortierverfahren: " + args[1]);
  	     System.out.println("Aufruf mit: java Sortierung n [insert|merge [auf|ab|rand]]"); 
  	     System.out.println("Beispiel: java Sortierung 10000 merge rand");       	 
       }
     }
   }		
 }
