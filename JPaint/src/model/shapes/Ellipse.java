package model.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.StartAndEndPointMode;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

class Ellipse implements IShape {
	Point start, end;
	ApplicationState state;
	ShapeColor primColor, secColor;
	ShapeShadingType shade;
	Color colorOne, colorTwo;
	int minX, minY, maxX, maxY;
	
	public Ellipse(Point start, Point end, ApplicationState state) {
		this.start = start; this.end = end;
		primColor = state.getActivePrimaryColor();
		secColor = state.getActiveSecondaryColor();
		shade = state.getActiveShapeShadingType();
	}

	public void draw(Graphics2D g) {
		colorOne = ColorFactory.retrieveColor(primColor);
		colorTwo = ColorFactory.retrieveColor(secColor);
		minX = Math.min(start.x, end.x); 
		minY = Math.min(start.y, end.y);
		maxX = Math.max(start.x, end.x); 
		maxY = Math.max(start.y, end.y);
		
		if (maxX - minX > 0 && maxY - minY > 0) {
			if (shade.equals(shade.FILLED_IN)) {
				g.setStroke(new BasicStroke(0));
				g.setPaint(colorOne);
				g.fillOval(minX, minY, maxX - minX, maxY - minY);
			}

			if (shade.equals(shade.OUTLINE)) {
				g.setStroke(new BasicStroke(5));
				g.setColor(colorOne);
			}

			if (shade.equals(shade.OUTLINE_AND_FILLED_IN)) {
				g.setStroke(new BasicStroke(5));
				g.setColor(colorOne);
				g.fillOval(minX, minY, maxX - minX, maxY - minY);
				g.setColor(colorTwo);
			}

			g.drawOval(minX, minY, maxX - minX, maxY - minY);
			
		}
	}
	
	@Override
	public void setStart(Point start) {
		this.start = start;
	}

	@Override
	public void setEnd(Point end) {
		this.end = end; 
	}

	public Point getStart() {
		return this.start;
	}

	public Point getEnd() {
		return this.end;
	}

	@Override
	public boolean contains(Point clickStart, Point shapeStart, Point shapeEnd) {
		return (clickStart.x <= maxX) && (clickStart.x >= minX) && (clickStart.y >= minY) && (clickStart.y <= maxY);
	}

	@Override
	public boolean dragContains(Point clickStart, Point clickEnd, Point shapeStart, Point shapeEnd) {
		
		return false;
	}

}
