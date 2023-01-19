val sales = 8.25
val local = 1.05
object price

object Amount {
    var total = 0
}

object retail {
    infix fun amount(amount: Double) {
        Amount.total = (amount * 100).toInt()
    }
}

object add {
    infix fun tax(amount: Double) {
        Amount.total += (amount / 100.0 * Amount.total).toInt()
    }
}

object compute {
    infix fun total(@Suppress("UNUSED_PARAMETER") prcie: price) = 
    println("Total price is $${Amount.total/100.0}")
}