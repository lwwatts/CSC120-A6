import static org.junit.Assert.*;
import org.junit.Test;

public class TrainTest {

    // Engine Tests
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

    @Test
    public void testEngineGo() {
        fail();
    }

    // Car Tests
    @Test
    public void testCarAddPassenger() {
        fail();
    }

    @Test
    public void testCarRemovePassenger() {
        fail();
    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        fail();
    }

    @Test
    public void testPassengerBoardCarFull() {
        fail();
    }

    // Train Tests
    @Test
    public void testTrainConstructor() {
        fail();
    }

    @Test
    public void testTrainPassengerCount() {
        fail();
    }

    @Test
    public void testTrainGetCar() {
        fail();
    }

    @Test
    public void testTrainPrintManifest() {
        fail();
    }
    
}
