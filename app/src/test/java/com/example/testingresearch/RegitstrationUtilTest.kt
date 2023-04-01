package com.example.testingresearch

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegitstrationUtilTest{

    @Test
    fun `empty username returns false`(){
        val result = RegistrationUtil.checkIsValidRegistration(
            "","123","123")

        assertThat(result).isFalse()
    }

    @Test
    fun `username already exist return false`(){
        val result = RegistrationUtil.checkIsValidRegistration(
            "cooper","123","123")

        assertThat(result).isFalse()
    }
    @Test
    fun `valid username and password and confirm password doesnt match return false`(){
        val result = RegistrationUtil.checkIsValidRegistration(
            "sam","123","12773")
        assertThat(result).isFalse()
    }
    @Test
    fun `password contains less than 2 digits return  false`(){
        val result = RegistrationUtil.checkIsValidRegistration(
            "sam","ass","ass")
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password return  true`(){
        val result = RegistrationUtil.checkIsValidRegistration(
            "sam","ass555","ass555")
        assertThat(result).isTrue()
    }


}