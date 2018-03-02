package model;

import java.util.ArrayList;

import model.Point;
import model.SelectSingleton;
import model.interfaces.IShape;
import model.shapes.ShapeList;

public class ShapeSelector {
	ShapeList list;
	IShape toReturn;
	ArrayList<IShape> listReturn;
	Point clickStart;
	Point shapeStart;
	Point shapeEnd;
	ShapeList selectedList = new ShapeList();

	//Determines if a click has been within a shape
	public IShape selectShape(ShapeList list, Point clickStart) {
		for (IShape i : list) {
			shapeStart = i.getStart();
			shapeEnd = i.getEnd();
			
			if (i.contains(clickStart, shapeStart, shapeEnd)) {
				toReturn = i;
			}
		}
		return toReturn;
	}
	
	public ArrayList<IShape> dragSelect (ShapeList list, Point clickStart, Point clickEnd){
		for(IShape i : list) {
			shapeStart = i.getStart();
			shapeEnd = i.getEnd();
			
			if(i.dragContains(clickStart, clickEnd, shapeStart, shapeEnd)){
				listReturn.add(i);
			}
		}
		return listReturn;
	}

	//Adds selected shape to list
	public void addToList(IShape selected) {
		SelectSingleton selectInstanceOne = SelectSingleton.getInstance();
		
		try {
			if (selected == null) {
				selectInstanceOne.shapeList.clear();
		}

			else if (selectedList.size() == 0) {
				selectInstanceOne.shapeList.add(selected);
			}

			else {
				for (int i = 0; i < selectedList.size(); i++) {
					if (!(selected == selectedList.get(i))) {
						selectInstanceOne.shapeList.add(selected);
					}
				}
			}	
		} catch (Exception ex) {
	  }
	}
}
