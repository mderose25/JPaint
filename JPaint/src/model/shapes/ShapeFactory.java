package model.shapes;

import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.*;

public class ShapeFactory {
	IApplicationState state; 
	
		private ShapeFactory(){};
		
		public static IShape createShape(Point start, Point end, IApplicationState state){
			IShape shape = null;
			ShapeType shapeType = state.getActiveShapeType();
			
				switch(shapeType){
				case ELLIPSE:
					shape = new Ellipse(start, end, state);	
					return shape; 
				
				case RECTANGLE:
					shape = new Rectangle(start, end, state); 
					return shape;
					
				case TRIANGLE:
					shape = new Triangle(start, end, state); 	
					return shape; 
				}
				
				return shape;
						
		}
}
