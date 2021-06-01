package com.finitess.code.callbacks

import java.util.function.Consumer
import java.util.function.Function

fun main(args: Array<String>) {
    val message = "sample message"
    val messageService = MessageServiceKt()

    messageService.processMessage(message, Consumer {
        // do work...
        println("Consumed: $message")
    })

    val result = messageService.processMessage(message, Function {
        // do work...
        message
    })
    println("Identity function result: $result")
}