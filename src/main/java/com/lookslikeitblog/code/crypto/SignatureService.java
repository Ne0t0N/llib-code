package com.lookslikeitblog.code.crypto;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

public class SignatureService {

    private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";

    private final KeyPair keyPair;

    public SignatureService(int keySize, String cryptoAlgorithm) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(cryptoAlgorithm);
        keyPairGenerator.initialize(keySize);
        this.keyPair = keyPairGenerator.generateKeyPair();
    }

    public byte[] sign(String message) throws Exception {
        Signature sign = Signature.getInstance(SIGNATURE_ALGORITHM);
        sign.initSign(keyPair.getPrivate());
        sign.update(message.getBytes());
        return sign.sign();
    }

    public boolean verify(String message, byte[] signedMessage) throws Exception {
        Signature verify = Signature.getInstance(SIGNATURE_ALGORITHM);
        verify.initVerify(keyPair.getPublic());
        verify.update(message.getBytes());
        return verify.verify(signedMessage);
    }
}
