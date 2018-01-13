package events;

import view.interfaces.IDialogChoice;

public class ShadingChoice implements IDialogChoice<Shade> {

	@Override
	public Shade getCurrentSelection() {
		return null;
	}

	@Override
	public Shade[] getDialogOptions() {
		Shade[] shade = {Shade.FILLEDIN, Shade.OUTLINE, Shade.OUTLINEANDFILLEDIN};
		return shade;
	}

	@Override
	public String getDialogText() {
		return "Choose a shade";
	}

	@Override
	public String getDialogTitle() {
		return "Shade Choice";
	}

}
