package main;

import events.EventCallback;
import events.PrimaryColorChoice;
import events.SecondaryColorChoice;
import events.ShadingChoice;
import events.ShapeChoice;
import events.StartEndMode;
import view.EventName;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;

public class Main {

	public static void main(String[] args) {
		
		PaintCanvas canvas = new PaintCanvas();
		GuiWindow fullCanvas = new GuiWindow(canvas);
		Gui gui = new Gui(fullCanvas);	
		
		ShapeChoice shape = new ShapeChoice();
		EventCallback cb = new EventCallback(gui, shape);
		gui.addEvent(EventName.CHOOSE_SHAPE, cb);
		
		PrimaryColorChoice pColor = new PrimaryColorChoice();
		EventCallback cb2 = new EventCallback(gui, pColor);
		gui.addEvent(EventName.CHOOSE_PRIMARY_COLOR, cb2);
		
		SecondaryColorChoice sColor = new SecondaryColorChoice();
		EventCallback cb3 = new EventCallback(gui, sColor);
		gui.addEvent(EventName.CHOOSE_SECONDARY_COLOR, cb3);
		
		ShadingChoice shadeChoice = new ShadingChoice();
		EventCallback cb4 = new EventCallback(gui, shadeChoice);
		gui.addEvent(EventName.CHOOSE_SHADING_TYPE, cb4);
		
		StartEndMode startEnd = new StartEndMode();
		EventCallback cb5 = new EventCallback(gui, startEnd);
		gui.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, cb5);		
		
	}

}
