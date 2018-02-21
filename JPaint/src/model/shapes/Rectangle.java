package model.shapes;

import java.awt.Graphics2D;

import model.Point;
import model.interfaces.IShape;

public class Rectangle implements IShape{
	Point start;
	Point end;

	public Rectangle(Point start, Point end) {
		this.start = start;
		this.end = end; 
	}

	public void draw(Graphics2D g){
	    int minX = Math.min(start.x, end.x);
	    int minY = Math.min(start.y, end.y);
	    int maxX = Math.max(start.x, end.x);
	    int maxY = Math.max(start.y, end.y);
		
        if (maxX - minX > 0 && maxY - minY > 0) {
		g.drawRect(minX, minY, maxX - minX, maxY - minY);
        }
	}

}