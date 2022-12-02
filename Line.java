import java.lang.Math;

public class Line {
    
	static Point begin;
	static Point ende;
	
	public Line(Point start, Point end) {
		begin=start;
		ende=end;
		 
	}
	public  Point getStart(){
		return begin;
	}
	public Point getEnd(){
		return ende;
	}
	public int side(Point c) {
		
		double ax=begin.get(0);
		double ay=begin.get(1);		
		double bx=ende.get(0);
		double by=ende.get(1);
		double cx=c.get(0);
		double cy=c.get(1);
		
		return (int)Math.signum((bx - ax) * (cy - ay) - (by - ay) * (cx - ax));		
				
	}
	
	public void invertDirection() {
		Point tmp=new Point(begin.get(0),begin.get(1));
		begin=new Point(ende.get(0),ende.get(1));
		ende=tmp;
	}
	
	public String toString() {
		return begin.toString()+" -- "+ende.toString();
	}
}