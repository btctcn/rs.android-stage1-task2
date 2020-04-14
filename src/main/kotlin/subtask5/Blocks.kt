package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        when(blockB){
            Int::class -> {
                var result = 0
                for (i in blockA){
                    if (i is Int){
                        result+=i
                    }
                }
                return result
            }
            String::class -> {
                var result = ""
                for (i in blockA){
                    if (i is String){
                        result+=i
                    }
                }
                return result
            }
            else -> {
                var result = LocalDate.now()
                var check = false
                for (i in blockA) {
                    if (i is LocalDate) {
                        if ((!check) || (i > result)) {
                            check = true
                            result = i
                        }
                    }
                }
                return result.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            }
        }
    }
}
