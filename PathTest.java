package DepthFirstSearch;

import java.util.*;

public class PathTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner cityNameInput = new Scanner(System.in);
		System.out.println("Please enter the name of the starting city.");
		String startingPoint = cityNameInput.next();
		System.out.println("Please enter name of the goal city.");
		String goal = cityNameInput.next();
		
		CityList aList = new CityList();

		aList.createList();
		aList.search(startingPoint, goal);
		
	}
}
