package DepthFirstSearch;

import java.util.LinkedList;
import java.util.Stack;

public class CityList {

	private LinkedList<City> cityList = new LinkedList<City>();

	// Constructor to open file and build city graph
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void createList() {
		LinkedList neighborList = new LinkedList();
		String tempCityName = "", prevTempCity;
		String delimiter = " ";
		FileIn fileInput = new FileIn();
		fileInput
				.openFile("C:\\Users\\SimmonsCS28\\workspace\\CompSci223\\src\\Project2\\map.txt");
		String line = fileInput.readLine();

		// Store first cityName into temp variable
		String[] tempInitializeArray = line.split(delimiter);
		prevTempCity = tempInitializeArray[0];

		// Input file data into a list
		while (line != null) {

			// Create temporary array to split and store each city from a line
			String[] tempInputArray = line.split(delimiter);

			// If the previous city is not the same as the current city in the
			// array,
			// create a new parent city object and push it to the list of
			// cities.
			if (!prevTempCity.equals(tempInputArray[0])) {
				boolean marked = false;
				int numberOfNeighbors = neighborList.size();

				City city = new City(numberOfNeighbors, tempCityName,
						neighborList, marked);
				cityList.add(city);

				// If the neighbor city stored in the array index[1] exists
				// create a new child neighbor city object and add it to the
				// neighbor list.
				if (!tempInputArray[1].contains("null")) {
					boolean markedVisited = false;
					String tempNeighborCity = tempInputArray[1];
					City neighborCity = new City(tempNeighborCity,
							markedVisited);
					neighborList = new LinkedList<City>();
					neighborList.add(neighborCity);
				}

			}

			// If the previous city name IS the same as the current city in the
			// array,
			// then create do not create a new parent city but create a new
			// neighbor object
			// and push to the neighbor list.
			else {
				boolean markedVisited = false;
				String tempNeighborCity = tempInputArray[1];
				City neighborCity = new City(tempNeighborCity, markedVisited);
				neighborList.add(neighborCity);

			}

			tempCityName = tempInputArray[0];
			line = fileInput.readLine();
			prevTempCity = tempInputArray[0];

			// If no neighbors exist, create a null place holder in the neighbor
			// list
			// for the parent city.
			if (tempInputArray[1].contains("null")) {
				String tempNeighborCity = "null";
				neighborList = new LinkedList();
				neighborList.add(tempNeighborCity);
			}
		}// end of while loop

		boolean marked = false;
		int numberOfNeighbors = neighborList.size();
		City city = new City(numberOfNeighbors, tempCityName, neighborList,
				marked);
		cityList.add(city);

	}// end of createList method

	// method to mark if a city has been visited
	public void markIt(String cityName, boolean visited) {

		for (int j = 0; j < cityList.size(); j++) {
			if (cityName.contains(cityList.get(j).getMainCity()))
				if (cityList.get(j).isMarked() == false)
					cityList.get(j).setMarked(true);
		}
	}

	// Method to return a neighborList as a String variable
	public LinkedList<?> getNeighborList(String cityName) {
		LinkedList<?> neighborList = null;
		int i;
		for (i = 0; i < cityList.size(); i++) {
			if (cityList.get(i).getNeighborList() != null)
				if (cityList.get(i).getMainCity().contains(cityName))
					neighborList = cityList.get(i).getNeighborList();
		}
		return neighborList;
	}

	// Create a method to search through a list of cities and print out a
	// path to a goal city.
	@SuppressWarnings("unchecked")
	public void search(String startPoint, String goalPoint) {

		// Create a stack to push cities into when you visit them
		@SuppressWarnings("rawtypes")
		Stack cityStack = new Stack();

		if (cityList != null) {
			// get a city from the list
			String tempCity = cityList.get(0).getMainCity();
			// push it into the stack
			cityStack.push(tempCity);

			// mark that it has been visited
			markIt(cityList.get(0).getMainCity(), cityList.get(0).isMarked());
			while (!cityStack.empty()) {

				// pop first object in the stack
				String n = (String) cityStack.pop();

				// check if city is goal city or not
				if (n.equals(goalPoint)) {
					System.out.println(n);
					break;

				} else
					System.out.println(n);

				// check if neighboring cities are marked. If they are not, mark
				// them as visited and push into stack

				LinkedList<?> u = getNeighborList(n);
				if (u != null)
					for (int j = u.size(); j > 0; j--) {
						if (u.get(j - 1).equals("null"))
							break;
						if (((City) u.get(j - 1)).isMarked() == false) {
							markIt(((LinkedList<City>) u).get(j - 1)
									.getMainCity(),
									((LinkedList<City>) u).get(j - 1)
											.isMarked());
							((LinkedList<City>) u).get(j - 1).setMarked(true);
							cityStack.push(((LinkedList<City>) u).get(j - 1)
									.getMainCity());

						}// end of if statement

					}// end of for loop

			} // end of stack while loop

		}// end of if

	}// end of depth first search method

}// end of CityList class
