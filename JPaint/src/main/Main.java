package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.MouseHandler;
import model.dialogs.DialogProvider;
import model.interfaces.IDialogProvider;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
    		PaintCanvas paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        MouseHandler handler = new MouseHandler(appState, paintCanvas);
   		paintCanvas.addMouseListener(handler);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();
    }
}
