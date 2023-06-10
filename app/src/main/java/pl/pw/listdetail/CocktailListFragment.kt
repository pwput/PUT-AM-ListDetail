package pl.pw.listdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pl.pw.listdetail.domain.Cocktails

class CocktailListFragment : Fragment(R.layout.fragment_cocktail_list),OnItemClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(container?.context).inflate(R.layout.fragment_cocktail_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.fragment_cocktail_list_recycler_view)

        val adapter = CocktailAdapter(Cocktails.list, this)

        recyclerView.adapter = adapter
    }
    private fun replaceFragment(fragment: Fragment) {
        val smallestWidth = resources.configuration.smallestScreenWidthDp
        val fragmentTransaction = parentFragmentManager.beginTransaction()

        if (smallestWidth < 720)
            fragmentTransaction.replace(R.id.activity_main_fragment_container, fragment)
        else
            fragmentTransaction.replace(R.id.activity_main_detail_fragment, fragment)
        fragmentTransaction.commit()
    }

    override fun onItemClick(position: Int) {
            val name = Cocktails.list[position].name
            val method =  Cocktails.list[position].method
            val ingredients =  Cocktails.list[position].ingredients
            replaceFragment(CocktailDetailFragment.newInstance(name, ingredients, method))
    }
}
