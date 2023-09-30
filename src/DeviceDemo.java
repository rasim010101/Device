import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DeviceDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the number of devices (1-20): ");
        int numDevices = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (numDevices < 1 || numDevices > 20) {
            System.out.println("Invalid input. Please enter a number between 1 and 20.");
            return;
        }

        ArrayList<Device> devices = new ArrayList<>();

        for (int i = 0; i < numDevices; i++) {
            // Generate random device type
            String[] deviceTypes = {"Smartphone", "Laptop", "Tablet"};
            String randomType = deviceTypes[random.nextInt(deviceTypes.length)];

            // Generate random price and weight
            double randomPrice = 100 + random.nextDouble() * 900; // Price between 100 and 1000 USD
            double randomWeight = 300 + random.nextDouble() * 1700; // Weight between 300 and 2000 grams

            // Create instances of derived classes
            if (randomType.equals("Smartphone")) {
                double randomScreenSize = 4 + random.nextDouble() * 3; // Screen size between 4 and 7 inches
                int randomCameraResolution = 8 + random.nextInt(13); // Camera resolution between 8 and 20 MP
                devices.add(new Smartphone(randomType, randomPrice, randomWeight, randomScreenSize, randomCameraResolution));
            } else if (randomType.equals("Laptop")) {
                String[] processors = {"Intel Core i5", "Intel Core i7", "AMD Ryzen 7"};
                String randomProcessor = processors[random.nextInt(processors.length)];
                int randomRamSize = 4 + random.nextInt(9); // RAM size between 4 and 12 GB
                devices.add(new Laptop(randomType, randomPrice, randomWeight, randomProcessor, randomRamSize));
            } else if (randomType.equals("Tablet")) {
                String[] operatingSystems = {"Android", "iOS", "Windows"};
                String randomOs = operatingSystems[random.nextInt(operatingSystems.length)];
                boolean randomHasStylus = random.nextBoolean();
                devices.add(new Tablet(randomType, randomPrice, randomWeight, randomOs, randomHasStylus));
            }
        }

        // Calculate and display information
        System.out.println("Generated Devices:");
        double totalPrice = 0;
        double totalWeight = 0;
        ArrayList<String> distinctTypes = new ArrayList<>();

        for (Device device : devices) {
            System.out.println("Type: " + device.getType());
            System.out.println("Price: $" + device.getPrice());
            System.out.println("Weight: " + device.getWeight() + " grams");
            System.out.println();

            totalPrice += device.getPrice();
            totalWeight += device.getWeight();

            if (!distinctTypes.contains(device.getType())) {
                distinctTypes.add(device.getType());
            }
        }

        System.out.println("Number of distinct device types created: " + distinctTypes.size());
        System.out.println("Total price of all devices: $" + totalPrice);
        System.out.println("Total weight of all devices: " + totalWeight + " grams");
    }
}