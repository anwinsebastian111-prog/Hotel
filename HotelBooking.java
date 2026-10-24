import java.util.Scanner;

public class HotelBooking {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Room details
    String[] roomType = {"Single", "Double", "Deluxe"};
    int[] roomPrice = {1500, 2500, 4000};
    boolean[] booked = {false, false, false};

    System.out.println("--------------------------------");
    System.out.println("        HOTEL ROOM BOOKING      ");
    System.out.println("--------------------------------");

    System.out.println("\nAvailable Rooms:");

    for (int i = 0; i < roomType.length; i++) {
      System.out.println((i + 1) + ". " + roomType[i]
          + " - Rs." + roomPrice[i]
          + " per night");
    }

    // Customer details
    System.out.print("\nEnter customer name: ");
    String name = sc.nextLine();

    System.out.print("Choose room (1-3): ");
    int choice = sc.nextInt();

    // Check valid room
    if (choice < 1 || choice > 3) {
      System.out.println("Invalid room choice!");
      sc.close();
      return;
    }

    int roomIndex = choice - 1;

    // Check whether room is already booked
    if (booked[roomIndex]) {
      System.out.println("Sorry! This room is already booked.");
    } else {

      System.out.print("Enter number of nights: ");
      int nights = sc.nextInt();

      if (nights <= 0) {
        System.out.println("Invalid number of nights!");
      } else {

        // Calculate bill
        int total = roomPrice[roomIndex] * nights;

        // Mark room as booked
        booked[roomIndex] = true;

        System.out.println("\n--------------------------------");
        System.out.println("         BOOKING CONFIRMED      ");
        System.out.println("--------------------------------");

        System.out.println("Customer Name    : " + name);
        System.out.println("Room Type        : " + roomType[roomIndex]);
        System.out.println("Price/Night      : Rs." + roomPrice[roomIndex]);
        System.out.println("Number of Nights : " + nights);
        System.out.println("Total Amount     : Rs." + total);

        System.out.println("\nThank you for booking with us!");
      }
    }

    sc.close();
  }
}