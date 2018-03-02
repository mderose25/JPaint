package model;

import java.io.IOException;
import java.util.ArrayList;

import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

class SelectCommand implements ICommand, IUndoable {
	PaintCanvas canvas;
	ApplicationState state;
	Point start;
	Point end;
	ArrayList<IShape> listSelect;
	IShape selected;
	ShapeList currentList = new ShapeList();
	ShapeList selectedList = new ShapeList();

	public SelectCommand(ApplicationState state, PaintCanvas canvas, Point start, Point end) {
		this.state = state;
		this.canvas = canvas;
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() throws IOException {
		DrawSingleton drawInstanceTwo = DrawSingleton.getInstance();
		SelectSingleton selectInstanceOne = SelectSingleton.getInstance();
		currentList = drawInstanceTwo.getList();
		selectedList = selectInstanceOne.getList();
		ShapeSelector selector = new ShapeSelector();
		selected = selector.selectShape(currentList, start);
		selector.addToList(selected);
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

}
