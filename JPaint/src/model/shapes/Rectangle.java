package model.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

public class Rectangle implements IShape {
	Point start, end;
	ApplicationState state;
	ShapeColor primColor, secColor;
	ShapeShadingType shade;
	Color colorOne, colorTwo;
	int minX, minY, maxX, maxY;

	public Rectangle(Point start, Point end, IApplicationState state2) {
		this.start = start; this.end = end;
		primColor = state2.getActivePrimaryColor();
		secColor = state2.getActiveSecondaryColor();
		shade = state2.getActiveShapeShadingType();
	}

	@Override
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
				g.fillRect(minX, minY, maxX - minX, maxY - minY);
			}

			if (shade.equals(shade.OUTLINE)) {
				g.setStroke(new BasicStroke(5));
				g.setColor(colorOne);
			}

			if (shade.equals(shade.OUTLINE_AND_FILLED_IN)) {
				g.setStroke(new BasicStroke(5));
				g.setColor(colorOne);
				g.fillRect(minX, minY, maxX - minX, maxY - minY);
				g.setColor(colorTwo);
			}
			g.drawRect(minX, minY, maxX - minX, maxY - minY);
			
		}
	}

	@Override
	public Point getStart() {
		return this.start;
	}

	@Override
	public Point getEnd() {
		return this.end;
	}

	@Override
	public void setStart(Point start) {
		this.start = start;
	}

	@Override
	public void setEnd(Point end) {
		this.end = end;
	}

	
	@Override
	public boolean contains(Point clickStart, Point shapeStart, Point shapeEnd) {
		return(clickStart.x <= maxX) && (clickStart.x >= minX) &&
				(clickStart.y >= minY) &&(clickStart.y <= maxY);
	}
	
	@Override
	public boolean dragContains(Point clickStart, Point clickEnd, Point shapeStart, Point shapeEnd){
		return(clickStart.x >= maxX) && (clickStart.x <= minX) &&
				(clickStart.y <= minY) &&(clickStart.y >= maxY) &&
				(clickEnd.x >= maxX) && (clickEnd.x <= minX) &&
				(clickEnd.y <= minY) &&(clickEnd.y >= maxY);
	}

	
}