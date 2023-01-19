import java.time.*

val begin = LocalDate.of(2020,2,15)
val end = LocalDate.of(2020,9,30)

val January = java.time.Month.JANUARY
val February = java.time.Month.FEBRUARY
val March = java.time.Month.MARCH
val April = java.time.Month.APRIL
val May = java.time.Month.MAY
val June = java.time.Month.JUNE
val July = java.time.Month.JULY
val August = java.time.Month.AUGUST
val September = java.time.Month.SEPTEMBER
val October = java.time.Month.OCTOBER
val November = java.time.Month.NOVEMBER
val December = java.time.Month.DECEMBER

operator fun ClosedRange<LocalDate>.contains(month: java.time.Month) = 
month.value >= start.month.value && month.value <= endInclusive.month.value

fun print(result: Any) = println(result)

operator fun LocalDate.minus(other: LocalDate) {
    Period.between(this, other).apply {
        println("$years years $months months $days days")
    }
}