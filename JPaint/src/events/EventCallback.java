package events;

import view.EventName;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IDialogChoice;
import view.interfaces.IEventCallback;

public class EventCallback implements IEventCallback {
	
	Gui gui; 
	IDialogChoice diag; 
	
	public EventCallback(Gui gui, IDialogChoice diag){
		this.gui = gui; 
		this.diag = diag;
	}
	
	@Override
	public void run() {
		gui.getDialogResponse(diag);	
	}

}
