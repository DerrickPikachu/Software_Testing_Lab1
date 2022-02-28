import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    private Vehicle slowVehicle;
    private Vehicle fastVehicle;
    private int fastVehicleSpeed = 100;
    private String fastVehicleDirection = "south";

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        slowVehicle = new Vehicle();
        fastVehicle = new Vehicle(fastVehicleSpeed, fastVehicleDirection);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        slowVehicle.finalize();
        fastVehicle.finalize();
    }

    @org.junit.jupiter.api.Test
    void testFinalize() {
        Vehicle testVehicle = new Vehicle(555, "east");
        int totalVehicle = Vehicle.totalVehicle();
        testVehicle.finalize();
        assertEquals(totalVehicle - 1, Vehicle.totalVehicle());
    }

    @org.junit.jupiter.api.Test
    void setSpeed() {
        slowVehicle.setSpeed(fastVehicleSpeed);
        assertEquals(fastVehicleSpeed, slowVehicle.getSpeed());
    }

    @org.junit.jupiter.api.Test
    void setDir() {
        String newDirection = "east";
        slowVehicle.setDir(newDirection);
        assertEquals(newDirection, slowVehicle.getDir());
    }

    @org.junit.jupiter.api.Test
    void getSpeed() {
        assertEquals(fastVehicleSpeed, fastVehicle.getSpeed());
        assertEquals(0, slowVehicle.getSpeed());
    }

    @org.junit.jupiter.api.Test
    void getDir() {
        assertEquals(fastVehicleDirection, fastVehicle.getDir());
        assertEquals("north", slowVehicle.getDir());
    }

    @org.junit.jupiter.api.Test
    void totalVehicle() {
        assertEquals(2, Vehicle.totalVehicle());
    }
}