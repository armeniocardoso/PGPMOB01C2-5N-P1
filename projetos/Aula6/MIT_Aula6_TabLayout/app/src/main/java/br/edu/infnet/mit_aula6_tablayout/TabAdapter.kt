package br.edu.infnet.mit_aula6_tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    val fragments = arrayOf(
        FornecedoresFragment(),
        ContatosFragment(),
        ProdutosFragment()
    )

    override fun getItemCount(): Int {

        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {

        return fragments[position]
    }
}
