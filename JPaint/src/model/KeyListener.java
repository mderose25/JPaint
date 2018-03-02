package model;

import java.awt.event.KeyEvent;

import model.persistence.ApplicationState;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

public class KeyListener implements java.awt.event.KeyListener {
	ShapeListener listener = new ShapeListener();
	ShapeList selectedList = new ShapeList();
	PaintCanvas canvas; 
	
	public KeyListener(PaintCanvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	//Need to figure out how to wire up key listener to use delete key on shapes
	
	@Override
	public void keyReleased(KeyEvent e) {
		SelectSingleton selectInstanceFour = SelectSingleton.getInstance();
		selectedList = selectInstanceFour.getList();
		
		if(e.getKeyCode()== KeyEvent.VK_C){
			System.out.println("Delete has been pressed");
		}
		
			
			
	//	listener.update(canvas, selectedList);

	}

}
