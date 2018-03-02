package model;

import java.io.IOException;

import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;
import model.shapes.ShapeFactory;
import view.gui.PaintCanvas;

class DrawCommand implements ICommand, IUndoable {
	PaintCanvas canvas;
	ApplicationState state;
	Point start;
	Point end; 
	IShape newShape;
	DrawSingleton drawInstanceOne;

	public DrawCommand(ApplicationState state, PaintCanvas canvas, Point start, Point end){
		this.state = state;
		this.canvas = canvas;
		this.start = start;
		this.end = end; 
		newShape = ShapeFactory.createShape(start, end, state);
	}
	
	@Override
	public void run() throws IOException {	
			drawInstanceOne = DrawSingleton.getInstance();
			drawInstanceOne.shapeList.push(newShape, canvas, state);
			CommandHistory.add(this);
	}

	@Override
	public void undo() {
		ShapeListener listener = new ShapeListener();
		drawInstanceOne.shapeList.remove(this.newShape);
		listener.update(canvas, drawInstanceOne.shapeList);
	}

	@Override
	public void redo() {
		DrawCommand draw = new DrawCommand(this.state, canvas, this.start, this.end);
		try {
			draw.run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}












