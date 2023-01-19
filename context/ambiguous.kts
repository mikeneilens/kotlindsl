object register {
    var total = 0

    infix fun add(op1: Int): register {
        total += op1
        return register
    }
    infix fun and(op2: Int) {
        println("adding $op2 to $total")
        total += op2
    }
}

register add 4 and 3

//register and 3 and 4 //Error
//register and 3 and 4 //Error
register add 3 add 4 //oops