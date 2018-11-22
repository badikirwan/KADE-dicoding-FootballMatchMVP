package com.badikirwan.dicoding.footballmatch

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.pressBack
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.badikirwan.dicoding.footballmatch.view.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun recycleViewShowTest() {
        Thread.sleep(3000)
        onView(withId(R.id.recycle_last_match)).check(matches(isDisplayed()))

        Thread.sleep(1000)
        onView(withId(R.id.recycle_last_match)).perform(scrollToPosition<RecyclerView.ViewHolder>(10))
        onView(withId(R.id.recycle_last_match)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(10, click()))

        Thread.sleep(1000)
    }

    @Test
    fun bottomNavigationViewTest() {
        Thread.sleep(1000)
        onView(withId(R.id.menu_last_match)).perform(click())

        Thread.sleep(1000)
        onView(withId(R.id.menu_next_match)).perform(click())

        Thread.sleep(1000)
        onView(withId(R.id.menu_favorite)).perform(click())

        Thread.sleep(1000)
    }

    @Test
    fun addFavorite() {
        Thread.sleep(1000)
        onView(withId(R.id.recycle_last_match)).check(matches(isDisplayed()))

        Thread.sleep(2000)
        onView(withId(R.id.recycle_last_match)).perform(scrollToPosition<RecyclerView.ViewHolder>(5))
        onView(withId(R.id.recycle_last_match)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))

        Thread.sleep(1000)
        onView(withId(R.id.add_to_favorite)).perform(click())

        Thread.sleep(2000)
        pressBack()
    }

}