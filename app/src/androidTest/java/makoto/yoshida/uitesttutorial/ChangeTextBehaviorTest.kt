package makoto.yoshida.uitesttutorial

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4


@RunWith(AndroidJUnit4::class)
@LargeTest
class ChangeTextBehaviorTest {

    private lateinit var title: String

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    @Before
    fun initValidString() {
        title = "ホームタイトル"
    }

    @Test
    fun checkTitle() {
        onView(withText("アプリのホーム画面です")).check(matches(isDisplayed())) // [1]
        onView(withId(R.id.my_view)).perform(click()) // [2]
        onView(withId(R.id.my_view))
            .check(matches(withText(title))) // [3]
    }
}
    