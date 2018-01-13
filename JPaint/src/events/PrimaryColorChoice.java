package events;

import view.interfaces.IDialogChoice;

public class PrimaryColorChoice implements IDialogChoice<Colors> {

	@Override
	public Colors getCurrentSelection() {
		return null;
	}

	@Override
	public Colors[] getDialogOptions() {
		Colors[] color = {Colors.RED, Colors.BLUE, Colors.GREEN, Colors.BLACK, 
				Colors.ORANGE, Colors.YELLOW, Colors.GRAY};
		return color;
	}

	@Override
	public String getDialogText() {
		return "Choose a primary color";
	}

	@Override
	public String getDialogTitle() {
		return "Primary Color Choice";
	}

}
