package model;

import java.awt.Graphics2D;
import model.interfaces.IShape;
import model.interfaces.IShapeListener;
import view.gui.PaintCanvas;

public class ShapeListener implements IShapeListener {
	IShape shape;
	
	public ShapeListener(IShape shape){
		this.shape = shape; 
	}

	@Override
	public void update(PaintCanvas canvas, Point start, Point end) {
		Graphics2D g2 = canvas.getGraphics2D();
	    int minX = Math.min(start.x, end.x);
	    int minY = Math.min(start.y, end.y);
	    int maxX = Math.max(start.x, end.x);
	    int maxY = Math.max(start.y, end.y);
		
        if (maxX - minX > 0 && maxY - minY > 0) {
           g2.drawRect(minX, minY, maxX - minX, maxY - minY);
        }
		
	}

}
