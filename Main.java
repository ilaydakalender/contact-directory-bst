import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactDirectory directory = new ContactDirectory();
        ContactNode root = null;

        System.out.println("Welcome to the Contact Directory!");
        System.out.println("Available commands:");
        System.out.println("1. ADD name phoneNumber - Add a new contact or update an existing one.");
        System.out.println("2. SEARCH name - Search for a contact by name.");
        System.out.println("3. DELETE name - Delete a contact by name.");
        System.out.println("4. SHOW - Display all contacts in alphabetical order.");
        System.out.println("5. EXIT - Exit the program.");
        System.out.println();

        while (true) {
            System.out.print("> ");
            String inputLine = scanner.nextLine().trim();
            if (inputLine.isEmpty()) {
                System.out.println("No command entered. Please try again.");
                continue;
            }

            String[] input = inputLine.split(" ", 3);
            String command = input[0].toUpperCase();

            switch (command) {
                case "ADD":
                    if (input.length < 3) {
                        System.out.println("Usage: ADD name phoneNumber");
                    } else {
                        root = directory.insertContact(root, input[1], input[2]);
                        System.out.println("Contact added/updated: " + input[1]);
                    }
                    break;

                case "SEARCH":
                    if (input.length < 2) {
                        System.out.println("Usage: SEARCH name");
                    } else {
                        String phone = directory.searchContact(root, input[1]);
                        if (phone != null) {
                            System.out.println("Phone number: " + phone);
                        }
                    }
                    break;

                case "DELETE":
                    if (input.length < 2) {
                        System.out.println("Usage: DELETE name");
                    } else {
                        root = directory.deleteContact(root, input[1]);

                    }
                    break;

                case "SHOW":
                    directory.displayAllContacts(root);
                    break;

                case "EXIT":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Unknown command. Valid commands are ADD, SEARCH, DELETE, SHOW, EXIT.");
            }
        }
    }
}