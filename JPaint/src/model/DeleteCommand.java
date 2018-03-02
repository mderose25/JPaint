package model;

import java.io.IOException;
import model.DrawSingleton;
import model.SelectSingleton;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.shapes.ShapeList;

public class DeleteCommand implements ICommand, IUndoable {
	ShapeList selectedList = new ShapeList();
	ShapeList drawnList = new ShapeList();

	@Override
	public void run() throws IOException {
		SelectSingleton selectInstanceFour = SelectSingleton.getInstance();
		selectedList = selectInstanceFour.getList();
		DrawSingleton drawInstanceThree = DrawSingleton.getInstance();
		drawnList = drawInstanceThree.getList();
	
		for(IShape i : selectedList){
			drawInstanceThree.removeShape(i);
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
