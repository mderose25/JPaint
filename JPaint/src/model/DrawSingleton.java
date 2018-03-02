package model;

import model.interfaces.IShape;
import model.interfaces.ISingleton;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

public class DrawSingleton implements ISingleton {

	private static DrawSingleton firstInstance = null;
	
	private DrawSingleton(){}
	ShapeList shapeList = new ShapeList();
	
	public static DrawSingleton getInstance(){
		if(firstInstance == null){
			firstInstance = new DrawSingleton();
		}
		return firstInstance; 
	}
	
	public ShapeList getList(){
		return firstInstance.shapeList;
	}
	
	public void removeShape(IShape i){
		firstInstance.shapeList.remove(i);
	}
	
}
