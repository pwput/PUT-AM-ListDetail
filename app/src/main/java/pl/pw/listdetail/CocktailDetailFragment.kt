package pl.pw.listdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.add
import androidx.fragment.app.commit
import pl.pw.listdetail.domain.Coctails

class CocktailDetailFragment : Fragment() {
    var cocktailId: Long? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                add<TimerFragment>(
                    R.id.timer_container,
                    "SS"
                )
            }
        }
        else {
            cocktailId = savedInstanceState.getLong("cocktailId")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putLong("cocktailId", cocktailId!!)
    }

    override fun onStart() {
        super.onStart()
        view?.let {
            val title = requireView().findViewById<TextView>(R.id.textTitle)
            val cocktail = Coctails.list[cocktailId!!.toInt()]
            title.text = cocktail.name
            val description = requireView().findViewById<TextView>(R.id.textDescription)
            description.text = cocktail.recipe
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cocktail_detail, container, false)
    }
}
