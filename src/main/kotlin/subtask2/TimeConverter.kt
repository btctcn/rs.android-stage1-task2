package subtask2

class TimeConverter {

    // TODO: Complete the following function
    fun toTextFormat(hour: String, minute: String): String {
        val hoursInt:Int = hour.toInt()
        val minutesInt:Int = minute.toInt()

        if(hoursInt < 0 || hoursInt > 23 || minutesInt < 0 || minutesInt > 59) return ""

        if(minutesInt == 0) {
            return converToWords(hoursInt) + " o' clock"
        }

        if(minutesInt == 15) {
            return  "quarter past " + converToWords(hoursInt)
        }

        if(minutesInt == 30) {
            return "half past " + converToWords(hoursInt)
        }

        if(minutesInt == 45) {
            return "quarter to " + converToWords((hoursInt + 1) % 24)
        }

        val minute = converToWords (if(minutesInt < 30) minutesInt else 60 - minutesInt)
        val hour = converToWords(hoursInt + (if(minutesInt < 30)  0 else 1) % 24)
        return java.lang.String.format("%s minutes %s %s", minute, if(minutesInt < 30) "past" else "to", hour);
    }

    fun converToWords(value:Int): String? {
        val tens = value  / 10;
        val ones = if (tens > 0) value % (tens * 10) else value;

        val onesDict = hashMapOf(
            0 to "zero",
            1 to "one",
            2 to "two",
            3 to "three",
            4 to "four",
            5 to "five",
            6 to "six",
            7 to "seven",
            8 to "eight",
            9 to "nine")

        val tenDict = hashMapOf(
            1 to "ten",
            2 to "twenty",
            3 to "thirty",
            4 to "fourty",
            5 to "fifty",
            6 to "sixty");

        val teenDict = hashMapOf(
            11 to "eleven",
            12 to "twelve",
            13 to "thirteen",
            14 to "fourteen",
            15 to "fifteen",
            16 to "sixteen",
            17 to "seventeen",
            18 to "eighteen",
            19 to "nineteen")

        if(tens >= 2)
        {
            return tenDict[tens] + " " + onesDict[ones]
        }

        if(tens == 1)
        {
            return teenDict[10 + ones]
        }

        return onesDict[ones]
    }
}
