package com.riztech.vidiotest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.riztech.vidiotest.util.BaseDialogLoading

class MainActivity : AppCompatActivity() {
    private val dialogLoading: BaseDialogLoading by lazy {
        BaseDialogLoading().newInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)
    }

    public fun showDialogLoading() {
        if (!dialogLoading.isVisible)
            dialogLoading.show(supportFragmentManager, "Loading")
    }

    public fun hideDialogLoading() {
        if (dialogLoading.isVisible)
            dialogLoading.dismiss()
    }
}