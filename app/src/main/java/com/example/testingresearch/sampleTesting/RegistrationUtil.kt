package com.example.testingresearch.sampleTesting

object RegistrationUtil {

    /**
     *
     * when user name is not empty and password and confirm password matches
     * when user name is doesnt already exist and password and confirm password matches
     * when password and confirm password doesnt matches
     * when password contains less than 2 digits
     *
     */

    val listOfUsers = listOf<String>("ryan", "philip", "cooper", "raheez")
    fun checkIsValidRegistration(
        name: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        if (name.isEmpty()) {
            return false
        }

        if (listOfUsers.contains(name)) {
            return false
        }

        if (!password.equals(confirmPassword)) {
            return false
        }

        if (password.count { it.isDigit() } < 2) {
            return false
        }

        return true
    }
}