import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            mainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 5) {
                running = false;
                System.out.println("Thank you for using grade management system!");
                System.out.println("Goodbye");
            }
        }
    }

    public static void mainMenu() {
        System.out.println("============================================");
        System.out.println("||    STUDENT GRADE MANAGEMENT SYSTEM     ||");
        System.out.println("============================================");

        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Record Grade");
        System.out.println("4. View Grade Report");
        System.out.println("5. Exit");

        System.out.print("Enter choice: ");
    }
}
