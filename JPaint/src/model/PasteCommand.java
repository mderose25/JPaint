package model;

import java.io.IOException;

import model.interfaces.ICommand;
import model.interfaces.IUndoable;

public class PasteCommand implements ICommand, IUndoable {

	@Override
	public void run() throws IOException {
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
	
		
	}

	@Override
	public void redo() {
		
		
	}

}
