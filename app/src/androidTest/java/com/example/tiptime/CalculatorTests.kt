package com.example.tiptime

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorTests {

    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_default_tip() {
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00"))

        onView(withId(R.id.calculate_button)).perform(scrollTo()).perform(click())

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("10.00"))))
    }

    @Test
    fun calculate_18_tip() {
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00"))

        onView(withId(R.id.option_eighteen_percent)).perform(scrollTo()).perform(click())
        onView(withId(R.id.calculate_button)).perform(scrollTo()).perform(click())

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("9.00"))))
    }

    @Test
    fun calculate_15_tip() {
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00"))

        onView(withId(R.id.option_fifteen_percent)).perform(scrollTo()).perform(click())
        onView(withId(R.id.calculate_button)).perform(scrollTo()).perform(click())

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("8.00"))))
    }

    @Test
    fun calculate_noInput_tip() {
        onView(withId(R.id.calculate_button)).perform(scrollTo()).perform(click())

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("0.00"))))
    }

    @Test
    fun calculate_20_tip_NoRoundUp() {
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("51.00"))

        onView(withId(R.id.round_up_switch)).perform(scrollTo()).perform(click())

        onView(withId(R.id.calculate_button)).perform(scrollTo()).perform(click())

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("10.20"))))
    }

    @Test
    fun calculate_18_tip_NoRoundUp() {
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("51.00"))

        onView(withId(R.id.round_up_switch)).perform(scrollTo()).perform(click())

        onView(withId(R.id.option_eighteen_percent)).perform(scrollTo()).perform(click())
        onView(withId(R.id.calculate_button)).perform(scrollTo()).perform(click())

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("9.18"))))
    }

    @Test
    fun calculate_15_tip_NoRoundUp() {
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("51.00"))

        onView(withId(R.id.round_up_switch)).perform(scrollTo()).perform(click())

        onView(withId(R.id.option_fifteen_percent)).perform(scrollTo()).perform(click())
        onView(withId(R.id.calculate_button)).perform(scrollTo()).perform(click())

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("7.65"))))
    }

    @Test
    fun calculate_noInput_tip_NoRoundUp() {
        onView(withId(R.id.calculate_button)).perform(scrollTo()).perform(click())

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("0.00"))))
    }

}