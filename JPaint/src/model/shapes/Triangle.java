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

public class Triangle implements IShape {

	Point start;
	Point end;
	ApplicationState state;
	ShapeShadingType shade;
	ShapeColor primColor;
	ShapeColor secColor;
	Color colorOne;
	Color colorTwo;

	public Triangle(Point start, Point end, ApplicationState state) {
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
				g.fillPolygon(new int[] { start.x, end.x, start.x }, new int[] { start.y, end.y, end.y }, 3);
			}

			if (shade.equals(shade.OUTLINE)) {
				g.setStroke(new BasicStroke(5));
				g.setColor(colorOne);
			}

			if (shade.equals(shade.OUTLINE_AND_FILLED_IN)) {
				g.setStroke(new BasicStroke(5));
				g.setColor(colorOne);
				g.fillPolygon(new int[] { start.x, end.x, start.x }, new int[] { start.y, end.y, end.y }, 3);
				g.setColor(colorTwo);
			}

			g.drawPolygon(new int[] { start.x, end.x, start.x }, new int[] { start.y, end.y, end.y }, 3);
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
	public boolean contains(Point clickStart, Point shapeStart, Point shapeEnd) {
		return true;
	}

	@Override
	public boolean equals(IShape other) {
		// TODO Auto-generated method stub
		return false;
	}
}
