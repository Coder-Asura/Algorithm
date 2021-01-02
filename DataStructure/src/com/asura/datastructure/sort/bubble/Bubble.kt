package com.asura.datastructure.sort.bubble

/**
 * http://ddrv.cn/docs/SortingAlgorithm/1.bubbleSort.html
 * 冒泡排序算法的原理如下：
 * 1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2、对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 3、针对所有的元素重复以上的步骤，除了最后一个。
 * 4、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
class Bubble<T : Comparable<T>> {
    fun sort(a: Array<T>): Array<T> {
        println(a.contentToString())
        println("---------start----------")
        var index = 1
        for (i in a.size - 1 downTo 1) {
            for (j in 0 until i) {
                //(n-1)+(n-2)+(n-3)+...+3+2+1=n*(n-1)/2=n*n/2-n/2
                if (greater(a[j], a[j + 1])) {
                    //(n-1)+(n-2)+(n-3)+...+3+2+1=n*(n-1)/2=n*n/2-n/2
                    exchange(a, j, j + 1)
                    println("-------------------$index")
                    index++
                }
            }
            println(a)
        }
        println("---------end----------")
        println(a.contentToString())
        return a
    }

    fun sort2(a: Array<T>): Array<T> {
        println(a.contentToString())
        println("---------start----------")
        var index = 1
        // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
        // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
        var flag = true
        for (i in a.size - 1 downTo 1) {
            for (j in 0 until i) {
                //(n-1)+(n-2)+(n-3)+...+3+2+1=n*(n-1)/2=n*n/2-n/2
                if (greater(a[j], a[j + 1])) {
                    //(n-1)+(n-2)+(n-3)+...+3+2+1=n*(n-1)/2=n*n/2-n/2
                    exchange(a, j, j + 1)
                    println("-------------------$index")
                    index++
                    flag = false
                }
            }
            println(a.contentToString())
            if (flag) {
                println("unnecessary sort")
                break
            }
        }
        println("---------end----------")
        println(a.contentToString())
        return a
    }

    private fun greater(v: T, w: T): Boolean {
        return v > w //v.compareTo(w)
    }

    private fun exchange(a: Array<T>, i: Int, j: Int) {
        val temp = a[i]
        a[i] = a[j]
        a[j] = temp
    }
}
