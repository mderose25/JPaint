package model;

import java.util.ArrayList;

import model.Point;
import model.SelectSingleton;
import model.interfaces.IShape;
import model.shapes.ShapeList;

public class ShapeSelector {
	ShapeList list;
	IShape toReturn;
	Point clickStart;
	Point shapeStart;
	Point shapeEnd;
	ShapeList selectedList = new ShapeList();

	public IShape selectShape(ShapeList list, Point clickStart) {
		for (IShape i : list) {
			shapeStart = i.getStart();
			shapeEnd = i.getEnd();

			if (i.contains(clickStart, shapeStart, shapeEnd)) {
				return toReturn = i;
			}
		}
		return toReturn;
	}

	public void listSelector(IShape selected) {
		SelectSingleton selectInstanceOne = SelectSingleton.getInstance();
		selectedList = selectInstanceOne.getList();
		try {
			if (selected == null) {
				selectInstanceOne.shapeList.clear();
			}

			else if (selectedList.size() == 0) {
				selectInstanceOne.shapeList.add(selected);
			}

			else {
				for (int i = 0; i <= selectedList.size(); i++) {
					if (!(selected == selectedList.get(i))) {
						selectInstanceOne.shapeList.add(selected);
					}
				}
			}
		} catch (Exception ex) {
		}
		
		

	}

}
