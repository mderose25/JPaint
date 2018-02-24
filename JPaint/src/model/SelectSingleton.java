package model;

import model.interfaces.IShape;
import model.interfaces.ISingleton;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

public class SelectSingleton implements ISingleton {

	private static SelectSingleton firstInstance = null;
	
	private SelectSingleton(){}
	ShapeList shapeList = new ShapeList();
	
	public static SelectSingleton getInstance(){
		if(firstInstance == null){
			firstInstance = new SelectSingleton();
		}
		
		return firstInstance; 
	}
	
	public ShapeList getList(){
		return firstInstance.shapeList;
	}
	
	public IShape getShape(int i){
		return firstInstance.shapeList.get(i);
	}
	
	public IShape removeShape(){
		return firstInstance.shapeList.pop();
	}
	
	public void addShape(IShape shape, PaintCanvas canvas){
		firstInstance.shapeList.push(shape, canvas);
	}

}
