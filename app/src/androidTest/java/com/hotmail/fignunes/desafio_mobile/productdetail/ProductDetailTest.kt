package com.hotmail.fignunes.desafio_mobile.productdetail

import android.content.Intent
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.hotmail.fignunes.desafio_mobile.R
import com.hotmail.fignunes.desafio_mobile.model.Product
import com.hotmail.fignunes.desafio_mobile.presentation.product.ProductActivity
import com.hotmail.fignunes.desafio_mobile.presentation.productdetail.ProductDetailActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.math.BigDecimal

@LargeTest
@RunWith(AndroidJUnit4::class)
class ProductDetailTest {

    companion object {
        val product = Product(
            "Pencil",
            12,
            10,
            "https://github.com/charleston10/test-android-nexaas/blob/master/assets/pencil.png?raw=true",
            BigDecimal(15.0),
            2,
            8,
            "Lorem ipsum dolor sit ..."
        )
    }

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(ProductDetailActivity::class.java, false, false)

    @Before
    fun setup() {
        val intent = Intent()
        intent.putExtra(ProductActivity.PRODUCT, product)
        activityTestRule.launchActivity(intent)
    }

    @Test
    fun fieldsVisible() {
        Thread.sleep(2000)

        onView(withId(R.id.buttonRemoveFromCart)).check(matches(isDisplayed()))
        onView(withId(R.id.productDetailName)).check(matches(isDisplayed()))
        onView(withId(R.id.productDetailPrice)).check(matches(isDisplayed()))
        onView(withId(R.id.productDetailStock)).check(matches(isDisplayed()))
        onView(withId(R.id.productDetailDescription)).check(matches(isDisplayed()))
    }
}