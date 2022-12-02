

public class Search {
    
	public static long laufzeit(long n){ 
        return (3*(n*n) + 7*n -10)/2;
    }
    public static long expSuche(long x){        //expotionelle Suche
        long m = 1;
        while(  laufzeit(m) <= x){
            m = m*2;                            //m wird verdoppelt bis T(m) > x
        }
        return m;
    }
  
    public static void ternareSuche(long x){         
        long l = expSuche(x)/2; // l=m/2
        long r = expSuche(x);    // r = m
        l = ternareSuche(l,r,x);
        System.out.println("Ergebnis: " + "T(" + l+ ") = " + laufzeit(l));
    }
    public static long ternareSuche(long l, long r, long k){
       
        System.out.println("links: " + "T(" + l + ") = " + laufzeit(l) +", " + "rechts: " + "T(" + r + ") = " + laufzeit(r));
        
        long s1 = l + (r-l)/3;              //das erste dritte Interval
        long s2 = l + 2*(r-l)/3;            //das zweite dritte Interval
        
        if( l == r-1){              //return l
            return l;
        }
        else{                                   //Vergleichen input mit rechten und linken Seite
            if( k < laufzeit(s1)){                 //Falls input ist in erste dritte Interval (also von l bis s1)
                 return ternareSuche(l,s1, k);     // T(n_max) im ersten Interval finden
            }
            else if( k >= laufzeit(s2)){             //Falls input ist im Interval von s2 - r
                
                 return ternareSuche(s2, r, k);     //T(n_max) im Interval s2 - r finden
            }
            else{
                return  ternareSuche(s1, s2, k);    //Input liegt zwischen s1 und s2
            }
            
            
        }
        
        
    }

    
    public static void main(String[] args){
        if( args.length == 1){

        
       try{ 
           

           
            long in = Long.parseLong(args[0]); 
           
            if( in > 0){
                
                ternareSuche(in);
                
            }
            else{
                throw new Exception();
            }
        
        }
        catch(Exception e){                 //Falls Eingabe keine positive Zahl ist, wird der Satz ausgegeben
            System.out.println("FEHLER: Es muss genau eine positive ganze Zahl uebergeben werden.");
        }
    }
    else{                       //Falls es zu viele Eingabe gibt
        System.out.println("FEHLER: Es muss genau eine positive ganze Zahl uebergeben werden.");
    }
    }
}