package model.interfaces;

import java.awt.Graphics2D;

import model.Point;
import model.ShapeShadingType;

public interface IShape {
	boolean contains(Point clickStart, Point shapeStart, Point shapeEnd);
	void draw(Graphics2D g);
	Point getStart();
	Point getEnd();
	boolean equals(IShape other);
}
