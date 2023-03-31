package com.example.testingresearch

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class HomeWorkTest{

    @Test
    fun `for n =0  return 0`(){
        val result = HomeWork.fib(0)
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `for n =1  return 1`(){
        val result = HomeWork.fib(1)
        assertThat(result).isEqualTo(1)
    }
    @Test
    fun `check if fibonacci sereis is working`(){
        val result = HomeWork.fib(5)
        assertThat(result).isEqualTo((HomeWork.fib(3)+HomeWork.fib(4)))
    }


    @Test
    fun `starting and closing braces are equal count returns true`(){
        val result = HomeWork.checkBraces("(a * b)")
        assertThat(result).isTrue()
    }

    @Test
    fun `starting and closing braces are not equal count returns false`(){
        val result = HomeWork.checkBraces("(a * b))")
        assertThat(result).isFalse()
    }
}