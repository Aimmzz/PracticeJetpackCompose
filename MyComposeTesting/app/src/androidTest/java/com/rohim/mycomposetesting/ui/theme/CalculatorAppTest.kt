package com.rohim.mycomposetesting.ui.theme

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import com.rohim.mycomposetesting.R

class CalculatorAppTest {
    //skenario
    // Memastikan perhitungan persegi panjang menghasilkan nilai yang benar.
    //Memastikan jika inputan salah, tidak dilakukan perhitungan.

//    UI Testing dengan createAndroidRule
//    @get:Rule
//    val composeTestRule = createComposeRule()


    //UI Testing dengan createComposeAndroidRule
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent { 
            MyComposeTestingTheme {
                CalculatorApp()
            }
        }
    }

//    UI Testing dengan createAndroidRule
//    @Test
//    fun calculate_area_of_rectangle_correct() {
//        composeTestRule.onNodeWithText("Masukkan panjang").performTextInput("3")
//        composeTestRule.onNodeWithText("Masukkan lebar").performTextInput("4")
//        composeTestRule.onNodeWithText("Hitung!").performClick()
//        composeTestRule.onNodeWithText("Hasil: 12.0").assertExists()
//    }

    //UI Testing dengan createComposeAndroidRule

    //positive case
    @Test
    fun calculate_area_of_rectangle_correct() {
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.enter_length))
            .performTextInput("3")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.enter_width))
            .performTextInput("4")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.count))
            .performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.result, 12.0))
            .assertExists()
    }

    //negative case
    @Test
    fun wrong_input_not_calculated() {
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.enter_length))
            .performTextInput("..2")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.enter_width))
            .performTextInput("4")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.count))
            .performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.result, 0.0))
            .assertExists()
    }
}