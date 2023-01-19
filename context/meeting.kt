object schedule {
    infix fun meeting(block: Meeting.() -> Unit) {
        try {
            println(Meeting().apply(block).validate())
        } catch(ex: Exception) {
            println(ex)
        }
    } 
}

class Meeting {
    private val errors = mutableListOf<String>()

    fun validate(): Meeting {
        if (startTime.isEmpty()) {
            errors.add("start time is not set")
        }

        if (endTime.isEmpty()) {
            errors.add("end time is not set")
        }

        if (errors.isNotEmpty()) {
            throw RuntimeException(
                """
                Meeting not set up properly:
                ${errors.joinToString(System.lineSeparator())}
                """.trimMargin()
            )
        }
        return this
    }

    var meetingName = ""
    var startTime = IntRange.EMPTY
    var endTime = IntRange.EMPTY
    var scheduledOn = ""
    var attending = ""

    val assign = this
    val starts = Starts()
    val ends = Ends()
    val on = On()
    val participants = Participants()

    infix fun name(name: String) {
        meetingName = name
    }

    inner class Starts {
        infix fun at(time: IntRange) {
            if(startTime.isEmpty()) {
                errors.add("duplicate start time")
            }
            startTime = time
        }
    }
    inner class Ends {
        infix fun at(time: IntRange) {
            endTime = time
        }
    }
    inner class On {
        infix fun date(day: Int) = 
            DateCreator(day, this@Meeting)
    }
    class DateCreator(val day: Int, val meeting: Meeting) {
        private fun setScheduledOn(month: Int, year: Int) {
            meeting.scheduledOn = java.time.LocalDate.of(year, month, day).toString()
        }
        infix fun January(year: Int) = setScheduledOn(1,year)
        infix fun February(year: Int) = setScheduledOn(2,year)
        infix fun March(year: Int) = setScheduledOn(3,year)
        infix fun April(year: Int) = setScheduledOn(4,year)
        infix fun May(year: Int) = setScheduledOn(5,year)
        infix fun June(year: Int) = setScheduledOn(6,year)
        infix fun July(year: Int) = setScheduledOn(7,year)
        infix fun August(year: Int) = setScheduledOn(8,year)
        infix fun September(year: Int) = setScheduledOn(9,year)
        infix fun October(year: Int) = setScheduledOn(10,year)
        infix fun November(year: Int) = setScheduledOn(11,year)
        infix fun December(year: Int) = setScheduledOn(12,year)
    } 

    inner class Participants {
        infix fun include(name: String): Participants = apply {
            attending = name
        }
        infix fun and(name: String): Participants = apply {
            attending = "$attending, $name"
        }
    }

    override fun toString() = """Meeting:
    $meetingName
    Starts at ${startTime.start}:${startTime.endInclusive}
    Ends at ${endTime.start}:${endTime.endInclusive}
    On $scheduledOn
    Participants: $attending
    """.trimMargin()
}

