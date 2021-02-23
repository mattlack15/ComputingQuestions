package com.example.kotlinpractice.waterloo

fun main(args: Array<String>) {

    val n = 3
    val p = listOf<Int>(6,1,14)
    val w = listOf<Int>(8,4,5)
    val d = listOf<Int>(3,1,2)

    //create array
    val posMap = Array(60){ 0 }

    // setup heatmap
    (0 until n).forEach {
        if (p[it]-d[it] >= 0) {
            posMap[p[it] - d[it]] = w[it]
        }
        posMap[p[it]+d[it]] = w[it]
    }

    var changeByStep = 0
    var runningSum = 0
    var lowestSum = Int.MAX_VALUE

    //calculate initial status
    (0 until n).forEach {
        if (p[it]-d[it] > 0) {
            changeByStep -= w[it]
            runningSum += (p[it]-d[it])*w[it]
        }
    }
    lowestSum  = runningSum

    //run the course
    posMap.forEachIndexed { i, v ->
        println("Step $i: Change: $changeByStep V: $v Running Sum: $runningSum")
        changeByStep += v
        runningSum += changeByStep
        if (lowestSum > runningSum) {
            lowestSum = runningSum
        }
    }

    println(lowestSum)
}