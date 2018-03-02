package model;

import java.io.IOException;
import model.interfaces.ICommand;

public class UndoCommand implements ICommand {
	
	@Override
	public void run() throws IOException {
		CommandHistory.undo();
	}
}
