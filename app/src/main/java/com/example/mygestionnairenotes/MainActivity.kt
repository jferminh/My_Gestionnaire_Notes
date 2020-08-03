package com.example.mygestionnairenotes

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)

        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_note, R.id.navigation_etudiant, R.id.navigation_enseignant))
        setupActionBarWithNavController(navController, appBarConfiguration)

        mainViewModel.bottomNavigationVisibility.observe(this, Observer {navVisibility ->
            navView.visibility = navVisibility
        })

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){
                R.id.studentDetailFragment, R.id.studentAddFragment -> mainViewModel.hideBottomNav()
//                R.id.studentAddFragment -> mainViewModel.hideBottomNav()
                else -> mainViewModel.showBottomNav()
            }

        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}