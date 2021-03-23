package com.example.fragmenttest

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.fragmenttest.ui.MainFragment
import org.junit.Test
import org.junit.runner.RunWith

// Annotate about test size in SMALL, MEDIUM, or LARGE

@RunWith(AndroidJUnit4::class)
class MainFragmentTest {

    // Define fake classes set to inject dependency into viewModel that this fragment depends on


    // Can launch a graphical fragment by following ways (graphical: attached to root view of the activity)
    val foo = FragmentScenario.launchInContainer(MainFragment::class.java)
    val bar = launchFragmentInContainer<MainFragment>()

    // Sample
    @Test
    fun textClickedEvent_incrementCount() {
        launchFragmentInContainer<MainFragment>()
        onView(withId(R.id.tvTextCount)).check(matches(withText("0")))
            .perform(click()).check(matches(withText("1")))
    }

    @Test
    fun recreateFragment() {
        val scenario = launchFragmentInContainer<MainFragment>()
        scenario.recreate()
    }

}