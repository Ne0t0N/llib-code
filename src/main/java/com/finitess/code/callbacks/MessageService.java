package com.finitess.code.callbacks;

import java.util.function.Consumer;
import java.util.function.Function;

public class MessageService {

    public void processMessage(final String message, final Consumer<String> messageConsumer) {
        // do work...
        messageConsumer.accept(message);
    }

    public String processMessage(final String message, final Function<String, String> messageFunction) {
        // do work...
        return messageFunction.apply(message);
    }
}
