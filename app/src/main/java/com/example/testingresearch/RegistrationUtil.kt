package com.example.testingresearch

object RegistrationUtil {

    /**
     *
     * when
     *
     */
    fun checkIsValidRegistration(name:String,
    password:String,
    confirmPassword :String):Boolean{
        if (name.isEmpty()){
            return false
        }else{
            return true
        }
    }
}