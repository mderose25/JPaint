package events;

import view.interfaces.IDialogChoice;

public class StartEndMode implements IDialogChoice<Action> {

	@Override
	public Action getCurrentSelection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Action[] getDialogOptions() {
		Action[] action = {Action.DRAW, Action.MOVE, Action.SELECT};;
		return action;
	}

	@Override
	public String getDialogText() {
		return "Toggle between Start and End mode";
	}

	@Override
	public String getDialogTitle() {
		return "Start/End Mode";
	}

}
