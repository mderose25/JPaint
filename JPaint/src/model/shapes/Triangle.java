package model.shapes;

import java.awt.Graphics2D;

import model.Point;
import model.ShapeShadingType;
import model.interfaces.IShape;

public class Triangle implements IShape {
	Point start;
	Point end;

	public Triangle(Point start, Point end) {
		this.start = start;
		this.end = end; 
	}

	public void draw(Graphics2D g){
	    int minX = Math.min(start.x, end.x);
	    int minY = Math.min(start.y, end.y);
	    int maxX = Math.max(start.x, end.x);
	    int maxY = Math.max(start.y, end.y);
	    
        if (maxX - minX > 0 && maxY - minY > 0) {
		g.drawPolygon(new int[] {start.x, end.x, start.x}, new int[] {start.y, end.y, end.y}, 3);
        }
	}
}
