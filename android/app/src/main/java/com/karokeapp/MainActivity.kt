package com.karokeapp

import com.facebook.react.ReactActivity
import com.facebook.react.ReactActivityDelegate
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.fabricEnabled
import com.facebook.react.defaults.DefaultReactActivityDelegate
import android.widget.Toast

class MainActivity : ReactActivity() {

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  override fun getMainComponentName(): String = "KarokeApp"

  /**
   * Returns the instance of the [ReactActivityDelegate]. We use [DefaultReactActivityDelegate]
   * which allows you to enable New Architecture with a single boolean flags [fabricEnabled]
   */
  override fun createReactActivityDelegate(): ReactActivityDelegate =
      DefaultReactActivityDelegate(this, mainComponentName, fabricEnabled)

  
  override fun onBackPressed() {
        val backButtonModule = reactNativeHost
            .reactInstanceManager
            .currentReactContext
            ?.getNativeModule(BackButtonModule::class.java)

        if (backButtonModule != null && backButtonModule.isCustomBackPressEnabled()) {
            // Custom back button behavior
            Toast.makeText(this, "Back button is disabled", Toast.LENGTH_SHORT).show()
        } else {
            // Default behavior
            super.onBackPressed()
        }
    }
}
