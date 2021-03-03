package com.finitess.code.crypto;


import org.junit.jupiter.api.Test;

import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CryptographyServiceTest {

    @Test
    public void testCryptographyService_positiveFlow() throws Exception {
        CryptographyService service = new CryptographyService(2048, "RSA");
        String message = "Hello cryptography world!!!";

        byte[] encryptedMessage = service.encrypt(message);
        String decryptedMessage = service.decrypt(encryptedMessage);

        assertEquals(message, decryptedMessage);
    }

    @Test
    public void whenDecryptingNotEncryptedMessage_shouldThrowException() {
        assertThrows(GeneralSecurityException.class, () -> {
            CryptographyService service = new CryptographyService(2048, "RSA");
            String message = "Hello cryptography world!!!";

            service.decrypt(message.getBytes());
        });
    }
}
