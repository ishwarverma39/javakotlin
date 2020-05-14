package com.livtech

fun main() {
    HellWorld().foo()
}

class HellWorld {
    fun foo() {
        println("Hello Kotlin")
        println("Foo")
        ArrayList<String>().apply {
            add("Ishwar")
            add("Verma")
        }.let {
            print(it)
        }
    }
}