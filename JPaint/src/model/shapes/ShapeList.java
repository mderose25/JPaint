package model.shapes;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import model.*;
import model.interfaces.IShape;
import view.gui.PaintCanvas;

public class ShapeList extends ArrayList<IShape> {
	
		public void push(IShape shape, PaintCanvas canvas){
			if(shape == null) throw new IllegalArgumentException();
			this.add(shape);		
			ShapeListener listener = new ShapeListener(shape);
			listener.update(canvas);
		}
		
		public IShape pop(){
			if (this.isEmpty()) throw new EmptyStackException();
			return this.remove(this.size() - 1);
		}
		
}

