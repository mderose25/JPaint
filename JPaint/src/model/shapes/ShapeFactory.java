package model.shapes;

import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.*;

public class ShapeFactory {
	
		private ShapeFactory(){};
		
		public static IShape createShape(ShapeType shapeType, Point start, Point end){
			IShape shape = null;

				switch(shapeType){
				case ELLIPSE:
					shape = new Ellipse();	
				
				case RECTANGLE:
					shape = new Rectangle(start, end); 
					
				case TRIANGLE:
					shape = new Triangle(); 		
				}		
				return shape; 		
		}
}
