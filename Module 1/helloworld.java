class Vehicle {
    int year;
    String make;
    String model;

    public Vehicle(int year, String make, String model) {
        this.year = year;
        this.make = make;
        this.model = model;
      }

    
    public String describe() {
        return year + " " + make + " " + model;
    }
}

class Garage {
    Vehicle[] vehicles;
    int count;

    public Garage(int cpacity) {
        vehicles = new Vehicle[cpacity];
        count = 0;
    }

    public void addVehicle(Vehicle v) {
        vehicles[count] = v;
        count++;
    }

    public void listVehicles() {
        for (int i = 0; i < count; i++) {
            System.out.println(vehicles[i].describe());
        }
    }
}
public class helloworld {
      public static void main(String[] args) {
          Garage g1 = new Garage(3);

          g1.addVehicle(new Vehicle(2022, "Ford", "Escape"));
          g1.addVehicle(new Vehicle(2026, "Mazda", "Miata"));
          g1.addVehicle(new Vehicle(2022, "Volkswagon", "Beetle"));

          g1.listVehicles();
    }
}