package makoto.yoshida.uitesttutorial

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    private lateinit var title: String

    @Before
    fun initValidString() {
        title = "ホームタイトル"
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("makoto.yoshida.uitesttutorial", appContext.packageName)
    }

    @Test
    fun checkTitle() {
        Espresso
            .onView(ViewMatchers.withText("テストだよ"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())) // [1]

        Espresso
            .onView(ViewMatchers.withId(R.id.my_view))
            .perform(ViewActions.click()) // [2]
//        Espresso.onView(ViewMatchers.withId(R.id.my_view))
//            .check(ViewAssertions.matches(ViewMatchers.withText(title))) // [3]
    }
}