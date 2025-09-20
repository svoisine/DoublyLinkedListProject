import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 *  Class DoublyLinkedListDriver
 * 
 *  This class runs the Linked List program.
 * 
 *  Name: Seth Voisine
 *  UGA ID: 811906637
 *  Date: 09/02/2025
 */
public class DoublyLinkedListDriver {

    /*
     * This is the main method that runs the program.
     * This method takes in a user inputed file and reads the file.
     * The file should contain a list of strings seperated via a " ".
     * The method will also error check any problems with the input file.
     * The method then takes user inputs and performs different actions on
     * the lists as found in the DoublyLinkedLists.java class. While taking
     * a users input via the command line it also error checks to make sure the
     * user input is valid.
     * 
     * param - String[] args
     * 
     * @return - void
     */
    public static void main(String[] args) {
        // Check args length for the file input
        if (args.length != 1) {
            System.err.println("user Input: java DoublyLinkedListDriver <inputfile.txt>");
            return;
        }

        // Get the file
        String fileName = args[0];
        File inputFile = new File(fileName);
        Scanner scanner;

        // Use try catch block to add a FileNotFound error check to the program
        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.err.println("File not Found: " + fileName);
            return;
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Enter list type (i - int, d - double, s - string): ");
        String userChoice = input.nextLine().trim();

        if (userChoice.equals("i")) {
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
            while (scanner.hasNextInt()) {
                list.insertItem(scanner.nextInt());
            }

            // Prompt user
            System.out.println("Commands: ");
            System.out.println("(i) - Insert value");
            System.out.println("(d) - Delete value");
            System.out.println("(p) - Print list");
            System.out.println("(l) - Length");
            System.out.println("(t) - Print reverse");
            System.out.println("(r) - Reverse list");
            System.out.println("(b) - Delete Subsection");
            System.out.println("(s) - Swap Alternate");
            System.out.println("(q) - Quit program");

            boolean running = true;
            Scanner userInput = new Scanner(System.in);

            // loop through user input
            while (running) {
                System.out.print("Enter a command: ");
                String cmd = userInput.nextLine().trim();

                switch (cmd) {
                    case "i":
                        System.out.print("The list is: ");
                        list.print();
                        System.out.print("Enter a number to insert: ");
                        if (userInput.hasNextInt()) {
                            int value = userInput.nextInt();
                            list.insertItem(value);
                            userInput.nextLine();
                            System.out.print("The list is: ");
                            list.print();
                            System.out.print("The reverse list : ");
                            list.printReverse();
                        } else {
                            System.out.println("Invalid input. Please enter an integer. ");
                            userInput.nextLine();
                        }
                        break;

                    case "d":
                        System.out.print("The list is: ");
                        list.print();
                        System.out.print("Enter a number to delete: ");
                        if (userInput.hasNextInt()) {
                            int value = userInput.nextInt();
                            list.deleteItem(value);
                            userInput.nextLine();
                            System.out.print("The list is: ");
                            list.print();
                            System.out.print("The reverse list : ");
                            list.printReverse();
                        } else {
                            System.out.print("Invalid input. Please enter an integer. ");
                            userInput.nextLine();
                        }
                        break;
                    case "p":
                        System.out.print("The list is: ");
                        list.print();
                        break;
                    case "l":
                        System.out.println("The length of the list is " + list.length());
                        break;
                    case "t":
                        System.out.print("The reverse list: ");
                        list.printReverse();
                        break;
                    case "r":
                        System.out.print("The original list: ");
                        list.print();
                        list.reverseList();
                        System.out.print("The reversed list is: ");
                        list.print();
                        break;
                    case "b":
                        int lowerBound = -1;
                        int upperBound = -1;

                        System.out.print("Enter the lower bound: ");
                        if (userInput.hasNextInt()) {
                            lowerBound = userInput.nextInt();
                            userInput.nextLine();
                        } else {
                            System.out.println("Invalid input. Please enter an integer. ");
                            userInput.nextLine();
                        }

                        System.out.print("Enter the upper bound: ");
                        if (userInput.hasNextInt()) {
                            upperBound = userInput.nextInt();
                            userInput.nextLine();
                        } else {
                            System.out.println("Invalid input. Please enter an integer. ");
                            userInput.nextLine();
                        }

                        if (lowerBound != -1 && upperBound != -1 && lowerBound <= upperBound) {
                            System.out.print("The original list: ");
                            list.print();
                            list.deleteSubsection(lowerBound, upperBound);
                            System.out.print("The modified list: ");
                            list.print();
                            System.out.print("The reverse list: ");
                            list.printReverse();
                        } else {
                            System.out.println("Invalid input. Lower bound needs to be <= the Upper bound. ");
                        }
                        break;
                    case "s":
                        System.out.print("The original list: ");
                        list.print();
                        list.swapAlternate();
                        System.out.print("The modified list: ");
                        list.print();
                        break;
                    case "q":
                        running = false;
                        break;
                }
            }
            userInput.close();
        } else if (userChoice.equals("d")) {
            DoublyLinkedList<Double> list = new DoublyLinkedList<>();
            while (scanner.hasNextDouble()) {
                list.insertItem(scanner.nextDouble());
            }

            // Prompt user
            System.out.println("Commands: ");
            System.out.println("(i) - Insert value");
            System.out.println("(d) - Delete value");
            System.out.println("(p) - Print list");
            System.out.println("(l) - Length");
            System.out.println("(t) - Print reverse");
            System.out.println("(r) - Reverse list");
            System.out.println("(b) - Delete Subsection");
            System.out.println("(s) - Swap Alternate");
            System.out.println("(q) - Quit program");

            boolean running = true;
            Scanner userInput = new Scanner(System.in);

            // loop through user input
            while (running) {
                System.out.print("Enter a command: ");
                String cmd = userInput.nextLine().trim();

                switch (cmd) {
                    case "i":
                        System.out.print("The list is: ");
                        list.print();
                        System.out.print("Enter a number to insert: ");
                        if (userInput.hasNextDouble()) {
                            double value = userInput.nextDouble();
                            list.insertItem(value);
                            userInput.nextLine();
                            System.out.print("The list is: ");
                            list.print();
                            System.out.print("The reverse list : ");
                            list.printReverse();
                        } else {
                            System.out.println("Invalid input. Please enter a double value. ");
                            userInput.nextLine();
                        }
                        break;

                    case "d":
                        System.out.print("The list is: ");
                        list.print();
                        System.out.print("Enter a number to delete: ");
                        if (userInput.hasNextDouble()) {
                            double value = userInput.nextDouble();
                            list.deleteItem(value);
                            userInput.nextLine();
                            System.out.print("The list is: ");
                            list.print();
                            System.out.print("The reverse list : ");
                            list.printReverse();
                        } else {
                            System.out.print("Invalid input. Please enter a double value. ");
                            userInput.nextLine();
                        }
                        break;
                    case "p":
                        System.out.print("The list is: ");
                        list.print();
                        break;
                    case "l":
                        System.out.println("The length of the list is " + list.length());
                        break;
                    case "t":
                        System.out.print("The reverse list: ");
                        list.printReverse();
                        break;
                    case "r":
                        System.out.print("The original list: ");
                        list.print();
                        list.reverseList();
                        System.out.print("The reverse list is: ");
                        list.print();
                        break;
                    case "b":
                        double lowerBound = -1;
                        double upperBound = -1;

                        System.out.print("Enter the lower bound: ");
                        if (userInput.hasNextDouble()) {
                            lowerBound = userInput.nextDouble();
                            userInput.nextLine();
                        } else {
                            System.out.println("Invalid input. Please enter a double value. ");
                            userInput.nextLine();
                        }

                        System.out.print("Enter the upper bound: ");
                        if (userInput.hasNextDouble()) {
                            upperBound = userInput.nextDouble();
                            userInput.nextLine();
                        } else {
                            System.out.println("Invalid input. Please enter a double value. ");
                            userInput.nextLine();
                        }

                        if (lowerBound != -1 && upperBound != -1 && lowerBound <= upperBound) {
                            System.out.print("The original list: ");
                            list.print();
                            list.deleteSubsection(lowerBound, upperBound);
                            System.out.print("The modified list: ");
                            list.print();
                            System.out.print("The reverse list: ");
                            list.printReverse();
                        } else {
                            System.out.println("Invalid input. Lower bound needs to be <= the Upper bound. ");
                        }
                        break;
                    case "s":
                        System.out.print("The original list: ");
                        list.print();
                        list.swapAlternate();
                        System.out.print("The modified list: ");
                        list.print();
                        break;
                    case "q":
                        running = false;
                        break;
                }
            }
            userInput.close();
        } else if (userChoice.equals("s")) {
            DoublyLinkedList<String> list = new DoublyLinkedList<>();
            while (scanner.hasNext()) {
                list.insertItem(scanner.next());
            }

            // Prompt user
            System.out.println("Commands: ");
            System.out.println("(i) - Insert value");
            System.out.println("(d) - Delete value");
            System.out.println("(p) - Print list");
            System.out.println("(l) - Length");
            System.out.println("(t) - Print reverse");
            System.out.println("(r) - Reverse list");
            System.out.println("(b) - Delete Subsection");
            System.out.println("(s) - Swap Alternate");
            System.out.println("(q) - Quit program");

            boolean running = true;
            Scanner userInput = new Scanner(System.in);

            // loop through user input
            while (running) {
                System.out.print("Enter a command: ");
                String cmd = userInput.nextLine().trim();

                switch (cmd) {
                    case "i":
                        System.out.print("The list is: ");
                        list.print();
                        System.out.print("Enter a string to insert: ");
                        if (userInput.hasNext()) {
                            String value = userInput.next();
                            list.insertItem(value);
                            userInput.nextLine();
                            System.out.print("The list is: ");
                            list.print();
                            System.out.print("The reverse list : ");
                            list.printReverse();
                        }
                        break;

                    case "d":
                        System.out.print("The list is: ");
                        list.print();
                        System.out.print("Enter a string to delete: ");
                        if (userInput.hasNext()) {
                            String value = userInput.next();
                            list.deleteItem(value);
                            userInput.nextLine();
                            System.out.print("The list is: ");
                            list.print();
                            System.out.print("The reverse list : ");
                            list.printReverse();
                        }
                        break;
                    case "p":
                        System.out.print("The list is: ");
                        list.print();
                        break;
                    case "l":
                        System.out.println("The length of the list is " + list.length());
                        break;
                    case "t":
                        System.out.print("The reverse list: ");
                        list.printReverse();
                        break;
                    case "r":
                        System.out.print("The original list: ");
                        list.print();
                        list.reverseList();
                        System.out.print("The reversed list is: ");
                        list.print();
                        break;
                    case "b":
                        String lowerBound = "";
                        String upperBound = "";

                        System.out.print("Enter the lower bound: ");
                        if (userInput.hasNext()) {
                            lowerBound = userInput.next();
                            userInput.nextLine();
                        }

                        System.out.print("Enter the upper bound: ");
                        if (userInput.hasNext()) {
                            upperBound = userInput.next();
                            userInput.nextLine();
                        }

                        if (lowerBound != "" && upperBound != "" && lowerBound.compareTo(lowerBound) <= 0) {
                            System.out.print("The original list: ");
                            list.print();
                            list.deleteSubsection(lowerBound, upperBound);
                            System.out.print("The modified list: ");
                            list.print();
                            System.out.print("The reverse list: ");
                            list.printReverse();
                        } else {
                            System.out.println("Invalid input. Lower bound needs to be <= the Upper bound. ");
                        }
                        break;
                    case "s":
                        System.out.print("The original list: ");
                        list.print();
                        list.swapAlternate();
                        System.out.print("The modified list: ");
                        list.print();
                        break;
                    case "q":
                        running = false;
                        break;
                }
            }
            userInput.close();
        } else {
            System.out.println("Invalid type selected. Exiting.");
            scanner.close();
            input.close();
        }

        scanner.close();
        input.close();

        System.out.println("Exiting the program...");
    }
}
