package model;

import model.interfaces.ISingleton;
import model.shapes.ShapeList;
import model.interfaces.IShape;
import model.interfaces.ISingleton;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

public class CopySingleton implements ISingleton {

	private static CopySingleton firstInstance = null;
	
	private CopySingleton(){}
	ShapeList shapeList = new ShapeList();
	
	public static CopySingleton getInstance(){
		if(firstInstance == null){
			firstInstance = new CopySingleton();
		}
		
		return firstInstance; 
	}
	
	public ShapeList getList(){
		return firstInstance.shapeList;
	}
	
	public IShape getShape(int i){
		return firstInstance.shapeList.get(i);
	}
	
	public void clearCopied(ShapeList list){
		list.clear();
	}

}

