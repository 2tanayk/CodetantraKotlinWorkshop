// 1) Main function in kotlin

/*
- The main() function in Kotlin is the entry point to a Kotlin program.
- Kotlin supports both procedural programming and object oriented programming.Hence
it does enforce OOP like Java
Read more at:  https://www.tutorialkart.com/kotlin/main-function-in-kotlin/
*/
//------------------------
//var nullableStr: String? = "abc"
fun main() {
    // 2) Hello World in kotlin
    println("Hello, World!")//prints a line after printing the message
    print("Hello Again!")//does not print a line
    println()
    //------------------

    // 3) Variables and data types in kotlin
    // 3.1) variables in kotlin - val vs var

    /*
    - Read-only local variables are defined using the keyword val. They can be assigned a value only once.
    - Variables that can be reassigned use the var keyword.
   */

    val a: Int = 1  // immediate assignment
    // a=5  gives an compile time error
    val b = 1 //type not explicitly mentioned, but inferred
    var c = 10
    c = 20 //re-assignment is allowed in case of var

    //note: don't use var unless you totally need to change the value of a variable in some
    //future operation

    //-----------------

    /* c=20.0 however Kotlin is a statically typed language hence this will give a compile time error
    because we are assigning a floating type to an Int which is not allowed! */
    /*
    variables can also be assigned at the top
    */

    //Read more at: https://kotlinlang.org/docs/basic-syntax.html#variables

    // 3.2) data types in kotlin

    /*
    - In Kotlin, everything is an object
    Read more at: https://kotlinlang.org/docs/basic-types.html
    */

    //kotlin Numbers - range table https://kotlinlang.org/docs/numbers.html#integer-types
    val one: Int = 1 //inferred as Int automatically
    val threeBillion: Long = 3000000000 // inferred as Long as it exceeds Int range
    val oneLong = 1L // L means Long
    val pi: Double = 3.14 //inferred as Double
    val piFloat: Float = 3.14f //inferred as Float as f means Float
//You can check unsigned types here: https://kotlinlang.org/docs/unsigned-integer-types.html

    /*
    Note: On the JVM platform, numbers are stored as primitive types: int, double, and so on.
    Read more at: https://kotlinlang.org/docs/numbers.html#numbers-representation-on-the-jvm
    */

    //kotlin Booleans
    val myTrue: Boolean = true
    val myFalse: Boolean = false

    //kotlin Characters
    val d = 'a'
    val newLine = '\n'//escape sequence

    //kotlin Strings

    /*
    Just like in Java, Kotlin strings are immutable
    Read more at: https://kotlinlang.org/docs/strings.html
    */

    val str = "Whats up!"
    println(str)
    println(str.length)//length of string
    //you can access String like an array for eg:
    //str[2]='q' compile error, bcoz immutable
    println(str[2]) //prints a
    val str2 = "abcd"
    println(str + str2) //string concat operation
    println("${str}${str2}") //template strings - a better way to achieve the same thing

    //kotlin Arrays
    /*
    Read more at: https://kotlinlang.org/docs/arrays.html
    */
    val anyArr = arrayOf(1, 2, 'a', "Hello", true) //array with type Array<{Comparable*> & java.io.Serializable}>
    println(anyArr.contentToString())

    //primitive type arrays
    val intArr: IntArray = intArrayOf(1, 2, 3) //array of Ints (Java int[])
    val arr = IntArray(5) //array of size 5 with default value i.e 0
    val arr2 = IntArray(5) { 42 } //array with all values initialized to 42
    println(intArr.contentToString())

    //non-primitive type arrays
    //non-primitive types,map to Java objects and are references
    val integerArr: Array<Int> = arrayOf<Int>(1, 2, 3) // array with type 'Integer'(java)

    //Read this:https://stackoverflow.com/questions/45090808/intarray-vs-arrayint-in-kotlin
    //Read this: https://stackoverflow.com/questions/35253368/how-can-i-create-an-array-in-kotlin-like-in-java-by-just-providing-a-size

    //kotlin Collections
    //A collection usually contains a number of objects (this number may also be zero) of the same type
    //Read more at: https://kotlinlang.org/docs/collections-overview.html

    //List
    //immutable list, doesn't allow you to add/remove/update
    //you should use an immutable list, if you don't plan to update it
    val immutableList: List<String> = listOf("John", "Doe", "Roe")
    //mutable list, add allowed
    val mutableList: MutableList<String> = mutableListOf<String>()//empty list requires a generic
    mutableList.add("Yu")
    mutableList.add("uu")

    println(mutableList)
    println(immutableList)

    //Map
    //a immutable map
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)
    //numbersMap["key1"]=2 compile time error!
    println("All keys: ${numbersMap.keys}")
    println("All values: ${numbersMap.values}")

    if ("key2" in numbersMap) println("Value by key \"key2\": ${numbersMap["key2"]}")
    if (1 in numbersMap.values) println("The value 1 is in the map")
    if (numbersMap.containsValue(1)) println("The value 1 is in the map") // same as previous

    val mutableNumbersMap = mutableMapOf<String, Int>()
    mutableNumbersMap["key1"] = 100
    mutableNumbersMap["key2"] = 23

    println(mutableNumbersMap)

    //Set
    //https://kotlinlang.org/docs/collections-overview.html#set


    // 3.3) Type checks and casts in kotlin
    /*Read more at: https://kotlinlang.org/docs/typecasts.html*/
    //Read this: https://www.geeksforgeeks.org/kotlin-type-conversion/

    //is operator
    //is operator is used to check if an object is of the given type or not
    val str3 = "Hello"
    val anyStr: Any = 100
    println(str3 is String) //true
    println(anyStr is String)//false

    //explicit type casting
    val strAny: Any = "A string"
    //unsafe cast, will throw an exception if strAny has type other
    //than a String
    //val strUnsafeCasted: String = strAny as String

    //safe cast, will assign a null to strSafeCasted if strAny is NOT a string
    val strSafeCasted: String? = strAny as? String
    println("strSafeCasted: $strSafeCasted")

    //smart casts - kotlin magic
    //3 conditions
    var anyObj: Any = "Some string"

    // anyObj.length - here our type is still 'Any', so we can't access .length property
    if (anyObj is String) {
        //here our type is smart casted to String so we can use it as a String even
        //though its actually of type Any!!
        println(anyObj.length)
    }

    //More amazing examples here: https://kotlinlang.org/docs/typecasts.html#smart-casts

    // 4) Conditional expression in kotlin

    // 4.1) if
    var num1 = 10
    var num2 = 11

    //if statement
    var max = 0

    if (num1 < num2) {
        max = num2
    } else {
        max = num1
    }
    num2 = 12

    //or we can use it as a ternary type expression!
    max = if (num1 < num2) num2 else num1

    println(max)

    //more examples here: https://kotlinlang.org/docs/control-flow.html#if-expression

    //4.2) when expression

    //its the equivalent of switch case in kotlin

    val t = 1

    when (t) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> {
            print("x is neither 1 nor 2")
        }
    }
    println()
    //More amazing examples here: https://kotlinlang.org/docs/control-flow.html#when-expression


    //5) Looping in kotlin

    // 5.1) for loop
    //1..5 is a Range, both nos. are inclusive
    //below code prints 1 2 3 4 5

    for (i in 1..5) {
        print("$i ")
    }
    println()
    //downTo - decrement
    //step - steps to take between two nos.
    //prints 6 4 2 0
    for (i in 6 downTo 0 step 2) {
        print("$i ")
    }
    println()

    //array iteration
    val intArr2 = intArrayOf(1, 4, 3, 9, 100, 98, 54)

    for (num in intArr2) {
        print("$num ") //prints 1 4 3 9 100 98 54
    }

    println()
    //for more details: https://kotlinlang.org/docs/control-flow.html#for-loops

    // 5.2) while loop
    //Read more at: https://kotlinlang.org/docs/control-flow.html#while-loops
    var till = 5

    while (till > 0) {
        till--
    }

    println(till)

    // 6) break and continue in kotlin
    //Read more at: https://kotlinlang.org/docs/returns.html

    //break terminates the nearest enclosing loop.

    val nums = intArrayOf(1, 2, 3, 4, 5)

    //prints 1 2
    for (num in nums) {
        if (num == 3) {
            break
        }
        print("$num ")
    }
    println()

    //continue proceeds to the next step of the nearest enclosing loop.
    //prints 1 2 4 5
    for (num in nums) {
        if (num == 3) {
            continue
        }
        print("$num ")
    }
    println()

    // 7) Operators
    //Read more at https://www.geeksforgeeks.org/kotlin-operators/

    //7.1) Arithmetic operators

    var number1 = 5
    var number2 = 6
    //unary operators
    number1++
    number1--

    number2 += 1
    number2 -= 1

    //binary operators
    println(number1 + number2) // 11
    println(number1 - number2) // -1
    println(number1 * number2) // 30
    println(number1 / number2) //0, because its Integer division hence numbers to right of
    // the decimal gets truncated
    println(number1 * 1.0 / number2) //so we can do this if we want a proper division
    println(number1 % number2) // for remainder, which is 5

    // 7.2) Logical Operators
    val flagA = true
    val flagB = false

    //logical AND
    println(flagA && flagB)//true
    //logical OR
    println(flagA || flagB)//false
    //NOT operator
    println(!flagA)

    // 7.3) Relational operators
    val num4 = 10
    val num5 = 11

    println(num4 < num5) //true
    println(num4 > num5) //false

    val ref1: Int? = 1000
    val ref2: Int? = 1000

    //we have to use a nullable value outside range -128 to 128 here, because of Java's caching
    //from the docs:
    //All nullable references to a are actually the same object
    // because of the memory optimization that JVM applies to Integers between -128 and 127

    println("Are the values equal ${ref1 == ref2}")//true as 1000 equals to 1000
    println("Are the references equal ${ref1 === ref2}")//false as both are different objects

    //Read more: https://kotlinlang.org/docs/equality.html#structural-equality

    // 8) Any,Nothing and Unit in kotlin
    //Any: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/
    //Nothing: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing.html
    //Unit: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/

    // 9) Null and Null safety in kotlin
    //About Null: https://www.freecodecamp.org/news/a-quick-and-thorough-guide-to-null-what-it-is-and-how-you-should-use-it-d170cea62840/
    //Null safety in Kotlin: https://kotlinlang.org/docs/null-safety.html#nullable-types-and-non-null-types


    //non nullable type
    //the below variable is GUARANTEED to be non null!
    var nonNullStr: String = "abc" // Regular initialization means non-null by default
    // nonNullStr = null  compilation error

    //nullable type(no guarantees about null!)
    var nullableStr: String? = "abc" //? is to denote that the type is nullable
