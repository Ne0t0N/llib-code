package com.finitess.code.callbacks;

import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        final String message = "sample message";
        final MessageService messageService = new MessageService();

        final Consumer<String> messageConsumer = new PrintingMessageConsumer();
        messageService.processMessage(message, messageConsumer);

        final Function<String, String> messageFunction = new IdentityFunction();
        final String result = messageService.processMessage(message, messageFunction);
        System.out.println("Identity function result: " + result);
    }
}
