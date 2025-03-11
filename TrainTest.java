import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class TrainTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    // Engine Tests

    /**
     * Tests whether the engine constructor initializes the fuel type, max fuel level, and current fuel level correctly
     */
    @Test
    public void testEngineConstructor() {
        FuelType expectedFuelType = FuelType.ELECTRIC;
        double expectedCurrentFuel = 100.0;
        double expectedMaxFuel = 200.0;
        Engine testEngine = new Engine(expectedFuelType, expectedCurrentFuel, expectedMaxFuel);
        assertEquals("Testing fuel type initialization", expectedFuelType, testEngine.getFuelType());
        assertEquals("Testing current fuel level initialization", expectedCurrentFuel, testEngine.getCurrentFuel(), 0.0);
        assertEquals("Testing max fuel level initialization", expectedMaxFuel, testEngine.getMaxFuel(), 0.0);
    }

    /**
     * Tests whether the go method decreases the fuel level by the intended amount and tests to make sure the go method
     * never decreases the fuel level below zero.
     */
    @Test
    public void testEngineGo() {
        Engine testEngine = new Engine(FuelType.ELECTRIC, 100.0, 100.0);
        assertTrue(testEngine.go());
        assertEquals(75.0, testEngine.getCurrentFuel(), 0.0);
        testEngine.go();
        testEngine.go();
        testEngine.go();
        assertFalse(testEngine.go());
        assertEquals(0.0, testEngine.getCurrentFuel(), 0.0);
    }

    // Car Tests

    /**
     * Tests if a passenger is successfully added to a car w/ space and if a passenger is not added to a car w/o space in
     * the car class
     */
    @Test
    public void testCarAddPassenger() {
        Car testCar = new Car(1);
        Passenger testPassenger1 = new Passenger("p1");
        Passenger testPassenger2 = new Passenger("p2");
        assertFalse(testCar.boarded(testPassenger1));
        assertTrue(testCar.addPassenger(testPassenger1));
        assertTrue(testCar.boarded(testPassenger1));
        assertFalse(testCar.addPassenger(testPassenger2));
    }

    /**
     * Tests if a passenger is successfully removed from a car with that passenger on board and not successfully removed
     * from a car without that passenger on board in the car class
     */
    @Test
    public void testCarRemovePassenger() {
        Car testCar = new Car(1);
        Passenger testPassenger = new Passenger("test");
        assertFalse(testCar.removePassenger(testPassenger));
        testCar.addPassenger(testPassenger);
        assertTrue(testCar.removePassenger(testPassenger));
    }

    // Passenger Tests

    /**
     * Tests if a passenger is successfully added to a car w/ space and if a passenger is not added to a car w/o space
     * in the passenger class
     */
    @Test
    public void testPassengerBoardCarWithSpace() {
        Passenger testPassenger = new Passenger("test");
        Car testCar = new Car(1);
        testPassenger.boardCar(testCar);
        assertTrue(testCar.boarded(testPassenger));
    }

    /**
     * Tests if a passenger is successfully removed from a car with that passenger on board and not successfully removed
     * from a car without that passenger on board in the passenger class
     */
    @Test
    public void testPassengerBoardCarFull() {
        Passenger testPassenger = new Passenger("test");
        Car testCar = new Car(0);
        testPassenger.boardCar(testCar);
        assertFalse(testCar.boarded(testPassenger));
    }

    // Train Tests

    /**
     * Tests if the train constructor initializes the right number of cars
     */
    @Test
    public void testTrainConstructor() {
        int expectedNumCars = 2;
        Train testTrain = new Train(FuelType.ELECTRIC, 100.0, expectedNumCars, 0);
        assertEquals(testTrain.getCars().size(), expectedNumCars);
    }

    /**
     * Tests if the train has the right number of seats remaining both before and after a passenger has boarded
     */
    @Test
    public void testTrainPassengerCount() {
        Train testTrain = new Train(FuelType.ELECTRIC, 100., 1, 1);
        Passenger testPassenger = new Passenger("test");
        assertEquals(1, testTrain.seatsRemaining());
        testPassenger.boardCar(testTrain.getCar(0));
        assertEquals(0, testTrain.seatsRemaining());
        testPassenger.getOffCar(testTrain.getCar(0));
        assertEquals(1, testTrain.seatsRemaining());
    }

    /**
     * Tests if the train constructor correctly initializes each car's capacity and seats full
     */
    @Test
    public void testTrainGetCar() {
        Train testTrain = new Train(FuelType.ELECTRIC, 100., 1, 2);
        Car testCar = testTrain.getCar(0);
        assertEquals(2, testCar.getCapacity());
        assertEquals(0, (testCar.getCapacity() - testCar.seatsRemaining()));
    }

    /**
     * Tests if the train class correctly prints out the list of all the passengers on all the cars
     */
    @Test
    public void testTrainPrintManifest() {
        System.setOut(new PrintStream(outputStreamCaptor));
        String expectedManifest = "Car 0 Passengers: \np1\nCar 1 Passengers: \nThis car is EMPTY.\nCar 2 Passengers: \np2";
        Train testTrain = new Train(FuelType.ELECTRIC, 100., 3, 1);
        Passenger p1 = new Passenger("p1");
        Passenger p2 = new Passenger("p2");
        testTrain.getCar(0).addPassenger(p1);
        testTrain.getCar(2).addPassenger(p2);
        testTrain.printManifest();
        assertEquals(expectedManifest, outputStreamCaptor.toString().trim());
        System.setOut(standardOut);
    }
    
}
