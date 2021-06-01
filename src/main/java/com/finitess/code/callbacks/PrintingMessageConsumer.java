package com.finitess.code.callbacks;

import java.util.function.Consumer;

public class PrintingMessageConsumer implements Consumer<String> {
    @Override
    public void accept(final String message) {
        System.out.println("Consumed: " + message);
    }
}
