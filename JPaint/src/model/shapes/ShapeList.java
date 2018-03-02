package model.shapes;

import java.util.ArrayList;
import java.util.EmptyStackException;
import model.*;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

public class ShapeList extends ArrayList<IShape> {
	ShapeListener listener = new ShapeListener();
	
		public void push(IShape shape, PaintCanvas canvas, ApplicationState state){
			if(shape == null) throw new IllegalArgumentException();
			this.add(shape);		
			listener.update(canvas, this);
		}
		
		public IShape pop(){
			if (this.isEmpty()) throw new EmptyStackException();
			return this.remove(this.size() - 1);
		}
		
}

