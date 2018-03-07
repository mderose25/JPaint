package model;

import java.io.IOException;

import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;
import model.shapes.ShapeFactory;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

public class MoveCommand implements ICommand, IUndoable {
	PaintCanvas canvas;
	IApplicationState state;
	Point start;
	Point end; 
	ShapeList selectedList = new ShapeList();
	DrawSingleton drawInstanceTwo;
	IShape priorShape; 
	IShape redoShape;
	Point priorStart;
	Point priorEnd; 
	int priorStartX;
	int priorStartY;
	int priorEndX;
	int priorEndY; 
	
	public MoveCommand(IApplicationState state, PaintCanvas canvas, Point start, Point end){
		this.state = state;
		this.canvas = canvas;
		this.start = start;
		this.end = end; 
	}
	
	@Override
	public void run() throws IOException {
		SelectSingleton selectInstanceTwo = SelectSingleton.getInstance();
		drawInstanceTwo = DrawSingleton.getInstance();
		selectedList = selectInstanceTwo.getList();
		ShapeMover move = new ShapeMover();
		
		for(IShape i : selectedList){
			drawInstanceTwo.shapeList.remove(i);
			priorStartX = i.getStart().x;
			priorStartY = i.getStart().y;
			priorEndX = i.getEnd().x;
			priorEndY = i.getEnd().y;
			priorStart = new Point(priorStartX, priorStartY);
			priorEnd = new Point(priorEndX, priorEndY);
			move.updateShape(i, start, end);
			drawInstanceTwo.shapeList.push(i, canvas);	
		}
		
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		drawInstanceTwo = DrawSingleton.getInstance();
		int size = drawInstanceTwo.shapeList.size();
		redoShape = drawInstanceTwo.shapeList.get(size -1);
		priorStartX = redoShape.getStart().x;
		priorStartY = redoShape.getStart().y;
		priorEndX = redoShape.getEnd().x;
		priorEndY = redoShape.getEnd().y;
		drawInstanceTwo.shapeList.remove(size -1);
		priorShape = ShapeFactory.createShape(priorStart, priorEnd, state);
		priorStart = new Point(priorStartX, priorStartY);
		priorEnd = new Point(priorEndX, priorEndY);
		drawInstanceTwo.shapeList.push(priorShape, canvas);
	}

	@Override
	public void redo() {
		drawInstanceTwo = DrawSingleton.getInstance();
		int size = drawInstanceTwo.shapeList.size();
		drawInstanceTwo.shapeList.remove(size -1);
		priorShape = ShapeFactory.createShape(priorStart, priorEnd, state);
		drawInstanceTwo.shapeList.push(priorShape, canvas);
		
	}

}
