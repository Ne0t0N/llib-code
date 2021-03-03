package com.finitess.code.crypto;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

public class SignatureService {

    private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";

    private final KeyPair keyPair;

    public SignatureService(final int keySize, final String cryptoAlgorithm) throws NoSuchAlgorithmException {
        final KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(cryptoAlgorithm);
        keyPairGenerator.initialize(keySize);
        this.keyPair = keyPairGenerator.generateKeyPair();
    }

    public byte[] sign(final String message) throws Exception {
        final Signature sign = Signature.getInstance(SIGNATURE_ALGORITHM);
        sign.initSign(keyPair.getPrivate());
        sign.update(message.getBytes());
        return sign.sign();
    }

    public boolean verify(final String message, final byte[] signedMessage) throws Exception {
        final Signature verify = Signature.getInstance(SIGNATURE_ALGORITHM);
        verify.initVerify(keyPair.getPublic());
        verify.update(message.getBytes());
        return verify.verify(signedMessage);
    }
}
