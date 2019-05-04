package com.lookslikeitblog.code.crypto;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class CryptographyService {

    private final String cryptoAlgorithm;
    private final KeyPair keyPair;

    public CryptographyService(int keySize, String cryptoAlgorithm) throws NoSuchAlgorithmException {
        this.cryptoAlgorithm = cryptoAlgorithm;

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(cryptoAlgorithm);
        keyPairGenerator.initialize(keySize);
        this.keyPair = keyPairGenerator.generateKeyPair();
    }

    public byte[] encrypt(String message) throws Exception {
        Cipher cipher = Cipher.getInstance(cryptoAlgorithm);
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        return cipher.doFinal(message.getBytes());
    }

    public String decrypt(byte[] encryptedMessage) throws Exception {
        Cipher cipher = Cipher.getInstance(cryptoAlgorithm);
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        return new String(cipher.doFinal(encryptedMessage));
    }
}
