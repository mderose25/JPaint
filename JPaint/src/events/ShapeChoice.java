package events;

import view.interfaces.IDialogChoice;

public class ShapeChoice implements IDialogChoice<Shape> {

	@Override
	public Shape getCurrentSelection() {
		return null;
	}

	@Override
	public Shape[] getDialogOptions() {
		Shape[] shapes = {Shape.ELLIPSE, Shape.RECTANGLE, Shape.TRIANGLE};
		return shapes;
	}

	@Override
	public String getDialogText() {
		return "Choose a Shape";
	}

	@Override
	public String getDialogTitle() {
		return "Shape Choice";
	}

}
