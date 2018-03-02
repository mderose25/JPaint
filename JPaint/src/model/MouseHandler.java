package model;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

public class MouseHandler extends MouseAdapter {
	PaintCanvas canvas;
	ApplicationState state = null;
	Point x;
	Point y;

	public MouseHandler(ApplicationState state, PaintCanvas canvas) {
		this.state = state;
		this.canvas = canvas;
	}

	public void mousePressed(MouseEvent e) {
		int a = e.getX();
		int b = e.getY();
		x = new Point(a, b);
	
	}

	public void mouseReleased(MouseEvent e) {
		int a = e.getX();
		int b = e.getY();
		y = new Point(a, b);

		if (state.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.DRAW)) {
			DrawCommand draw = new DrawCommand(state, canvas, x, y);
			try {
				draw.run();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (state.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.SELECT)) {
			SelectCommand select = new SelectCommand(state, canvas, x, y);
			try {
				select.run();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		if (state.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.MOVE)) {
			MoveCommand move = new MoveCommand(state, canvas, x, y);
			try {
				move.run();
			} catch (IOException e1) {
				e1.printStackTrace();
			}	
		}
	}
}
