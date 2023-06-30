import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import java.net.URL
import kotlin.system.measureTimeMillis

fun main()= runBlocking {
    var time = measureTimeMillis {
        fetchAllDataWithCoroutines().forEach { println(it) }
    }
    println(time)
}

fun fetchData(name:String,url:String):ApiResult{
    val result = URL(url).readText()
    return ApiResult(name,result)
}

suspend fun fetchAllDataWithCoroutines(): List<ApiResult> {
    return coroutineScope {
        val list = listOf(
            "API1" to "https://catfact.ninja/fact",
            "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
            "API3" to "https://www.boredapi.com/api/activity",
            "API1" to "https://catfact.ninja/fact",
            "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
            "API3" to "https://www.boredapi.com/api/activity",
            "API1" to "https://catfact.ninja/fact",
            "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
            "API3" to "https://www.boredapi.com/api/activity",
            "API1" to "https://catfact.ninja/fact",
            "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
            "API3" to "https://www.boredapi.com/api/activity",
            "API1" to "https://catfact.ninja/fact",
            "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
            "API3" to "https://www.boredapi.com/api/activity",
            "API1" to "https://catfact.ninja/fact",
            "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
            "API3" to "https://www.boredapi.com/api/activity",
            "API1" to "https://catfact.ninja/fact",
            "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
            "API3" to "https://www.boredapi.com/api/activity",
            "API1" to "https://catfact.ninja/fact",
            "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
            "API3" to "https://www.boredapi.com/api/activity",
            "API1" to "https://catfact.ninja/fact",
            "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
            "API3" to "https://www.boredapi.com/api/activity",
            "API1" to "https://catfact.ninja/fact",
            "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
            "API3" to "https://www.boredapi.com/api/activity",
            "API1" to "https://catfact.ninja/fact",
            "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
            "API3" to "https://www.boredapi.com/api/activity",
            "API1" to "https://catfact.ninja/fact",
            "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
            "API3" to "https://www.boredapi.com/api/activity",
            "API1" to "https://catfact.ninja/fact",
            "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
            "API3" to "https://www.boredapi.com/api/activity"
        )
        val allJobs = list.map { (apiName, apiUrl) ->
            async { fetchData(apiName, apiUrl)}
        }
        allJobs.awaitAll()
    }
}
fun fetchAllDataWithOutCoroutines(): List<ApiResult> {
    val list = listOf(
        "API1" to "https://catfact.ninja/fact",
        "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
        "API3" to "https://www.boredapi.com/api/activity",
        "API1" to "https://catfact.ninja/fact",
        "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
        "API3" to "https://www.boredapi.com/api/activity",
        "API1" to "https://catfact.ninja/fact",
        "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
        "API3" to "https://www.boredapi.com/api/activity",
        "API1" to "https://catfact.ninja/fact",
        "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
        "API3" to "https://www.boredapi.com/api/activity",
        "API1" to "https://catfact.ninja/fact",
        "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
        "API3" to "https://www.boredapi.com/api/activity",
        "API1" to "https://catfact.ninja/fact",
        "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
        "API3" to "https://www.boredapi.com/api/activity",
        "API1" to "https://catfact.ninja/fact",
        "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
        "API3" to "https://www.boredapi.com/api/activity",
        "API1" to "https://catfact.ninja/fact",
        "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
        "API3" to "https://www.boredapi.com/api/activity",
        "API1" to "https://catfact.ninja/fact",
        "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
        "API3" to "https://www.boredapi.com/api/activity",
        "API1" to "https://catfact.ninja/fact",
        "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
        "API3" to "https://www.boredapi.com/api/activity",
        "API1" to "https://catfact.ninja/fact",
        "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
        "API3" to "https://www.boredapi.com/api/activity",
        "API1" to "https://catfact.ninja/fact",
        "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
        "API3" to "https://www.boredapi.com/api/activity",
        "API1" to "https://catfact.ninja/fact",
        "API2" to "https://api.coindesk.com/v1/bpi/currentprice.json",
        "API3" to "https://www.boredapi.com/api/activity")
    return list.map { (apiName,apiUrl) ->
        fetchData(apiName,apiUrl)
    }
}
data class ApiResult(val name:String,val url:String)