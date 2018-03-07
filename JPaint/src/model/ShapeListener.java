package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import model.interfaces.IShape;
import model.interfaces.IShapeListener;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

public class ShapeListener implements IShapeListener {

	@Override
	public void update(PaintCanvas canvas, ShapeList list) {
		Graphics2D g = canvas.getGraphics2D();
		
		//White rectangle background
		g.setStroke(new BasicStroke(0));
		g.setPaint(Color.WHITE);
		g.fillRect(-30, -30, 2000, 1000);
		g.drawRect(-30, -30, 2000, 1000);
		
		for(IShape shape : list){	
			shape.draw(g);
		}

	}

}
