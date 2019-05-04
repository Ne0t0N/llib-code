package com.lookslikeitblog.code.crypto;

import org.junit.Test;

import java.security.GeneralSecurityException;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptographyServiceTest {

    @Test
    public void testCryptographyService_positiveFlow() throws Exception {
        CryptographyService service = new CryptographyService(2048, "RSA");
        String message = "Hello cryptography world!!!";

        byte[] encryptedMessage = service.encrypt(message);
        String decryptedMessage = service.decrypt(encryptedMessage);

        assertThat(decryptedMessage).isEqualTo(message);
    }

    @Test(expected = GeneralSecurityException.class)
    public void whenDecryptingNotEncryptedMessage_shouldThrowException() throws Exception {
        CryptographyService service = new CryptographyService(2048, "RSA");
        String message = "Hello cryptography world!!!";

        service.decrypt(message.getBytes());
    }
}
