package model.shapes;

import java.awt.Color;

import model.*;

public class ColorFactory {
	
		private ColorFactory(){};
		
		public static Color retrieveColor(ShapeColor color){
			Color toReturn = null;
		
				switch(color){
				case BLACK:
					return toReturn.BLACK;
				
				case BLUE:	
					return toReturn.BLUE;
					
				case CYAN:
					return toReturn.CYAN;
					
				case DARK_GRAY:
					return toReturn.DARK_GRAY;
					
				case GRAY:
					return toReturn.GRAY;
					
				case GREEN:
					return toReturn.GREEN;
					
				case LIGHT_GRAY:
					return toReturn.LIGHT_GRAY;
					
				case MAGENTA:
					return toReturn.MAGENTA;
					
				case ORANGE:
					return toReturn.ORANGE;
					
				case PINK:
					return toReturn.PINK;
					
				case RED:
					return toReturn.RED;
					
				case WHITE:
					return toReturn.WHITE;
					
				case YELLOW:
					return toReturn.YELLOW;
					
				}
				
				return toReturn;
						
		}
}
