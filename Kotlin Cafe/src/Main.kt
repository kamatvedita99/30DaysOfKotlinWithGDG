package kotlincafe.myapp

import java.util.Scanner

class Customer( var customerName:String?){
    companion object details{
        fun helloCustomer(customerName:String?){

            println("Hello "+customerName)
        }

        fun byeCustomer(customerName:String?){
            println(" Bubyee , Have a good day "+customerName)
        }
    }
}

fun validate(checkNumber:Int):Boolean{
    if(checkNumber in 1..4)
    {return false}
    println("Please try again")
    return true
}
fun buildMenu(){
    val food1 =Food("Pizza",250,135)
    val food2 =Food("Pasta",450,330)
    val food3 =Food("Maggie",150,640)
    val food4 =Food("Burger",50,220)
    val drink1 =Drink("Coke",250,135)
    val drink2 =Drink("Coke Diet",150,135)
    val drink3 =Drink("Coffee",250,135)
    val drink4 =Drink("Kotlin Special",550,135)
//adding all food and drink objects to a list
    var foodList=listOf(food1,food2,food3,food4)
    var drinkList=listOf(drink1,drink2,drink3,drink4)
    var index=1
    println("Choose a snack our menu(1-4)\n")
    for (eachFood in foodList){
        print(" $index. ")
        eachFood.info()
        val myCalorie=eachFood.get_kcalories()
        when(myCalorie){
            in 0..300 ->print(" Low Calorie")
            in 301..600 ->print(" Healthy!")
            else -> print(" High Calorie")
        }
        print("\n")
        index+=1
    }
    var reader=Scanner(System.`in`)
    var selectedFoodPos:Int
    do{
        selectedFoodPos=reader.nextInt()
    }while(validate(selectedFoodPos))

    selectedFoodPos-=1
    println("How many meals do you want?\n")
    var countFood=reader.nextInt()
    val selectedFoodList=foodList[selectedFoodPos]

    index=1
    println("Choose a drink from our menu(1-4)\n")
    for (eachDrink in drinkList){
        print(" $index. ")
        eachDrink.info()
        //val myMl=eachDrink.get_ml()


        print("\n")
        index+=1
    }




    var selectedDrinkPos:Int
    do{
        selectedDrinkPos=reader.nextInt()
    }while(validate(selectedDrinkPos))

    selectedDrinkPos-=1
    println("How many drinks do you want?\n")
    var countDrink=reader.nextInt()
    val selectedDrinkList=drinkList[selectedDrinkPos]

    print("You selected the snack:${selectedFoodList.name}\n")
    print("quantity: $countFood\n")

    val total_price_food=selectedFoodList.get_total_price(countFood)


    val total_price_drink=selectedDrinkList.get_total_price(countDrink)
    print("You selected the drink:${selectedDrinkList.name}\n")
    print("quantity: $countDrink\n")
    val total_price=total_price_food+total_price_drink
    print("Your bill amount is ${total_price}\n")}

fun customerReview(){
    val customerExperience=Triple("We are glad we made you happy!","We promise to make you happier!","We are sorry.We will definitely improve to see you happy!")
    val customerService=Triple("It was amazing!","Okayish!","I didn't like it!")

    println("How did you find our customer service? ")
   println("1.${customerService.first}\n")
    println("2.${customerService.second}\n")
    println("3.${customerService.third}\n")
    var reader=Scanner(System.`in`)
    var choice=reader.nextInt()
    when(choice){
        1 -> println("${customerExperience.first}")
        2 ->println("${customerExperience.second}")
        3 ->println("${customerExperience.third}")
                else-> println("We didn't get you!")
    }
}
fun main(){

    println("---------Welcome to Kotlin Cafe!----------\n")


    var reader=Scanner(System.`in`)

    print("Hey,Foodie! Enter your name:\n  ")


        var enteredName=readLine()
        if(enteredName==null){
            enteredName="Guest"}


        Customer.helloCustomer(enteredName)

        buildMenu()
      customerReview()
        Customer.byeCustomer(enteredName)}