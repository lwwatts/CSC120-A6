import java.util.ArrayList;
import java.util.Iterator;

public class Train{

    Engine engine;
    ArrayList<Car> cars;

    /**
     * Constructor for a new Train object
     * @param fuelType the type of fuel the train's engine uses
     * @param fuelCapacity  the maximum amount of fuel the train's engine can hold
     * @param nCars the number of cars that the train has (not including the engine)
     * @param passengerCapacity the number of passengers that each car on the train can hold
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, fuelCapacity, fuelCapacity);
        this.cars = new ArrayList<>();
        for (int i = 0; i < nCars; i ++){
            Car c = new Car(passengerCapacity);
            cars.add(c);
        }
    }
    
    /**
     * An accessor method for the train's engine
     * @return Engine: the engine associated with this train
     */
    public Engine getEngine(){
        return this.engine;
    }

    /**
     * An accessor method for the train's cars
     * @param i the index of the car on the train (where the first car is index 0)
     * @return Car: the car at the given index in this train's list of cars
     */
    public Car getCar(int i){
        return this.cars.get(i);
    }

    /**
     * Determines how many total passengers can be seated on this train
     * @return int: the max number of passengers this train can seat
     */
    public int getMaxCapacity(){
        int capacity = 0;
        Iterator<Car> iter = this.cars.iterator();
        while(iter.hasNext()){
            Car c = iter.next();
            capacity += c.getCapacity();
        }
        return capacity;
    }
    
    /**
     * Determines the number of empty seats left on this train
     * @return int: the sum of all the empty seats in each of this train's cars
     */
    public int seatsRemaining(){
        int seatsLeft = 0;
        Iterator<Car> iter = this.cars.iterator();
        while(iter.hasNext()){
            Car c = iter.next();
            seatsLeft += c.seatsRemaining();
        }
        return seatsLeft;
    }

    /**
     * Prints out the list of cars and their passengers
     */
    public void printManifest(){
        Iterator<Car> iter = this.cars.iterator();
        int count = 0;
        while(iter.hasNext()){
            System.out.println("Car " + count + " Passengers: ");
            count += 1;
            Car c = iter.next();
            c.printManifest();
        }
    }

    public static void main(String[] args){

    }
}
