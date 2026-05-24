package accountcreation;

import java.util.Scanner;

public class QuickChat {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Login login = new Login();

        System.out.println("===== QUICKCHAT REGISTRATION =====");

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter cellphone number (+27): ");
        String cellphone = input.nextLine();

        String registration =
                login.registerUser(
                        username,
                        password,
                        cellphone
                );

        System.out.println(registration);

        if (registration.equals("User registered successfully.")) {

            System.out.println("\n===== LOGIN =====");

            System.out.print("Username: ");
            String loginUser = input.nextLine();

            System.out.print("Password: ");
            String loginPassword = input.nextLine();

            boolean loginStatus =
                    login.loginUser(
                            loginUser,
                            loginPassword
                    );

            System.out.println(
                    login.returnLoginStatus(
                            loginStatus,
                            loginUser
                    )
            );

            if (loginStatus) {

                Message messageApp = new Message();

                boolean running = true;

                while (running) {

                    System.out.println("\nChoose an option:");
                    System.out.println("1. Send Messages");
                    System.out.println("2. Show recently sent messages");
                    System.out.println("3. Quit");

                    String menu = input.nextLine();

                    if (menu.equals("1")) {

                        System.out.print(
                                "Enter recipient cellphone number: "
                        );

                        String recipient =
                                input.nextLine();

                        System.out.println(
                                messageApp.checkRecipientCell(
                                        recipient
                                )
                        );

                        System.out.print("Enter message: ");

                        String message =
                                input.nextLine();

                        System.out.println(
                                messageApp.validateMessageLength(
                                        message
                                )
                        );

                        String hash =
                                messageApp.createMessageHash(
                                        messageApp.returnTotalMessages() + 1,
                                        message
                                );

                        System.out.println(
                                "Message Hash: " + hash
                        );

                        System.out.println(
                                "Choose option: "
                              + "Send Message / "
                              + "Disregard Message / "
                              + "Store Message"
                        );

                        String option =
                                input.nextLine();

                        System.out.println(
                                messageApp.sentMessage(option)
                        );

                    } else if (menu.equals("2")) {

                        System.out.println(
                                "Coming Soon."
                        );

                    } else if (menu.equals("3")) {

                        System.out.println(
                                "Total messages sent: "
                              + messageApp.returnTotalMessages()
                        );

                        running = false;

                    } else {

                        System.out.println(
                                "Invalid option selected."
                        );
                    }
                }
            }
        }

        input.close();
    }
}
