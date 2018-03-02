package model;

import java.io.IOException;

import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

public class MoveCommand implements ICommand, IUndoable {
	PaintCanvas canvas;
	ApplicationState state;
	Point start;
	Point end; 
	ShapeList selectedList = new ShapeList();

	public MoveCommand(ApplicationState state, PaintCanvas canvas, Point start, Point end){
		this.state = state;
		this.canvas = canvas;
		this.start = start;
		this.end = end; 
	}
	
	@Override
	public void run() throws IOException {
		
		SelectSingleton selectInstanceTwo = SelectSingleton.getInstance();
		DrawSingleton drawInstanceTwo = DrawSingleton.getInstance();
		selectedList = selectInstanceTwo.getList();
		ShapeMover move = new ShapeMover();
		
		for(IShape i : selectedList){
			drawInstanceTwo.shapeList.remove(i);
			move.updateShape(i, start, end);
			drawInstanceTwo.shapeList.push(i, canvas, state);			
		}
		
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		
		
	}

	@Override
	public void redo() {
		
		
	}

}
