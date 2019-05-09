
package com.mytaxi.android_demo;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Login {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void login() {

        onView(withId(R.id.edt_username))
                .perform(typeText("crazydog335"), closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText("venture"), closeSoftKeyboard());
        onView(withId(R.id.btn_login))
                .perform(click());

        Thread.sleep(2000);
        onView(allOf(withId(R.id.textSearch), isDisplayed()))
                .perform(typeText("sa"),closeSoftKeyboard());
        onView(withText("Sarah Scott"))
                .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                .perform(click());
        onView(withId(R.id.fab))
                .perform(click());

    }
}
