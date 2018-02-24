package model;

import java.io.IOException;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

class SelectCommand implements ICommand {
	PaintCanvas canvas;
	ShapeType shape;
	ApplicationState state;
	Point start;
	Point end;
	ShapeList currentList = new ShapeList();
	ShapeList selectedList = new ShapeList();

	public SelectCommand(ApplicationState state, PaintCanvas canvas, Point start, Point end) {
		this.state = state;
		this.canvas = canvas;
		this.start = start;
		this.end = end;
		shape = state.getActiveShapeType();
	}

	@Override
	public void run() throws IOException {
		DrawSingleton drawInstanceTwo = DrawSingleton.getInstance();
		currentList = drawInstanceTwo.getList();
		ShapeSelector selector = new ShapeSelector();
		IShape selected = selector.selectShape(currentList, start);
		selector.listSelector(selected);
	}

}
