fun main(){
    var razmer : Int;
    println("Выберите размер поля")
    println("1:большой, 2:средний, 3:маленький")
    razmer = readLine()!!.toInt()
    if (razmer==1) {
        var gor : Int =1000;
        var ver : Int =1000;
    }
    if (razmer==2) {
        var gor: Int = 500;
        var ver: Int = 500;
    }
    if (razmer==3) {
        var gor : Int =250;
        var ver : Int =250;
    }
    println("Выберите количество препятствий")
    println("1:нет, 2:мало, 3:средне, 4:мого")

    var barier: Int;
    barier= readLine()!!.toInt()

    if (barier==1){
        var prep:Int =0
    }
    if (barier==1){
        var prep:Int =50
    }
    if (barier==1){
        var prep:Int =100
    }
    if (barier==1){
        var prep:Int =200
    }
}