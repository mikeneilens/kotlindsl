object register {
    infix fun add(op1: Int): AndOp {
        return AndOp(op1)
    }

    class AndOp(val total: Int) {
        infix fun and(op2: Int) {
            println("adding $op2 to $total")
        }
    }
}

register add 4 and 3

//register and 3 add 4 //Error
//register and 3 and 4 //Error
//register add 3 add 4 //Error 