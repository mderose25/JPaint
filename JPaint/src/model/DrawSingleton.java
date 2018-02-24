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
	
	public IShape removeShape(){
		return firstInstance.shapeList.pop();
	}
	
	public void addShape(IShape shape, PaintCanvas canvas){
		firstInstance.shapeList.push(shape, canvas);
	}
	
}
