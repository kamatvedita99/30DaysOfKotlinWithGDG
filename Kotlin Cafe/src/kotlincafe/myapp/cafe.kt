package kotlincafe.myapp

import java.util.Scanner


open class cafe(var name:String,var price:Int)
{



    open  fun info()

    {

        print(name + " : " + price+" ")
    }



}

class Food(name:String,price:Int,var kcalories:Int) :cafe(name,price)
{ override fun info(){
    super.info()
    print("( $kcalories kcal )")

}


    fun get_kcalories():Int{
        return kcalories
    }



    fun get_total_price(count:Int):Int{
        return price*count
    }
}

class Drink(name:String,price:Int,var ml:Int) :cafe(name,price)
{ override fun info(){
    super.info()
    print("( $ml ml )")

}


    fun get_ml():Int{
        return ml
    }



    fun get_total_price(count:Int):Int{
        return price*count
    }
}