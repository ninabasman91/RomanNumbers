class RomanNumber{


    val literalValues = mapOf<Char, Int>('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100)
    /*
    returns true if a given string represents a valid roman number
     */
    fun isRomanNumber(string:String?) :Boolean{

        if(string==null) return false


        return  areAllRomanChars(string=string) &&
                !moreThanThreeInARow(string=string , c='C') &&
                !moreThanThreeInARow(string=string , c='X') &&
                !moreThanThreeInARow(string=string , c='I') &&
                !moreThanOnce(string=string, c='V') &&
                !moreThanOnce(string=string, c='L') &&
                checkCorrectSequence(string=string)
    }



    /*
    returns if all cahrs in a string are roman literals
     */
    fun areAllRomanChars(string:String):Boolean{

        if (string.isEmpty()) return false

        string.forEach { c->
            if(!literalValues.containsKey(c)) return false
        }
        return true
    }


   /*
   check if a given string contains literal c more than 3 times in a row
    */
    fun moreThanThreeInARow(string:String, c:Char):Boolean{

        var count=0

       string.forEach { ch->

           if(ch == c) count++  else count=0
           if(count>3){
               return true
           }
       }

        return false
    }

    /*
    Check if a given string contains literal c more than once
     */
    fun moreThanOnce(string:String, c:Char) = getCharCount(string=string, c=c) > 1


    //return the count of char c in a given string
    fun getCharCount(string:String, c:Char) = string.count{ch-> ch == c}


    /*
    function returns true if the literals are ordered correctly
     */
    fun checkCorrectSequence(string:String):Boolean{

        if(string.isEmpty() || string.length == 1) return true

        //set max value to be the first literal
        val max = valueOf(string[0])
        var count=1

        val subsMap = mutableMapOf<String,Boolean>("X" to false, "I" to false)

        for(i in 1 until string.length step 1){

            if(i>1 && valueOf(string[i]) > max){
               return false
            }

            //if 2 literal are equal
            if(valueOf(string[i]) == valueOf(string[i-1])){
                count++
            }

            //if not
            else {

                if(!checkBigger(index=i, str=string, count=count, map=subsMap)) return false
                if(!checkSmaller(index=i, str=string)) return false
                //restart count
                count=1
            }

        }

        return true
    }

    //get numeric value of literal c
    fun valueOf(c:Char) = literalValues.getValue(c)


    /*
    check literals positions when current is bigger then previous
     */
    fun checkBigger(index: Int, str: String, count: Int, map: MutableMap<String,Boolean>) : Boolean{

        //if current is bigger than prev
        if(valueOf(str[index]) >valueOf(str[index-1])) {


            //cannot subtract X or I twice
            if((str[index-1] == 'X' && map.getValue("X")) || (str[index-1] == 'I' && map.getValue("I")) ){
                return false
            }

            //mark which literal is being subtracted
           if(str[index-1] == 'X' && !map.getValue("X")){
               map["X"] = true
           }else if(str[index-1] == 'I' && !map.getValue("I")){
               map["I"] = true
           }else{
               return false
           }

            //cannot have more than one smaller value before bigger value
            if((str[index-1] == 'X' || str[index-1] == 'I') && count >1){
                return false
            }

            //if I is being subtracted it must be last subtraction
            if(str[index-1] == 'I' && index != str.length-1){
                return false
            }

        }

        return true

    }

    /*
   check literals positions when current is smaller then previous
    */
    fun checkSmaller(index: Int, str: String) : Boolean{

        //if current is smaller than prev
        if(valueOf(str[index]) < valueOf(str[index-1])) {

            //cannot have 2 same literal near current
            if(index>1 && str[index] == str[index-2]){
                return false
            }
        }

        return true
    }
}