package com.finitess.code.callbacks

import java.util.function.Consumer
import java.util.function.Function


class PrintingMessageConsumerKt : Consumer<String> {
    override fun accept(message: String) {
        println("Consumed: $message")
    }
}

class IdentityFunctionKt : Function<String, String> {
    override fun apply(message: String): String = message
}

class MessageServiceKt {
    fun processMessage(message: String, messageConsumer: Consumer<String>) {
        // do work...
        messageConsumer.accept(message)
    }

    fun processMessage(message: String, messageFunction: Function<String, String>): String {
        // do work...
        return messageFunction.apply(message)
    }
}

fun main(args: Array<String>) {
    val message = "sample message"
    val messageService = MessageServiceKt()

    val messageConsumer = PrintingMessageConsumerKt()
    messageService.processMessage(message, messageConsumer)

    val messageFunction = IdentityFunctionKt()
    val result = messageService.processMessage(message, messageFunction)
    println("Identity function result: $result")
}
