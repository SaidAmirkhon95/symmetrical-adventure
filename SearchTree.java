public class SearchTree{
private Object content;
private int hoehe;
private SearchTree lc;
private SearchTree rc;


public SearchTree(){
content=null;
hoehe=-1;
lc=null;
 rc=null;
 
}

public SearchTree(int[] array){
  content=null;
  hoehe=-1;
  for(int f=0;f<array.length;f++){
    add(array[f]);
  }
}

public void add(int value){
if(content==null){
  content=value;
  hoehe++;
  lc=new SearchTree();
  rc=new SearchTree();
}
else if((Integer)content!=value){
if(value>(Integer)content){
  rc.add(value);
}
else {
  lc.add(value);
}
if(lc.getHoehe()>=rc.getHoehe()){
  hoehe=lc.getHoehe()+1;
}
else hoehe=rc.getHoehe()+1;
}
else{

}
}
public void inOrder(){
  if(content!=null){
  lc.inOrder();
  System.out.print(content+" ");
  rc.inOrder();
}
}
public void preOrder(){
  if(content!=null){
  System.out.print(content+" ");
  lc.preOrder();
  rc.preOrder();
}
}
public void postOrder(){
  if(content!=null){
  lc.postOrder();
  rc.postOrder();

  System.out.print(content+" ");
}
}
public int getHoehe(){
  return hoehe;
}
}
