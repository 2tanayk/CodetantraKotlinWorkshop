//A kotlin class
class A {}

//if a class has no body, we can omit the braces!
//class A

//class with a primary constructor
class SomePerson constructor(firstName: String) { /*...*/ }

//it can be written in this way as well if the constructor has no visibility modifiers
//class Person(firstName: String) { /*...*/ }

//same class using a secondary constructor
//class Person {
//    constructor(firstName: String) {}
//
//}


//a primary constructor can't contain any code, if you want any initialization code
//then it can be placed in the init block

//if you want constructor parameters to be properties of the class
//then add a val or a var before it else it won't be accessible from member functions

//we can also assign default values
class Animal(val name: String = "Cat") {
    //property
    var speed: Int = 0

    init {
        println("In primary constructor")
        println("in class Animal $name")
    }

    //if a class has a primary constructor then each primary
    //constructor needs to delegate to the primary constructor
    //so the init blocks will be always executed before code in secondary constructor

    //secondary constructors can NOT have val or var in parameters
    constructor(name: String, legs: Int) : this(name) {
        println("In secondary constructor")
        println("Animal has $legs legs")
    }

    fun display() {
        println(name)
    }
}

/*
Note:
If a non-abstract class does not declare any constructors (primary or secondary), it will have
 a generated primary constructor with no arguments. The visibility of the constructor
 will be public.
 */

//you can customize getter and setters
class Rectangle(val width: Int, val height: Int) {
    val area: Int // property type is optional since it can be inferred from the getter's return type
        get() = this.width * this.height //invoked when object.property is called
    //set() can't have a setter as it is read only

    var tag: String = "Default"
        //field hold value of our property, its called a backing field
        get() = "$field Rectangle"
        //value is the default name for our setter parameter
        set(value) {
            field = "Updated $value"
        }
}

//By default, Kotlin classes are final
// – they can't be inherited. To make a class inheritable, mark it with the open keyword:
open class Person(val name: String) {
    //the parent class constructor will be called first
    init {
        println("In Person class")
    }

    open fun introduction() {
        println("I am a person")
    }
}

//class student extends Person
//If the derived class has a primary constructor, the base class and must
// be initialized in that primary constructor according to its parameters.
class Student(name: String, val rollNo: Int) : Person(name) {
    init {
        println("In the Student sub-class")
    }

    override fun introduction() {
        super.introduction()
        println("I am also a Student")
    }

    fun completeAssignments() {
        println("Completing assignments :(")
    }

    fun display() {
        println("Name:$name")
        println("Roll no: $rollNo")
    }
}

class SomeClass {
    //lateinit means property will be initialized late, for eg, inside some member function
    //rather than inside the constructor
    //we do this on non-nullable types rather than using a null type and initializing it to null
    //if not initialized and will give us null checks and other headaches
    lateinit var late: String

    //this is not late initialization and is initialized in the
    //init block
    val notLate: Int

    //a null type, that is initialized to null because it does not have a value right now
    //we try to avoid doing this by using lateinit
    var nullable: String? = null

    init {
        println("property late will not be initialized here")
        notLate = 0
    }

    fun initializeLate() {
        //the :: operator is called the "member reference" operator
        if (this::late.isInitialized) {
            println("late has been initialized")
        } else {
            //println("Member reference ${this::late}")
            println("late has not been initialized")
        }
        late = "late property"
        nullable = "nullable property"
        println("late: $late")
        println("nullable: $nullable")
    }
}

//this is an abstract class, can not be directly instantiated
//but can be instantiated using a sub class like Java or Kotlin here
//abstract classes are used to enforce certain properties and methods
//like here a programming language should have name and a print statement
//the child has to provide these!
abstract class ProgrammingLanguage(val name: String) {
    init {
        println("Hello, I am a programming language")
    }

    abstract fun printStatement()
}

class Java : ProgrammingLanguage("Java") {
    override fun printStatement() {
        println("System.out.println()")
    }
}

class Kotlin : ProgrammingLanguage("Kotlin") {
    override fun printStatement() {
        println("println()")
    }
}

//interface in kotlin
//What makes them different from abstract classes is that interfaces cannot store state
interface PlayMusic {
    //abstract by default
    fun play()
}

class Mobile : PlayMusic {
    override fun play() {
        println("Playing music from spotify android app...")
    }
}

class Laptop : PlayMusic {
    override fun play() {
        println("Playing music from spotify desktop app...")
    }
}

interface X {
    fun bar() {
        println("barfoo")
    }
}

interface Y {
    fun bar() {
        println("foobar")
    }
}

class Z : X, Y {
    override fun bar() {
        super<X>.bar()
        super<Y>.bar()
        //your own implementation
    }
}

class MyClass {
    companion object {
        fun someMethod() {
            println("Inside a method of a companion object")
        }
    }
}

//SAM/functional interface
fun interface Messenger {
    fun message(msg: String)
}

class Outer {
    private val bar: Int = 1

    class Nested {
        fun foo() = 2
    }
}

class OuterClass {
    private val bar: Int = 1

    inner class Inner {
        fun foo() = bar
    }
}

data class User(val name: String = "", val age: Int = 0)

class Box<T>(t: T) {
    var value = t
}

