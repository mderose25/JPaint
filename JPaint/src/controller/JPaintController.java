package controller;

import java.io.IOException;

import model.CopyCommand;
import model.DeleteCommand;
import model.PasteCommand;
import model.RedoCommand;
import model.UndoCommand;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
    		CopyCommand copyCommand = new CopyCommand();
    		PasteCommand pasteCommand = new PasteCommand();
    		RedoCommand redoCommand = new RedoCommand();
    		UndoCommand undoCommand = new UndoCommand();
    		DeleteCommand deleteCommand = new DeleteCommand();
    		
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        
        uiModule.addEvent(EventName.COPY, () -> {
			try {
				copyCommand.run();	
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
        
        uiModule.addEvent(EventName.PASTE, () -> {
			try {
				pasteCommand.run();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
        
        uiModule.addEvent(EventName.REDO, () -> {
			try {
				redoCommand.run();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
        
        uiModule.addEvent(EventName.UNDO, () -> {
			try {
				undoCommand.run();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
        
        uiModule.addEvent(EventName.DELETE, () -> {
			try {
				deleteCommand.run();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
    }
}
