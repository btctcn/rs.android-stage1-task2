package subtask3

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {
        val a = a.toLowerCase()
        val b = b.toLowerCase()

        var setA : HashSet<String> = HashSet();
        val setB : HashSet<String> = HashSet();
        var setDiff : HashSet<String> = HashSet();

        var arrayA : ArrayList<String> = ArrayList()

        val lenA  = a.length
        val lenB  = b.length

        for(i in 0..lenA-1){
            val ch = a.substring(i..i)
            setA.add(ch)
            arrayA.add(ch)
        }

        for(i in 0..lenB-1){
            setB.add(b.substring(i..i))
        }

        setDiff = setA
        setDiff = setDiff.minus(setB).toHashSet()
        arrayA.removeAll(setDiff)

        return if(arrayA.joinToString("") == b) "YES" else "NO"
    }
}
