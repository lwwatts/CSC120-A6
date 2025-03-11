import java.util.ArrayList;
import java.util.Iterator;

public class Car{

    private int maxCapacity;
    private ArrayList<Passenger> passengersOnBoard;

    /**
     * Constructs a new Car object
     * @param cap the max number of passengers this car can seat
     */
    public Car(int cap){
        this.maxCapacity = cap;
        this.passengersOnBoard = new ArrayList<Passenger>();
    }

    /**
     * An accessor method for the car's passenger capacity
     * @return int: the number of people who can be seated in this car
     */
    public int getCapacity(){
        return this.maxCapacity;
    }

    /**
     * Calculates how many empty seats are in the car
     * @return int: the number of empty seats in the car
     */
    public int seatsRemaining(){
        int seatsFull = this.passengersOnBoard.size();
        return (this.maxCapacity - seatsFull);
    }

    /**
     * Adds a given passenger to the car if the car is not full
     * @param p the passenger to be added to the car
     * @return T/F: whether or not the passenger has boarded the car
     */
    public Boolean addPassenger(Passenger p){
        if(this.seatsRemaining() != 0 && !this.passengersOnBoard.contains(p)){
            this.passengersOnBoard.add(p);
            return true;
        }
        else{
            return false;
        }
        
    }
    
    /**
     * Removes a given passenger from the car if they are in the car
     * @param p the passenger to be removed from the car
     * @return T/F: whether or not the passenger has been removed from the car
     */
    public Boolean removePassenger(Passenger p){
        if(this.passengersOnBoard.contains(p)){
            this.passengersOnBoard.remove(p);
            return true;
        }
        else{
            return false;
        }

    }

    /**
     * Prints out the list of passengers in the car, or prints an empty message if the car is empty
     */
    public void printManifest(){
        if(this.passengersOnBoard.size() != 0){
            Iterator<Passenger> i = passengersOnBoard.iterator();
            while(i.hasNext()){
                System.out.println(i.next());
            }
        }
        else{
            System.out.println("This car is EMPTY.");
        }
    }

    /**
     * Checks whether or not a passenger is on this car
     * @return T/F: whether or not the passenger is in the car's passenger list
     */
    public boolean boarded(Passenger p){
        return this.passengersOnBoard.contains(p);
    }

    public static void main(String[] args) {
        // Car c = new Car(10);
        // ArrayList<Passenger> roster = new ArrayList<>();
        // roster.add(new Passenger("Lucy"));
        // roster.add(new Passenger("M"));
        // roster.add(new Passenger("Frankie"));
        // roster.add(new Passenger("Aidan"));
        // roster.add(new Passenger("Ella"));
        // roster.add(new Passenger("Sriya"));
        // roster.add(new Passenger("Ash"));
        // roster.add(new Passenger("Sreeja"));
        // roster.add(new Passenger("Riva"));
        // roster.add(new Passenger("Liv"));
        // System.out.println("Capacity: " + c.getCapacity());
        // for(int i = 0; i < roster.size(); i++){
        //     System.out.println("Current seats remaining: " + c.seatsRemaining());
        //     roster.get(i).boardCar(c);
        // }
        // System.out.println("\nMANIFEST: ");
        // c.printManifest();
        // for(int i = 0; i < roster.size(); i++){
        //     roster.get(i).getOffCar(c);
        // }
        // System.out.println("\nMANIFEST: ");
        // c.printManifest();
    }

}