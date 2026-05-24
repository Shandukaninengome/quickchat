

import java.util.Random;

public class Message {

    private int totalMessagesSent = 0;

    // Create random message ID
    public String createMessageID() {

        Random random = new Random();

        long number =
                1000000000L
              + (long)(random.nextDouble()
              * 9000000000L);

        return String.valueOf(number);
    }

    // Validate message length
    public String validateMessageLength(
            String message
    ) {

        if (message.length() <= 250) {

            return "Message ready to send.";

        } else {

            int extra =
                    message.length() - 250;

            return "Message exceeds 250 characters by "
                    + extra;
        }
    }

    // Validate recipient number
    public String checkRecipientCell(
            String cellphone
    ) {

        if (cellphone.matches("^\\+27\\d{9}$")) {

            return "Cell phone number successfully captured.";
        }

        return "Cell phone number incorrectly formatted.";
    }

    // Create message hash
    public String createMessageHash(
            int messageNumber,
            String message
    ) {

        String[] words =
                message.split(" ");

        String first =
                words[0].toUpperCase();

        String last =
                words[words.length - 1]
                        .toUpperCase();

        return "00:"
                + messageNumber
                + ":"
                + first
                + last;
    }

    // Send/store/disregard
    public String sentMessage(String option) {

        if (option.equalsIgnoreCase(
                "Send Message")) {

            totalMessagesSent++;

            return "Message successfully sent.";
        }

        if (option.equalsIgnoreCase(
                "Store Message")) {

            return "Message successfully stored.";
        }

        if (option.equalsIgnoreCase(
                "Disregard Message")) {

            return "Message discarded.";
        }

        return "Invalid option selected.";
    }

    // Return total messages
    public int returnTotalMessages() {

        return totalMessagesSent;
    }
}
