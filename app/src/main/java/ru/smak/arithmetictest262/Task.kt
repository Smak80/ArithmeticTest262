package ru.smak.arithmetictest262

import kotlin.math.absoluteValue
import kotlin.random.Random

class Task {
    val a: Int
    val b: Int
    val oper: Operator
    init {
        oper = Random.nextInt(Operator.entries.size).let {
            Operator.entries[it]
        }
        when(oper){
            Operator.PLUS,
            Operator.MINUS -> {
                a = Random.nextInt(-100, 100)
                b = Random.nextInt(-100, 100)
            }
            Operator.TIMES -> {
                a = Random.nextInt(-50, 50)
                b = Random.nextInt(100/a.absoluteValue)
            }
            Operator.DIV -> {
                b = Random.nextInt(2, 50)
                val c = 100/b
                a = b * c * if (Random.nextBoolean()) 1 else -1
            }
        }
    }
}