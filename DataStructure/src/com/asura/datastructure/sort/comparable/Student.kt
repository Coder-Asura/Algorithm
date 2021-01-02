package com.asura.datastructure.sort.comparable

/**
 * 实现Comparable接口即可对比任意对象
 */
data class Student(val age: Int, val name: String) : Comparable<Student> {
    override fun compareTo(other: Student): Int {
        return age - other.age
    }
}

