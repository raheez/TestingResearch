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
}