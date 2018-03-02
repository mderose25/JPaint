package model.interfaces;

import model.Point;
import model.persistence.ApplicationState;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

public interface IShapeListener {
		void update(PaintCanvas canvas, ShapeList list); 
}
