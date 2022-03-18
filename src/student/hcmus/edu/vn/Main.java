package student.hcmus.edu.vn;

import java.util.Dictionary;
import java.util.Scanner;

public class Main {
    public int enterPositiveNumber() {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.println("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("The entered letter must be a number!");
                System.out.println("Please enter your choice: ");
                scanner.next();
            }

            number = scanner.nextInt();
            scanner.nextLine();
            if (number < 0) {
                System.out.println("You must enter the positive number, try again");
            }
        } while (number < 0);
        return number;
    }
    public static void main(String[] args) {
        Main main = new Main();
        //load data from txt file


        System.out.println("======================DICTIONARY===========================");
        System.out.println("0. Exit");
        System.out.println("1. Search slang word");
        System.out.println("2. Search slang word by definition");
        System.out.println("3. Show history");
        System.out.println("4. Add a slang word");
        System.out.println("5. Edit a slang word");
        System.out.println("6. Delete a slang word");
        System.out.println("7. Reset list of slang words");
        System.out.println("8. On this day slang word");
        System.out.println("9. MSQ about a slang word");
        System.out.println("10. MSQ about a slang word by definition");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choice = main.enterPositiveNumber();

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                default:
                    System.out.println("Bad request, try again!");
            }
        }

    }
}
