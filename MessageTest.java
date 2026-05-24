package account.creation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MessageTest {

    Message message = new Message();

    @Test
    public void testMessageLengthSuccess() {

        String result =
                message.validateMessageLength(
                        "Hello there"
                );

        assertEquals(
                "Message ready to send.",
                result
        );
    }

    @Test
    public void testMessageHash() {

        String hash =
                message.createMessageHash(
                        1,
                        "Hello World"
                );

        assertEquals(
                "00:1:HELLOWORLD",
                hash
        );
    }

    @Test
    public void testSendMessage() {

        String result =
                message.sentMessage(
                        "Send Message"
                );

        assertEquals(
                "Message successfully sent.",
                result
        );
    }

    @Test
    public void testTotalMessages() {

        message.sentMessage(
                "Send Message"
        );

        message.sentMessage(
                "Send Message"
        );

        assertEquals(
                2,
                message.returnTotalMessages()
        );
    }
}
