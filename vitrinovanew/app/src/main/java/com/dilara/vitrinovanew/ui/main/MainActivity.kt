package com.dilara.vitrinovanew.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import com.dilara.vitrinovanew.R
import com.dilara.vitrinovanew.ui.main.discover.DiscoverFragment
import com.dilara.vitrinovanew.ui.main.products_detail.ProductDetailFragment
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var toggle:ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        drawer()

    }

    private fun initView(){
        val discoverFragment= DiscoverFragment()
        replaceFragment(discoverFragment)
    }


    private fun replaceFragment(fragment: Fragment){

    supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout,fragment,"DiscoverFragment")
        }.commit()

    }


    fun loadFragment(fragment: Fragment?, tag:String):Boolean{
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frameLayout,fragment,tag)
                .addToBackStack(tag)
                .commit()
            return true
        }
        return false
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        for(fragment in supportFragmentManager.fragments){
            fragment.onActivityResult(requestCode,resultCode,data)
        }
    }


    fun drawer(){
        val drawerLayout:DrawerLayout=findViewById(R.id.drawerlayout)
        val navView:NavigationView=findViewById(R.id.nav_view)

        toggle= ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.new_product-> Toast.makeText(applicationContext,"Clicked new product",Toast.LENGTH_LONG).show()
                R.id.category->Toast.makeText(applicationContext,"Clicked category",Toast.LENGTH_LONG).show()
                R.id.collection-> Toast.makeText(applicationContext,"Clicked collection",Toast.LENGTH_LONG).show()
                R.id.editorshowcase->Toast.makeText(applicationContext,"Clicked editor show case",Toast.LENGTH_LONG).show()
                R.id.showcase->Toast.makeText(applicationContext,"Clicked showcase",Toast.LENGTH_LONG).show()
                R.id.nav_login -> Toast.makeText(applicationContext,"Clicked login",Toast.LENGTH_LONG).show()
            }
            true
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}