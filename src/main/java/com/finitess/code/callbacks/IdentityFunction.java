package com.finitess.code.callbacks;

import java.util.function.Function;

public class IdentityFunction implements Function<String, String> {
    @Override
    public String apply(String message) {
        return message;
    }
}
