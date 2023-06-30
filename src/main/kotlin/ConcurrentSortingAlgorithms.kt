import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking{
    val list = arrayListOf(9,8,12,4,3,5,2,7,1)
    val time = measureTimeMillis {
//        sortingConcurrentlyWithCoroutinesAndUsingCoroutineScope(list)
        sortingConcurrentlyWithOutCoroutines(list)
//        sortingConcurrentlyWithCoroutinesAndUsingGlobalScope(list)
    }
    println(time)
}
suspend fun sortingConcurrentlyWithOutCoroutines(list: ArrayList<Int>){
    val l=ArrayList(list)
    val l2 = ArrayList(list)
    val l3 = ArrayList(list)
    val bubbleSort = l.sorting { "BubbleSort" }
    val selectionSort = l2.sorting { "SelectionSort" }
    val insertionSort = l3.sorting { "InsertSort" }
    println(bubbleSort)
    println(selectionSort)
    println(insertionSort)
}
suspend fun sortingConcurrentlyWithCoroutinesAndUsingGlobalScope(list: ArrayList<Int>){

    val bubbleSort = GlobalScope.async {
        val l =ArrayList(list)
        l.sorting { "BubbleSort" } }
    val selectionSort = GlobalScope.async {
        val l =ArrayList(list)
        l.sorting { "SelectionSort" } }
    val insertionSort = GlobalScope.async {
        val l =ArrayList(list)
        l.sorting { "InsertSort" } }
    println("bubbleSort"+bubbleSort.await())
    println("selectionSort"+selectionSort.await())
    println("insertionSort"+insertionSort.await())
}
suspend fun sortingConcurrentlyWithCoroutinesAndUsingCoroutineScope(list: ArrayList<Int>){
    coroutineScope {
        val bubbleSort = async {
            val l =ArrayList(list)
            l.sorting { "BubbleSort" } }
        val selectionSort = async {
            val l =ArrayList(list)
            l.sorting { "SelectionSort" } }
        val insertionSort = async {
            val l =ArrayList(list)
            l.sorting { "InsertSort" } }
        println("bubbleSort"+bubbleSort.await())
        println("selectionSort"+selectionSort.await())
        println("insertionSort"+insertionSort.await())
    }
}
suspend fun ArrayList<Int>.sorting(lam:(algorithm :String) -> String): ArrayList<Int> {
    val result =when(lam("BubbleSort")){
        "BubbleSort" -> bubbleSort(this)
        "InsertSort" -> insertionSort(this)
        "SelectionSort" -> selectionSort(this)
        else -> this
    }
    return result
}

suspend fun bubbleSort(list: ArrayList<Int>):ArrayList<Int>{
    delay(10000)
    for (i in 0 until list.size) {
        for (j in 1 until list.size-i) {
            if (list[j - 1] > list[j]) {
                swap(list,j-1,j)
            }
        }
    }
    return list
}

suspend fun selectionSort(list:ArrayList<Int>):ArrayList<Int>{
    delay(10000)
    var smallest:Int
    for (i in 0 until list.size){
        smallest = i
        for (j in (i+1) until list.size){
            if (list[j]<list[smallest]){
                smallest=j
            }
        }
        swap(list,smallest,i)
    }
    return list
}
suspend fun insertionSort(list: ArrayList<Int>):ArrayList<Int>{
    delay(10000)
    for (i in 1 until list.size){
        var current = list[i]
        var j = i-1
        while (j>=0 && current<list[j]){
            list[j+1] = list[j]
            j--
        }
        list[j+1]=current
    }
    return list
}
fun swap(a : ArrayList<Int>, b: Int, c:Int) {
    val temp = a[b]
    a[b] = a[c]
    a[c] = temp
}
