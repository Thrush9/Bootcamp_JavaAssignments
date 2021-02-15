package com.stackroute.oops;

public class VehicleService {
	/*
	 * create a Car object and return it
	 */
	public Car createCar(String name, String modelName, String type) {
		Car carobj = new Car(name, modelName, type);
		return carobj;
	}

	/*
	 * create a bike object and return it
	 */
	public Bike createBike(String name, String modelName, String type) {
		Bike bikeobj = new Bike(name, modelName, type);
		return bikeobj;
	}

	/*
	 * Method should compare the speed only if the vehicle is of "SPORTS" type.
	 * Method should return 0 when speeds are equal otherwise should return maximum
	 * vehicle speed. Method returns -1 if the type is not "SPORTS"
	 */
	public int compareMaxSpeed(Vehicle first, Vehicle second) {
		Car one = (Car) first;
		Bike two = (Bike) second;
		if (one.getType().toLowerCase().equals("sports") && two.getType().toLowerCase().equals("sports")) {
			if (first.maxSpeed(one.getType().toLowerCase()) == second.maxSpeed(two.getType().toLowerCase())) {
				return 0;
			} else {
				return Math.max(first.maxSpeed(one.getType().toLowerCase()),
						second.maxSpeed(two.getType().toLowerCase()));
			}
		} else
			return -1;

	}
}
