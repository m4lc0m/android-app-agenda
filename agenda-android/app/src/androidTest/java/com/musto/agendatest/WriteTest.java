package com.musto.agendatest;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.Gravity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class WriteTest {

    private static final String userToBeTyped = "admin";
    private static final String pwdToBeTyped = "admin";
    private static final String nome = "writeTest";
    private static final String data = "10-07-19";
    private static final String ora = "10:00";
    private static final String descrizione = "writeTest";
    private static final String luogo = "writeTest";
    private static final String noteAggiuntive = "writeTest";

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void read_test() {

        onView(withId(R.id.editUsername))
                .perform(typeText(userToBeTyped), closeSoftKeyboard());
        onView(withId(R.id.editPass))
                .perform(typeText(pwdToBeTyped), closeSoftKeyboard());
        Intent resultData = new Intent();

        resultData.putExtra("username", userToBeTyped);
        resultData.putExtra("password", userToBeTyped);

        Instrumentation.ActivityResult result =
                new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);

        onView(withId(R.id.buttonLogin)).perform(click());

        onView(withId(R.id.drawer_layout)).check(matches(isClosed(Gravity.LEFT))).perform(DrawerActions.open());

        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_home));

        onView(withId(R.id.imageButtonEdit)).perform(click());

        onView(withId(R.id.edit_nome))
                .perform(typeText(nome), closeSoftKeyboard());
        onView(withId(R.id.edit_data))
                .perform(typeText(data), closeSoftKeyboard());
        onView(withId(R.id.edit_ora))
                .perform(typeText(ora), closeSoftKeyboard());
        onView(withId(R.id.edit_descrizione))
                .perform(typeText(descrizione), closeSoftKeyboard());
        onView(withId(R.id.edit_luogo))
                .perform(typeText(luogo), closeSoftKeyboard());
        onView(withId(R.id.edit_note))
                .perform(typeText(noteAggiuntive), closeSoftKeyboard());

        onView(withId(R.id.imageButtonSalva)).perform(click());

        onView(withId(R.id.imageButtonRefresh)).perform(click());

    }
}