fun main() {
    println("Hello OOP")
    //11)OOP in kotlin
    //Read more at: https://kotlinlang.org/docs/classes.html
    //11.1) classes and objects
    Animal() //only primary constructor(init too) is executed
    Animal("Dog")//same as above
    val a = Animal("Dog", 4)//both are executed
    a.display()//Dog
    a.speed = 100

    val r = Rectangle(5, 10)
    println(r.area) //this invokes the .get() call i.e width * height
    println(r.tag) //invokes .get() call i.e Default Rectangle
    r.tag = "New" //invokes the setter
    println(r.tag) //Updated New Rectangle
    //Read more at: https://kotlinlang.org/docs/properties.html

    //lateinit in kotlin
    val late = SomeClass()
    late.initializeLate()

    // 11.2) Visibility Modifiers
    //Read here: https://kotlinlang.org/docs/visibility-modifiers.html#packages
    //Read this too:https://kotlinlang.org/docs/packages.html

    // 11.3) Inheritance
    //Read more here: https://kotlinlang.org/docs/inheritance.html
    //All classes in Kotlin have a common superclass,
    // Any, which is the default superclass for a class with no supertypes declared:

    val student = Student("Bob", 101)
    student.display()
    student.completeAssignments()
    student.introduction()

    println(student is Person)//true

    // 11.4) Abstract class and Interface
    //abstract class
    // ProgrammingLanguage("Java") gives error, as we can't directly instantiate it and makes no sense
    Java().printStatement()
    Kotlin().printStatement()

    //interface
    //Read more here: https://kotlinlang.org/docs/interfaces.html
    //Mobile and Laptop are different and unrelated classes but
    //both can play music because they implement interface
    Mobile().play()
    Laptop().play()

    //Z implements multiple interfaces
    Z().bar()

    // 11.5) anonymous class in kotlin

    //repeatedly creating classes just to extend some other
    //class can be cumbersome hence we can use an anonymous class to achieve the same
    //for eg. to extend the Person class from the previous example

    val student2 = object : Person("John") {
        override fun introduction() {
            super.introduction()
            println("My name is John and I am a student")
        }
    }

    //so we can see we have absolutely simplified our code!
    student2.introduction()

    //Read more about object and anonymous classes here:
    //https://kotlinlang.org/docs/object-declarations.html

    //11.6) companion objects
    //similar to Java static methods but they are not actually static methods
    //but we can use them that way
    //calling this code from Java will treat it as a static object
    MyClass.someMethod()

    //Read more about it here:
    //https://kotlinlang.org/docs/object-declarations.html

    //11.7) SAM/Functional Interfaces

    //An interface with only one abstract method is called a functional interface,
    // or a Single Abstract Method (SAM) interface

    //in the previous section we saw how we can use object to
    //to simply extension of classes
    //now we can make our code even more concise if its a SAM
    //eg.

    val message = Messenger { println("Recd. msg: $it") }
    message.message("Hello!")
    //longer version
//    val message = object : Messenger {
//        override fun message(msg: String) {
//            TODO("Not yet implemented")
//        }
//    }


    //Read more here: https://kotlinlang.org/docs/fun-interfaces.html

    //11.8) Nested and Inner classes

    //Read more here:https://kotlinlang.org/docs/nested-classes.html
    //eg.
    Outer.Nested().foo()

    //a nested class can be marked as inner if we want to access
    //outside class members
    OuterClass().Inner().foo()

    //11.9) data classes
    //Read more at:https://kotlinlang.org/docs/data-classes.html
    //Read this too:https://kotlinlang.org/docs/equality.html
    //good answers: https://stackoverflow.com/questions/51340603/what-is-difference-between-and-in-kotlin

    //if we want a class just to hold data
    //for eg. lets say we have a list of users for a website
    //and we use instance of a class User which holds
    //data for each and every user
    //then we can use data classes instead of writing boilerplate

    val user1 = User("John", 19)
    val user2 = User("Bob", 21)
    println(user1)
    println(user2)

    //destructuring
    val (name, age) = user1

    val user3 = user1.copy(name = "Ralph")
    val user4 = user2.copy()
    println(user3)

    //this is possible because of data classes!
    println(user2 == user4)

    //11.10) extension functions
    //Read more at:https://kotlinlang.org/docs/extensions.html#extension-functions
    //Kotlin provides the ability to extend a class or an interface with new
    // functionality without having to inherit from the class

    //For example, you can write new functions for a class or an interface from a third-party
    // library that you can't modify. Such functions can be called in the usual way,
    // as if they were methods of the original class.
    // This mechanism is called an extension function.

    //eg.
    val list = mutableListOf(1, 2, 3)
    println(list)
    //magic of extension functions!
    list.swap(0, 2)
    println(list)

    //11.11) Generics
    //Read more: https://kotlinlang.org/docs/generics.html
    val boxInt: Box<Int> = Box(1)
    val boxStr: Box<String> = Box("Hello")

    //11.12 this
    //Read: https://kotlinlang.org/docs/this-expressions.html

    //12 Exception handling in kotlin
    //https://kotlinlang.org/docs/exceptions.html
}

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

//member reference operator
/*
lass Person(val name: String) {
    fun sayHello() {
        println("Hello, my name is $name.")
    }
}

fun main() {
    val person = Person("John")
    val helloFunction = person::sayHello
    helloFunction() // prints "Hello, my name is John."
}
*/

//val ref = String::compareTo
//    println(ref("abc", "abc"))
