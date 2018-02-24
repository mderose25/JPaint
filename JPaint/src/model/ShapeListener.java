package model;

import java.awt.Graphics2D;
import model.interfaces.IShape;
import model.interfaces.IShapeListener;
import view.gui.PaintCanvas;

public class ShapeListener implements IShapeListener {
	IShape shape;

	public ShapeListener(IShape shape) {
		this.shape = shape;
	}

	@Override
	public void update(PaintCanvas canvas) {
		Graphics2D g2 = canvas.getGraphics2D();
		shape.draw(g2);
	}

}
