package com.hotmail.fignunes.desavio_mobile.presentation.movie

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.hotmail.fignunes.desafio_mobile.R
import com.hotmail.fignunes.desafio_mobile.presentation.product.ProductActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ProductTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(ProductActivity::class.java)

    @Test
    fun fieldsVisible() {
        onView(withText(activityTestRule.activity.getString(R.string.app_name))).check(matches(isDisplayed()))
        onView(withId(R.id.productTotal)).check(matches(isDisplayed()))
        onView(withId(R.id.productSubtotal)).check(matches(isDisplayed()))
        onView(withId(R.id.productShipping)).check(matches(isDisplayed()))
        onView(withId(R.id.productTax)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonCheckout)).check(matches(isDisplayed()))
        onView(withId(R.id.productRecyclerview)).check(matches(isDisplayed()))
        Thread.sleep(2000)
    }

    @Test
    fun callProductDetail() {
        Thread.sleep(2000)
        onView(withId(R.id.productRecyclerview)).perform(click())

        Thread.sleep(2000)

        val getRemoveFromCart = activityTestRule.activity.getString(R.string.remove_from_cart)
        onView(withId(R.id.buttonRemoveFromCart))
            .check(matches(withText(getRemoveFromCart)))
    }


}