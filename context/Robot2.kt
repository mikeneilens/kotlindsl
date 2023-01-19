enum class Direction {left, right}
enum class Speed {fast, slow}

object DirectionSpeedReceiver {
    val left = Direction.left
    val right = Direction.right
    val fast = Speed.fast
}

class Robot {
    infix fun turns(direction: Direction) = 
    println("Robot turns $direction")
   
    infix fun runs(speed: Speed) = 
    println("Robot runs $speed")

    companion object {
        infix fun operate(instructions: DirectionSpeedReceiver.(Robot) -> Unit ) =
            Robot().run {
                DirectionSpeedReceiver.instructions(this)                
            }
    }
}