//    nullableStr = null
//    println(nullableStr) null


    //the below gives us a compile time error as direct invocation of any method
    //or any of its properties is NOT safe because of its nullability

    //nullableStr.length

    //dealt with it

    if (nullableStr != null && nullableStr.isNotEmpty()) {
        println("String of length ${nullableStr.length}")
    } else {
        println("Empty string")
    }

    //but in case it was a top level variable/instance variable this won't work!
    //    //as it could have been modified
    //    //dealing with nullable types
    //    //null check

    // the safe call operator

    // the . operator is used to access properties or call member methods but doesn't care about
    //null safety
    //so kotlin introduced a safer way to call nullable types i.e the safe call - ?.
    //?. ensures that null is returned in case our variable is null
    println(nullableStr?.length) //if nullableStr is null then we won't get an exception, instead null is printed

    //Read more here: https://kotlinlang.org/docs/null-safety.html#safe-calls

    //the elvis operator
    //we can use this instead of writing an if else for a null check for eg.

    //if the expression to the left of ?: is not null then that is returned
    //else expression to the right i.e -1 is returned
    val l = nullableStr?.length ?: -1
    println("length of nullable string $l")

    //Read more at: https://kotlinlang.org/docs/null-safety.html#elvis-operator

    //not-null assertion operator AKA shooting your own foot
    //by specifying !! after our variable we assert that its not null and the execution should take place
    //basically forcing it
    //if its a null we get an exception and our application crashes :)
    println(nullableStr!!.length)

    // 10) Functions in kotlin
    //https://kotlinlang.org/docs/functions.html
    // 10.1) functions basics
    display(10) //prints 10
    println(add(10, 12)) //22
    println(add())//11
    //single expression function
    println(double(8))//16
    //if a default parameter precedes a parameter with no default value,
    // the default value can only be used by calling the function with named arguments:
    foo(baz = 1)
    //xyz has a member function which can access its members
    xyz()
    //Read more about default parameters: https://kotlinlang.org/docs/functions.html#default-arguments

    // 10.2) function - named arguments
    //You can name one or more of a function's arguments when calling it.
    //When you use named arguments in a function call,
    // you can freely change the order that they are listed in
    reformat(
        str = "Abc",
        wordSeparator = 'a',
        normalizeCase = false,
        upperCaseFirstLetter = false,
        divideByCamelHumps = true,
    )
    //Read more at: https://kotlinlang.org/docs/functions.html#named-arguments

    // 10.3) lambda functions
    //Read: https://www.geeksforgeeks.org/kotlin-lambdas-expressions-and-anonymous-functions/
    /*
    Kotlin functions are first-class, which means they can be stored in variables and data
    structures, and can be passed as arguments to and returned from other higher-order functions.
    */

    //a simple lambda function
    val lambda1 = { println("xyz") }

    // invoking function lambda1
    lambda1()
    // or lambda1.invoke()

    /*
    A lambda expression is always surrounded by curly braces, argument declarations go
    inside curly braces and have optional type annotations, the code_body goes after an arrow -> sign.
    If the inferred return type of
    the lambda is not Unit, then the last expression inside the lambda body is treated as return value.
    */

    val sum = { a1: Int, a2: Int -> a1 + a2 } //infers return type as Int from last statement
    val sum2: (Int, Int) -> Int = { a1, a2 -> a1 + a2 } //one and same thing
    println(sum(1, 2)) //3

    //filter can take an lambda fun
    //we are basically passing a function to another function!
    val numbers = arrayOf(1, -2, 3, -4, 5)
    //if lambdas have a single parameter,
    // it can be implicity assumed to be 'it'
    println(numbers.filter({ it > 0 })) //the () are not mandatory while using lambdas
    println(numbers.filter { it > 0 }) //removing redundant braces
    //longer version of the above code, we can change it if we don't want 'it'
    println(numbers.filter { it -> it > 0 })
    //doing the same using an anonymous function f
    println(numbers.filter(f))

    val myArr = arrayOf(1, 2, -1, -3, 0, 4, 7)

    println(customFilter(myArr, { it > 0 }))

    //note:
    // in a lambda function last statement is the return type, explicit returns are not allowed
    // while in a anonymous function we need to explicitly return a value
    //a lambda function too can access its closure

    /*note:
    According to Kotlin convention, if the last parameter of a function is a function,
    then a lambda expression passed as the corresponding argument can
    be placed outside the parentheses
   */

    //Read more at: https://kotlinlang.org/docs/lambdas.html

    // 10.4) inline function
    //Read: https://www.geeksforgeeks.org/kotlin-inline-functions/
    //and: https://kotlinlang.org/docs/inline-functions.html

    //inline function to demonstrate return
    someInlineFunction(10, {
        println("Hello I am func1")
        return
    }, { println("Hello I am func2") }
    )

}

