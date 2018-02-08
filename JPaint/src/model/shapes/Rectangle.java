package model.shapes;

import model.Point;
import model.interfaces.IShape;

public class Rectangle implements IShape{
	Point start;
	Point end;

	public Rectangle(Point start, Point end) {
		this.start = start;
		this.end = end; 
	}

}