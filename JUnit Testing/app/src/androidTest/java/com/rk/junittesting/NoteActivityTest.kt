package com.rk.junittesting

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test

class NoteActivityTest {

    //It will start Note Activity
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(NoteActivity::class.java)

    @Test
    fun testSubmitButton_expectedCorrectValues() {
        onView(withId(R.id.edt_title)).perform(typeText("Hello"))
        onView(withId(R.id.edt_desc)).perform(typeText("World"), closeSoftKeyboard()) //closeSoftKeyboard() It must be used to close the keyboard

        onView(withId(R.id.btn_submit)).perform(click())
        onView(withId(R.id.tv_detail)).check(matches(withText("Title - Hello | Desc - World")))
    }

    @Test
    fun testSharedButton_expectedIntentChooser() {
        onView(withId(R.id.edt_title)).perform(typeText("Hello"))
        onView(withId(R.id.edt_desc)).perform(typeText("World"), closeSoftKeyboard()) //closeSoftKeyboard() It must be used to close the keyboard

        onView(withId(R.id.btn_submit)).perform(click())
        //above code just for redirection on NoteDetailActivity

        Intents.init()//Init first intent chooser
        val expected = allOf(hasAction(Intent.ACTION_CHOOSER))
        onView(withId(R.id.btn_share)).perform(click())
        Intents.intended(expected)
        Intents.release()

    }
}