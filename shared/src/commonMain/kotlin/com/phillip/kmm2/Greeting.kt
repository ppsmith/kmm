package com.phillip.kmm2

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}