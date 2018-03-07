package model;

import java.io.IOException;
import java.util.ArrayList;

import model.DrawSingleton;
import model.SelectSingleton;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;
import model.shapes.ShapeFactory;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

public class DeleteCommand implements ICommand, IUndoable {
	IApplicationState state;
	PaintCanvas canvas;
	ShapeList selectedList = new ShapeList();
	ShapeList drawnList = new ShapeList();
	ShapeListener listener = new ShapeListener();
	ArrayList<IShape> deletedList = new ArrayList<IShape>();
	DrawSingleton drawInstanceThree = DrawSingleton.getInstance();
	IShape priorShape; 
	IShape redoShape;
	Point priorStart;
	Point priorEnd; 
	int priorStartX;
	int priorStartY;
	int priorEndX;
	int priorEndY; 

	public DeleteCommand(PaintCanvas canvas, IApplicationState state) {
		this.canvas = canvas;
		this.state = state;
	}

	@Override
	public void run() throws IOException {
		SelectSingleton selectInstanceFour = SelectSingleton.getInstance();
		selectedList = selectInstanceFour.getList();
		DrawSingleton drawInstanceThree = DrawSingleton.getInstance();
		drawnList = drawInstanceThree.getList();
		deletedList.clear();

			for (IShape i : selectedList) {
				priorStartX = i.getStart().x;
				priorStartY = i.getStart().y;
				priorEndX = i.getEnd().x;
				priorEndY = i.getEnd().y;
				priorStart = new Point(priorStartX, priorStartY);
				priorEnd = new Point(priorEndX, priorEndY);
				priorShape = ShapeFactory.createShape(priorStart, priorEnd, state);
				deletedList.add(priorShape);
				drawInstanceThree.removeShape(i);
			}

		listener.update(canvas, drawnList);

			CommandHistory.add(this);

	}

	@Override
	public void undo() {
		drawnList = drawInstanceThree.getList();
		
		for(IShape i : deletedList){
			drawnList.push(i, canvas);
		}
	}

	@Override
	public void redo() {
		for(IShape i : deletedList){
			drawnList.remove(i);
		}
		
		listener.update(canvas,  drawnList);
	}

}
