
class Vehicle {
    String brand;
    int speed;

    Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
        System.out.println("Vehicle constructor called");
    }

    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed + " km/h");
    }
}


class Car extends Vehicle {
    int fuelCapacity;

    Car(String brand, int speed, int fuelCapacity) {
        super(brand, speed);   
        this.fuelCapacity = fuelCapacity;
        System.out.println("Car constructor called");
    }

    void displayInfo() {
        super.displayInfo();   
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
    }
}


class ElectricCar extends Car {
    int batteryCapacity;

    ElectricCar(String brand, int speed, int fuelCapacity, int batteryCapacity) {
        super(brand, speed, fuelCapacity);   
        this.batteryCapacity = batteryCapacity;
        System.out.println("ElectricCar constructor called");
    }

    void displayInfo() {
        super.displayInfo();   
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}


public class Lab3 {
    public static void main(String[] args) {
        ElectricCar tesla = new ElectricCar("Tesla", 200, 0, 100);
        System.out.println("\n--- Vehicle Details ---");
        tesla.displayInfo();
    }
}
