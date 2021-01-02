package com.asura.datastructure.sort.comparable.test

import com.asura.datastructure.sort.comparable.Student

fun main(args: Array<String>) {
    val student1 = Student(18, "Tom")
    val student2 = Student(20, "Jerry")
    println("$student1 和 $student2 对比，${max(student1, student2)} 更大")
}

private fun max(student1: Student, student2: Student): Student {
    val result = student1.compareTo(student2)
    return if (result < 0) {
        student2
    } else {
        student1
    }
}