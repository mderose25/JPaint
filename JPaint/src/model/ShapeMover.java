package model;

import model.interfaces.IShape;

public class ShapeMover {
	Point shapeStart;
	Point shapeEnd;
	int deltaX;
	int deltaY;
	int newStartX;
	int newStartY;
	int newEndX;
	int newEndY;
	
	public void updateShape(IShape shape, Point clickStart, Point clickEnd){
		shapeStart = shape.getStart();
		shapeEnd = shape.getEnd();
		
		deltaX = clickEnd.x - clickStart.x;
		deltaY = clickEnd.y - clickStart.y;
		newStartX = deltaX + shape.getStart().x;
		newEndX = deltaX + shape.getEnd().x;
		newStartY = deltaY + shape.getStart().y;
		newEndY = deltaY + shape.getEnd().y;
		
		Point newStart = new Point(newStartX, newStartY);
		Point newEnd = new Point(newEndX, newEndY);
		
		shape.setStart(newStart);
		shape.setEnd(newEnd);
		
	}
}
