package com.driuft.sharedlifecycle

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var shared : SharedPreferences
    private val listener = OnSharedPreferenceChangeListener{
        sharePreferences, key ->
        Toast.makeText(
            this,
            sharePreferences.getString(
                key,
                resources.getString(R.string.default_state)
            ),
            Toast.LENGTH_SHORT
        ).show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shared = this.getSharedPreferences(this.packageName, Context.MODE_PRIVATE)
        with(shared.edit()){
            putString(getString(R.string.current_lifecycle_state), "onCreate")

            apply()
        }

        // Read the state
        val currentState = shared.getString(
            getString(R.string.current_lifecycle_state),
            resources.getString(R.string.default_state)
        ) ?: resources.getString(R.string.default_state)

        // Log the state
        Log.d("Lifecycle: ", currentState)
        // Toast the state
        Toast.makeText(this, currentState, Toast.LENGTH_SHORT).show()
    }
    fun unregisterListener(){
        shared.unregisterOnSharedPreferenceChangeListener(listener)
    }

    override fun onStart() {
        super.onStart()
        with (shared.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onStart")
            apply()
        }

        // Read the state
        val currentState = shared.getString(
            getString(R.string.current_lifecycle_state),
            resources.getString(R.string.default_state)
        ) ?: resources.getString(R.string.default_state)

        // Log the state
        Log.d("Lifecycle: ", currentState)
        // Toast the state
        Toast.makeText(this, currentState, Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        with (shared.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onResume")
            apply()
        }
        // Read the state
        val currentState = shared.getString(
            getString(R.string.current_lifecycle_state),
            resources.getString(R.string.default_state)
        ) ?: resources.getString(R.string.default_state)

        // Log the state
        Log.d("Lifecycle: ", currentState)
        // Toast the state
        Toast.makeText(this, currentState, Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        with (shared.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onPause")
            apply()
        }

        // Read the state
        val currentState = shared.getString(
            getString(R.string.current_lifecycle_state),
            resources.getString(R.string.default_state)
        ) ?: resources.getString(R.string.default_state)

        // Log the state
        Log.d("Lifecycle: ", currentState)
        // Toast the state
        Toast.makeText(this, currentState, Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()

        with (shared.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onStop")
            apply()
        }

        // Read the state
        val currentState = shared.getString(
            getString(R.string.current_lifecycle_state),
            resources.getString(R.string.default_state)
        ) ?: resources.getString(R.string.default_state)

        // Log the state
        Log.d("Lifecycle: ", currentState)
        // Toast the state
        Toast.makeText(this, currentState, Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        with (shared.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onRestart")
            apply()
        }

        // Read the state
        val currentState = shared.getString(
            getString(R.string.current_lifecycle_state),
            resources.getString(R.string.default_state)
        ) ?: resources.getString(R.string.default_state)

        // Log the state
        Log.d("Lifecycle: ", currentState)
        // Toast the state
        Toast.makeText(this, currentState, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterListener()
        with (shared.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onDestroy")
            apply()
        }

        // Read the state
        val currentState = shared.getString(
            getString(R.string.current_lifecycle_state),
            resources.getString(R.string.default_state)
        ) ?: resources.getString(R.string.default_state)

        // Log the state
        Log.d("Lifecycle: ", currentState)
        // Toast the state
        Toast.makeText(this, currentState, Toast.LENGTH_SHORT).show()
    }
}