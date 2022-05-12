package com.example.noveltoon

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.noveltoon.databinding.ActivityNavigationBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar


class Navigation : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNavigationBinding
    private var btnMain: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarNavigation.toolbar)

        binding.appBarNavigation.toolbar.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_navigation)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        btnMain = findViewById<View>(R.id.button_main) as Button?
        btnMain!!.setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    applicationContext,
                    BookMainActivity::class.java
                )
            )
        }
    }

//    buat click navigasi mantab
//    override fun onOptionsItemSelected(item: Item): Boolean {
//        // Handle item selection
//        when (Item()) {
//            case R.id.nav_home:
//                home();
//                return true;
//            case R.id.nav_profile:
//                profile();
//                return true;
//            case R.id.nav_logout:
//                finish();
//                return true;
//            default:
//                return super.onOptionsItemSelected(Item);
//        }
//    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_navigation)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: NavigationView): Boolean {
//        return when(item.){
//            R.id.action_settings -> {
//                true
//            }
//            R.id.nav_logout -> {
//                signOut()
//                true
//            }
//            else -> return super.onOptionsItemSelected(item)
//        }
//    }
//
//    private fun signOut(){
//        MySharedPreferences.clearToken()
//        startSplashScreenActivity()
//    }
}