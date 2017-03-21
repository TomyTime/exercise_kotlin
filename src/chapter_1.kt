import org.omg.CORBA.Object

/**
 * Created by TomyTime on 2017/3/15.
 */

/*
fun main(args: Array<String>): Unit {
    println((0 + 15) / 2)
    println(2.0e-6 * 100000000.1)
    println(true && false || true && true)
    println((1 + 2.236) / 2)
    //println(1 + 2 + "3")
}
*/

class Capater1(){

    /**
     * Fibonacci
     */
    fun answer_1_1_6():Unit{
        var f:Int = 1
        var g:Int = 0
        for(i:Int in 0..15){
            println(f)
            f += g
            g = f - g
        }
    }

    /**
     * 注意Ascii码转换
     * kotlin和java环境不一样
     */
    fun answer_1_1_9():Unit{
        println('b')
        println('b' + 4)
//        println((char)('b' + 4))
    }

    /**
     * 求以2为底的对数
     */
    fun answer_1_1_14(n:Int):Unit{
        var num = 2
        var count = 1
        when(n) {
            2 -> println(1)
            in 0..2 -> println(0)
            else -> {
                while (num <= n) {
                    num *= 2
                    count++
                }
                println(--count)
            }
        }
    }

    fun exR1(n:Int):String{
        if(n <= 0) return ""
        return exR1(n-3) + n + exR1(n-2) + n
    }

    /*var binomial_count = 0
    fun binomial(N:Int, k:Int, p:Double):Double{
        binomial_count++
//        println("$N == $k ==> $p")
        if(N == 0 && k == 0) return 1.0
        if(N < 0 || k < 0) return 0.0
        return (1.0-p)*binomial(N-1, k, p) + p*binomial(N-1, k-1, p)
    }*/

    /**
     * 非递归计算二项式分布
     * 来源: http://frankorz.com/wiki/chapter1/1.1.html
     * 使用一个二维数组来存放各项二项分布的概率
     * 行代表重复N次试验，列代表发生k次，所以在下面循环条件中需要 j<=i
     */
    fun binomial(N:Int, k:Int, p:Double):Array<Array<Double>>{
        var array:Array<Array<Double>> = Array(N+1){Array(k+1){0.0}}
        array[0][0] = 1.0
        for(i in 1..N){
            array[i][0] = array[i-1][0] * (1-p)
        }
        for(i in 1..N){
            for(j in 1..k){
                if(j>i) break
                array[i][j] = (1-p) * array[i-1][j] + p * array[i-1][j-1]
            }
        }

        for(i in 1..N){
            for(j in 1..k){
                print(array[i][j])
                print("  ")
            }
            println()
        }

        return array
    }

    /**
     * 模拟随机扔两个骰子
     */
    fun random_num(min:Int, max:Int):Array<Int>{
        var array:Array<Int> = Array(2){-99999}

        while(array[0] + array[1] < 2){
            var num = (Math.random()*(max-min+2)).toInt()
            if(num >= min && num <= max){
                if(array[0] === -99999) array[0] = num
                else array[1] = num
            }
        }

        return array
    }

    /**
     * 打印数组
     */
    fun print_array(ary: Array<Int>):Unit{
        for(i in 0..ary.size-1){
            print(ary[i])
            print("  ")
        }
    }

    fun roll(N:Int):Unit{
        for(i in 0..N){
            var result:Array<Int> = random_num(1, 6)
            print_array(result)
        }
    }

    fun q_1_1_35(N:Int):Unit{
        val SIDES:Int = 6
        var dist:Array<Double> = Array(2*SIDES+1){0.0}

        for(i in 1..SIDES){
            for(j in 1..SIDES){
                dist[i+j] += 1.0
            }
        }

        for(k in 2..2*SIDES){
            dist[k] /= 36.0
        }

        for(i in 2..(2*SIDES)){
            print(dist[i])
            print("  ")
        }
    }

    fun answer_1_2_4():Unit{
        var string1:String = "hello"
        var string2:String = string1
        string1 = "world"

        println(string1)
        println(string2)
    }

    fun circular_rotation(a:String, b:String):Boolean{
        val c = a + a
        println(c.indexOf(b))
        if(c.indexOf(b) > -1){
            return false
        }
        return true
    }

}

/*class ResizinngArrayStack<T>:Iterator<T> {
    constructor(){}
    val N:Int = 1
//    val items:Array<T>
    override fun hasNext():Boolean{
        return false
    }

    override fun next():T{
       return T
    }


}*/

fun main(args: Array<String>) {
    val apple = Capater1()
//    apple.answer_1_1_6()
//    apple.answer_1_1_9()
//    apple.answer_1_1_14(8)
//    println(apple.exR1(6))
//    apple.binomial(100, 50, 0.25)
//    apple.q_1_1_35(0)
//    apple.roll(6)
//    apple.answer_1_2_4()
    apple.circular_rotation("ACTGACT", "TGACTAC")
}
