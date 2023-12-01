package com.github.bvschaik.robolectricnfctest

import android.content.Context
import android.content.pm.PackageManager
import android.nfc.NfcAdapter
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows

@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest {
    @Test
    fun `Getting default NFC adapter should return non-null object`() {
        val context: Context = ApplicationProvider.getApplicationContext()
        Shadows.shadowOf(context.packageManager).setSystemFeature(PackageManager.FEATURE_NFC, true)

        assertNotNull(NfcAdapter.getDefaultAdapter(ApplicationProvider.getApplicationContext())) // returns adapter
        assertNotNull(NfcAdapter.getDefaultAdapter(ApplicationProvider.getApplicationContext())) // returns NULL on API 34!
        assertNotNull(NfcAdapter.getDefaultAdapter(ApplicationProvider.getApplicationContext())) // returns adapter
    }
}