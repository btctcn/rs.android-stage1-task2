package subtask6

class Fibonacci {

    // TODO: Complete the following function
    fun productFibonacciSequenceFor(n: Int): IntArray {
        var result = ArrayList<Int>()
        var mul = 0;

        var first = 0;
        var second = 1;
        while(first * second < n){
            var next = first + second;
            first = second;
            second = next;
        }

        return arrayOf(first, second, if(first*second == n)  1 else 0).toIntArray();
    }
}
