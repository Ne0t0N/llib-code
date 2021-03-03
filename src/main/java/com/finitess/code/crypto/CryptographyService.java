package com.finitess.code.crypto;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class CryptographyService {

    private final String cryptoAlgorithm;
    private final KeyPair keyPair;

    public CryptographyService(final int keySize, final String cryptoAlgorithm) throws NoSuchAlgorithmException {
        this.cryptoAlgorithm = cryptoAlgorithm;

        final KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(cryptoAlgorithm);
        keyPairGenerator.initialize(keySize);
        this.keyPair = keyPairGenerator.generateKeyPair();
    }

    public byte[] encrypt(final String message) throws Exception {
        final Cipher cipher = Cipher.getInstance(cryptoAlgorithm);
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        return cipher.doFinal(message.getBytes());
    }

    public String decrypt(final byte[] encryptedMessage) throws Exception {
        final Cipher cipher = Cipher.getInstance(cryptoAlgorithm);
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        return new String(cipher.doFinal(encryptedMessage));
    }
}
