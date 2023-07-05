package com.example.quickaccess

import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat

class MainActivity : AppCompatActivity() {

    var list =
        listOf("nuevo texto mundo", "nuevo texto programacion", "nuevo texto primero programa")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun crear() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            val shortcut = ShortcutInfoCompat.Builder(this, "quickAccess")
                .setShortLabel(getString(R.string.name_long))
                .setLongLabel(getString(R.string.name_long))
                .setIcon(IconCompat.createWithResource(this, R.drawable.ic_launcher_foreground))
                .setIntent(Intent(Intent.ACTION_VIEW))
                .build()
            ShortcutManagerCompat.pushDynamicShortcut(this, shortcut)
        }
    }
}