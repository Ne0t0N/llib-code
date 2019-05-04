package com.lookslikeitblog.code.crypto;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SignatureServiceTest {

    @Test
    public void testSignatureService_positiveFlow() throws Exception {
        SignatureService service = new SignatureService(2048, "RSA");
        String message = "Hello signed world!!!";

        byte[] signedMessage = service.sign(message);
        boolean verificationOutcome = service.verify(message, signedMessage);

        assertThat(verificationOutcome).isTrue();
    }

    @Test
    public void whenVerifyingIncorrectMessage_shouldFailVerification() throws Exception {
        SignatureService service = new SignatureService(2048, "RSA");
        String message = "Hello signed world!!!";

        boolean verificationOutcome = service.verify(message, aString(256).getBytes());

        assertThat(verificationOutcome).isFalse();
    }

    private static String aString(int length) {
        return Stream.generate(() -> "a").limit(length).collect(Collectors.joining());
    }
}
