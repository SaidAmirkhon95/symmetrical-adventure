import java.io.BufferedReader;
import java.io.FileReader;
// import java.io.InputStreamReader;
// import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
// import java.util.List;
// import java.util.stream.Collectors;

public class SearchTreeApplication{
    public static void main(String[] args){
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("System.in"));
            String[] arr;
            ArrayList<String[]> l1 = new ArrayList<String[]>();
            while( (line = br.readLine()) != null){
                arr = line.split(",");
                l1.add(arr);
            }
            if( l1.get(0)[0] == "in" || l1.get(0)[0] == "pre" || l1.get(0)[0]=="post"){
                try{
                     if(l1.get(0)[0] == "in"){
                        for( int i = 1; i < l1.size(); i++){
                            int[] brr = new int[l1.get(i).length];
                            for( int k = 0; k < brr.length; k++){
                                brr[k] = Integer.parseInt(l1.get(i)[k]);
                            }
                            SearchTree tree = new SearchTree(brr);
                            System.out.println("Hoehe: " + tree.getHoehe());
                            tree.inOrder();
                        }
                     }
                     if(l1.get(0)[0] == "pre"){
                        for( int i = 1; i < l1.size(); i++){
                            int[] brr = new int[l1.get(i).length];
                            for( int k = 0; k < brr.length; k++){
                                brr[k] = Integer.parseInt(l1.get(i)[k]);
                            }
                            SearchTree tree = new SearchTree(brr);
                            System.out.println("Hoehe: " + tree.getHoehe());
                            tree.preOrder();
                        }
                     }
                     if(l1.get(0)[0] == "post"){
                        for( int i = 1; i < l1.size(); i++){
                            int[] brr = new int[l1.get(i).length];
                            for( int k = 0; k < brr.length; k++){
                                brr[k] = Integer.parseInt(l1.get(i)[k]);
                            }
                            SearchTree tree = new SearchTree(brr);
                            System.out.println("Hoehe: " + tree.getHoehe());
                            tree.postOrder();
                        }
                     }
                     else{
                        for( int i = 1; i < l1.size(); i++){
                            int[] brr = new int[l1.get(i).length];
                            for( int k = 0; k < brr.length; k++){
                                brr[k] = Integer.parseInt(l1.get(i)[k]);
                            }
                            SearchTree tree = new SearchTree(brr);
                            System.out.println("Hoehe: " + tree.getHoehe());
                            tree.inOrder();
                        }
                     }
                }
                catch(Exception e){
                    System.out.println("keine Zahl");
                }
            }
        }
        catch(Exception e){
            System.out.println("File not found");
        }

    }
}
