// import java.util.ArrayList;

public class Passenger{
    
    private String name;

    /**
     * Constructor
     * @param name the name of the passenger
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Adds the passenger to the manifest of a given car and prints out a message about boarding status
     * @param c the car which the passenger is to be added to
     */
    public void boardCar(Car c){
        Boolean hasBoarded = c.addPassenger(this);
        if(!hasBoarded){
            System.out.println("Error: Passenger " + this.name + " cannot board this car because this car is full.");
        }
        else{
            System.out.println("Passenger " + this.name + " has boarded the car.");
        }
    }

    /**
     * Removes the passenger from the manifest of a given car and prints out a message about getting off status
     * @param c the car which the passenger is to be removed from
     */
    public void getOffCar(Car c){
        Boolean gotOff = c.removePassenger(this);
        if(!gotOff){
            System.out.println("Error: Passenger " + this.name + " cannot get off this car because they are not in this car.");
        }
        else{
            System.out.println("Passenger " + this.name + " has gotten off the car.");
        }
    }

    /**
     * Alters the String form of Passenger to be the passenger's name
     * @return String: the passenger's name
     */
    public String toString(){
        return this.name;
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
        // roster.add(new Passenger("Sarah"));
        // roster.add(new Passenger("Liv"));
        // for(int i = 0; i < roster.size(); i++){
        //     System.out.println(roster.get(i));
        //     roster.get(i).boardCar(c);
        // }
        // for(int i = 0; i < roster.size(); i++){
        //     roster.get(i).getOffCar(c);
        // }
    }
}
