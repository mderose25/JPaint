package model;

import java.io.IOException;
import model.interfaces.ICommand;

public class RedoCommand implements ICommand {

	@Override
	public void run() throws IOException {
		CommandHistory.redo();
	}
}
