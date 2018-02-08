package model;

import java.io.IOException;

import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.shapes.ShapeFactory;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

class Command implements ICommand {
	ShapeList shapeList = new ShapeList();
	PaintCanvas canvas;
	ShapeType shape; 
	ApplicationState state;
	StartAndEndPointMode mode; 
	Point start;
	Point end; 

	public Command(ApplicationState state, PaintCanvas canvas, Point start, Point end){
		this.state = state;
		this.canvas = canvas; 
		this.start = start;
		this.end = end; 
		shape = state.getActiveShapeType();
		mode = state.getActiveStartAndEndPointMode();
	}
	
	@Override
	public void run() throws IOException {
			IShape newShape = ShapeFactory.createShape(shape, start, end);
			shapeList.push(newShape, canvas, start, end);
	}

}
