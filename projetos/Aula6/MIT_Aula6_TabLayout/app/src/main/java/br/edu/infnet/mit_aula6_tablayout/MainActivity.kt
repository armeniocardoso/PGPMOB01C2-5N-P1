package br.edu.infnet.mit_aula6_tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //------------------------------------
        val tabLayout = this.findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = this.findViewById<ViewPager2>(R.id.viewPager)

        viewPager.adapter = TabAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab: TabLayout.Tab, position: Int ->

            viewPager.setCurrentItem(tab.position, true)
            val rotulos = arrayOf("Fornecedores", "Contatos", "Produtos")
            tab.setText(rotulos[position])

        }.attach()
    }
}