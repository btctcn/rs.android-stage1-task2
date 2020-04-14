package subtask4

class Pangram {

    // TODO: Complete the following function
    fun getResult(inputString: String): String {
        val vowelsSet = hashSetOf("a", "e", "i", "o", "u", "y")
        val consonantsSet = hashSetOf("q", "w", "r", "t", "p", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m")
        var allSet = HashSet<String>()
        val selfSet = HashSet<String>()
        allSet = allSet.union(vowelsSet).union(consonantsSet).toHashSet()

        for (i in 0..inputString.length-1){
            selfSet.add(inputString.substring(i..i).toLowerCase())
        }

        var allSetCopy = allSet.toMutableSet();
        allSetCopy = allSetCopy.minus(selfSet).toHashSet()

        var isPangram  = allSetCopy.count() == 0;
        var tokens = inputString.split(" ").toMutableList()


        for(i in 0..tokens.count()-1){
            var currentToken = tokens[i].trim()
            var toBeCapitalizedSet  = (if(isPangram) vowelsSet else consonantsSet).toMutableSet()
            var iterator = toBeCapitalizedSet.iterator()

            while(iterator.hasNext()) {
                var char = iterator.next()
                currentToken = currentToken.replace(char, char.toUpperCase());
            }

            var counter = 0
            for(j in 0..currentToken.length - 1) {
            var currentChar = currentToken.substring(j..j).toLowerCase();
            if(toBeCapitalizedSet.contains(currentChar)) counter++;
        }

            currentToken = counter.toString()+currentToken
            tokens[i] = currentToken;
        }

        tokens.sortWith(Comparator<String>{a, b ->
            val index1 = a.substring(0..0).toInt()
            val index2 = b.substring(0..0).toInt()
            when{
                index1 < index2 -> -1
                index1 > index2 -> 1
                else -> 0
            }
        });
        // sortedArrayUsingComparator:^NSComparisonResult(id  _Nonnull obj1, id  _Nonnull obj2) {
            /*NSString *str1 = (NSString *)obj1;
            NSString *str2 = (NSString *)obj2;

            int index1 = [[str1 substringWithRange:NSMakeRange(0,1)] intValue];
            int index2 = [[str2 substringWithRange:NSMakeRange(0,1)] intValue];

            if(index1 < index2) return NSOrderedAscending;
            if(index1 > index2) return NSOrderedDescending;

            return NSOrderedSame;
        }];*/
        var result = ""
        for(i in 0..tokens.count() - 1){
            if(tokens[i] == "0") continue;
            result = result + (if(result.length > 0) " " else "") + tokens[i];
        }

        return result;
    }
}
