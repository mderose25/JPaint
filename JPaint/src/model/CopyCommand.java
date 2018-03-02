package model;

import java.io.IOException;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.shapes.ShapeList;

public class CopyCommand implements ICommand {
	ShapeList selectedList = new ShapeList();
	ShapeList copiedList = new ShapeList();
	
	@Override
	public void run() throws IOException {
		SelectSingleton selectInstanceThree = SelectSingleton.getInstance();
		selectedList = selectInstanceThree.getList();
		CopySingleton copyInstanceOne = CopySingleton.getInstance();
		copiedList = copyInstanceOne.getList();
		
		for(IShape i : selectedList){
			copiedList.add(i);
		}
		
	}

}
