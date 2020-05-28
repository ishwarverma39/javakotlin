package com.livtech

fun main() {
    HellWorld().foo()
    var a = arrayOf(1,2,3)
    a.size
    a.isEmpty()
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