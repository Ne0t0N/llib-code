package com.finitess.code.crypto;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SignatureServiceTest {

    @Test
    public void testSignatureService_positiveFlow() throws Exception {
        SignatureService service = new SignatureService(2048, "RSA");
        String message = "Hello signed world!!!";

        byte[] signedMessage = service.sign(message);
        boolean verificationOutcome = service.verify(message, signedMessage);

        assertTrue(verificationOutcome);
    }

    @Test
    public void whenVerifyingIncorrectMessage_shouldFailVerification() throws Exception {
        SignatureService service = new SignatureService(2048, "RSA");
        String message = "Hello signed world!!!";

        String aString = Stream.generate(() -> "a").limit(256).collect(Collectors.joining());
        boolean verificationOutcome = service.verify(message, aString.getBytes());

        assertFalse(verificationOutcome);
    }
}
