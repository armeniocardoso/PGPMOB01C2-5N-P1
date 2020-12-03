package br.edu.infnet.mitmob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var navController : NavController
    lateinit var navView : NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //------------------------------------
        drawerLayout = this.findViewById<DrawerLayout>(R.id.drawerLayout)
        
        navController = this.findNavController(R.id.fragment)
        navView = this.findViewById<NavigationView>(R.id.navView)
        //------------------------------------
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(navView, navController)
    }

    override fun onSupportNavigateUp(): Boolean {

        return NavigationUI.navigateUp(navController, drawerLayout)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var mensagem = ""
        when(item.itemId) {

            R.id.mnuOp1 -> mensagem = "Opção 1"
            R.id.mnuOp2 -> mensagem = "Opção 2"
            R.id.mnuOp3 -> mensagem = "Opção 3"
        }
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
        return true
    }
}