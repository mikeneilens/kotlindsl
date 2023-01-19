enum class TimeAdverbs{ago, after}

infix fun Int.days(duration: TimeAdverbs) = when(duration) {
  TimeAdverbs.ago -> println("That's $this days ago")
  TimeAdverbs.after -> println("That's $this days from now")
}

val ago = TimeAdverbs.ago
val after = TimeAdverbs.after
