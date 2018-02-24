package model.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.IShape;
import model.persistence.ApplicationState;

class Ellipse implements IShape {
	Point start;
	Point end;
	ApplicationState state;
	ShapeShadingType shade;
	ShapeColor primColor;
	ShapeColor secColor;
	Color colorOne;
	Color colorTwo;
	
	public Ellipse(Point start, Point end, ApplicationState state) {
		this.start = start;
		this.end = end;
		shade = state.getActiveShapeShadingType();
		primColor = state.getActivePrimaryColor();
		secColor = state.getActiveSecondaryColor();
	}

	public void draw(Graphics2D g) {
		colorOne = ColorFactory.retrieveColor(primColor);
		colorTwo = ColorFactory.retrieveColor(secColor);
		int minX = Math.min(start.x, end.x);
		int minY = Math.min(start.y, end.y);
		int maxX = Math.max(start.x, end.x);
		int maxY = Math.max(start.y, end.y);

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

	public Point getStart() {
		return this.start;
	}

	public Point getEnd() {
		return this.end;
	}

	public boolean contains(Point clickStart, Point shapeStart, Point shapeEnd) {
		return true;
	}

	@Override
	public boolean equals(IShape other) {
		// TODO Auto-generated method stub
		return false;
	}
}
