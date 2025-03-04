public class Engine{

    private FuelType f;
    private double maxFuelLevel;
    private double currentFuelLevel;

    /**
     * Constructor
     * @param fuel the type of fuel this engine uses
     * @param currentFuel the amount of fuel that this engine currently has
     * @param maxFuel the max amount of fuel this engine can hold
     */
    public Engine(FuelType fuel, double currentFuel, double maxFuel){
        this.f = fuel;
        this.maxFuelLevel = maxFuel;
        this.currentFuelLevel = currentFuel;
    }

    /**
     * Sets the engine's current fuel level equal to the max fuel level
     */
    public void refuel(){
        this.currentFuelLevel = maxFuelLevel;
    }

    /**
     * Gets the engine's current fuel level
     * @return double: the engine's current fuel level
     */
    public double getCurrentFuel(){
        return this.currentFuelLevel;
    }

    /**
     * Gets the engine's maximum fuel level
     * @return double: the engine's maximum fuel evel
     */
    public double getMaxFuel(){
        return this.maxFuelLevel;
    }

    /**
     * Gets the type of fuel the engine uses
     * @return STEAM/INTERNAL COMBUSTION/ELECTRIC/OTHER: the engine's fuel type
     */
    public FuelType getFuelType(){
        return this.f;
    }

    /**
     * Reduces the current fuel level (if it can), prints some running messages, and checks if there is fuel left
     * @return T/F: whether or not there is fuel left in the engine
     */
    public Boolean go(){ 
        if (this.currentFuelLevel < (this.maxFuelLevel/4)){
            System.out.println("Error: The engine cannot run because there is not enough fuel remaining.");
            return false;
        }
        this.currentFuelLevel -= (this.maxFuelLevel / 4);
        System.out.println("Train is running...");
        System.out.println("Train has completed this trip.");
        System.out.println("Fuel remaining: " + this.currentFuelLevel + " out of " + this.maxFuelLevel);
        if (this.currentFuelLevel == 0){
            return false;
        }
        else{
            return true;
        }
    }

    public static void main(String[] args) {
        // Engine testEngine = new Engine(FuelType.ELECTRIC, 90, 100);
        // System.out.println("Fuel type: " + testEngine.getFuelType());
        // System.out.println("Max Fuel: " + testEngine.getMaxFuel());
        // System.out.println("Current fuel: " + testEngine.getCurrentFuel());
        // testEngine.go();
        // testEngine.go();
        // testEngine.go();
        // testEngine.go();
        // testEngine.refuel();
        // testEngine.go();
        // testEngine.go();
        // testEngine.go();
        // testEngine.go();
        // testEngine.go();
        // testEngine.refuel();
        // System.out.println("Current fuel: " + testEngine.getCurrentFuel());
    }
}