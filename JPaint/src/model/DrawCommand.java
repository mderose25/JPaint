package model;

import java.io.IOException;

import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.shapes.ShapeFactory;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

class DrawCommand implements ICommand {
	PaintCanvas canvas;
	ShapeType shape; 
	ApplicationState state;
	Point start;
	Point end; 

	public DrawCommand(ApplicationState state, PaintCanvas canvas, Point start, Point end){
		this.state = state;
		this.canvas = canvas;
		this.start = start;
		this.end = end; 
		shape = state.getActiveShapeType();
	}
	
	@Override
	public void run() throws IOException {	
			IShape newShape = ShapeFactory.createShape(start, end, state);
			DrawSingleton instanceOne = DrawSingleton.getInstance();
			instanceOne.shapeList.push(newShape, canvas);
			ShapeList list = instanceOne.getList();
			System.out.println(list.size());
			
	}

}
