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
        var subtractX = false
        var subtractI = false


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

                //if current if bigger than prev
                if(valueOf(string[i]) >valueOf(string[i-1])) {

                    //subtracting X
                    if(string[i-1] == 'X'){
                        subtractX = true
                     //subtracting I
                    }else if(string[i-1] == 'I'){
                        subtractI = true
                    }

                    //if we subtract something other than X or I
                    //or if there is a sequence of more than 2 smaller values before the bigger one
                    //or if we subtract I but not the last element
                    if ((!subtractI && !subtractX) ||
                        ((string[i-1] == 'X' || string[i-1] == 'I') && count>1) ||
                         (subtractI && i!=string.length-1))
                        return false


                //if current is smaller than prev
                }else{

                    if(i>1 && string[i] == string[i-2]){
                        return false
                    }
                }
                //restart count
                count=1
            }

        }

        return true
    }

    //get numeric value of literal c
    fun valueOf(c:Char) = literalValues.getValue(c)
}