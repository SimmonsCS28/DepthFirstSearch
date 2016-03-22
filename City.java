package DepthFirstSearch;

import java.util.LinkedList;

public class City {
	private int numberOfNeighbors;
	private String mainCity;
	private LinkedList<String> neighborList;
	private boolean marked = false;
	

	public City(int numberOfNeighbors, String mainCity,
			LinkedList<String> neighborList, boolean marked) {
		super();
		this.numberOfNeighbors = numberOfNeighbors;
		this.mainCity = mainCity;
		this.neighborList = neighborList;
		this.marked = marked;
	}

	public City(String mainCity, boolean marked){
		this.mainCity = mainCity;
		this.marked = marked;
	}

	public int getNumberOfNeighbors() {
		return numberOfNeighbors;
	}

	public void setNumberOfNeighbors(int numberOfNeighbors) {
		this.numberOfNeighbors = numberOfNeighbors;
	}

	public String getMainCity() {
		return mainCity;
	}

	public void setMainCity(String mainCity) {
		this.mainCity = mainCity;
	}

	public LinkedList<String> getNeighborList() {
		return neighborList;
	}

	public void setNeighborList(LinkedList<String> neighborList) {
		this.neighborList = neighborList;
	}

	public boolean isMarked() {
		return marked;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}

}
