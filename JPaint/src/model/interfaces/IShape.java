package model.interfaces;

import java.awt.Graphics2D;

import model.Point;
import model.ShapeShadingType;
import view.gui.PaintCanvas;

public interface IShape {
	boolean contains(Point clickStart, Point shapeStart, Point shapeEnd);
	boolean dragContains(Point clickStart, Point clickEnd, Point shapeStart, Point shapeEnd);
	void draw(Graphics2D g);
	Point getStart();
	Point getEnd();
	void setStart(Point start);
	void setEnd(Point end);
}
