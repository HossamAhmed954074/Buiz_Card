package com.demo.kotlinfundementals

fun main(){
//var truck = Truck("Blue","BMW")
//    println("The Truc Color = ${truck.color} ,and The Model it = ${truck.model} , the speed is ${truck.speed(3)} KM")


    println("Hossam".removeStartAndLast())
}

fun String.add(text:String): String{
    return this.plus(" ").plus(text)
}

fun String.removeStartAndLast():String{
    return this.trim().substring(1,this.length-1)

}

val catCalc : (Int) -> Int = {
    it*7
}

val shoeName : (String) -> Unit = { println(it)}


open class Car(var color:String , var model:String){
    open fun speed(speed:Int) : Int{

        return speed * 1000
    }

}

class Truck( truckColor:String,  truckModel : String) : Car(truckColor, truckModel){
    override fun speed(speed: Int): Int {

        return speed *3
    }
}