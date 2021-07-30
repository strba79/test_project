package rs.nenadstrbic.testproject.activities.main

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import rs.nenadstrbic.testproject.R
import rs.nenadstrbic.testproject.activities.base.BaseActivity
import rs.nenadstrbic.testproject.databinding.ActivityMainBinding
import rs.nenadstrbic.testproject.parser.XmlParser


class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var parser: XmlParser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        parser = activityComposition.xmlParser
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_symbol, R.id.navigation_news, R.id.navigation_info
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}