//function to display a number, returns Unit by default
fun display(x: Int) {
    println("The number is $x")
}

//short-hand for when a function returns a single expression
fun double(x: Int): Int = x * 2

//function with default parameters, to add two numbers, returns Int
fun add(x: Int = 5, y: Int = 6): Int {
    return x + y
}

fun foo(bar: Int = 0, baz: Int) {
    println("bar: $bar, baz: $baz")
}

//function to demonstrate named params
fun reformat(
    str: String,
    normalizeCase: Boolean = true,
    upperCaseFirstLetter: Boolean = true,
    divideByCamelHumps: Boolean = false,
    wordSeparator: Char = ' ',
) { /*...*/
}

fun xyz() {
    val c: Int = 100 //can be accessed by zyx()

    //below is a local function
    fun zyx(a: Int, b: Int): String {
        return "$a-$b-$c"
    }

    println(zyx(1, 10))
}

//anonymous fun to be passed to filter method of an array
//an anonymous fun has no name
val f = fun(i: Int): Boolean {
    return i > 0
}

//custom implementation of the filter function
fun customFilter(arr: Array<Int>, func: (Int) -> Boolean): MutableList<Int> {
    val filtered = mutableListOf<Int>()
    for (num in arr) {
        if (func(num)) {
            filtered.add(2 * num)
        }
    }

    return filtered;
}

//an inline function in kotlin
inline fun someInlineFunction(num: Int, func1: () -> Unit, func2: () -> Unit) {
    //func1 executes and returns from the function
    func1()
    //func2 won't execute
    func2()
}

