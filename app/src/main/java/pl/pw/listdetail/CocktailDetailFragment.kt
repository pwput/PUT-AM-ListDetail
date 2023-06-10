package pl.pw.listdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit

class CocktailDetailFragment : Fragment(R.layout.fragment_cocktail_detail) {
    companion object {
        fun newInstance(route: String, description: String): CocktailDetailFragment {
            val fragment = CocktailDetailFragment()
            val args = Bundle()
            args.putString("route", route)
            args.putString("description", description)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(container?.context)
            .inflate(R.layout.fragment_cocktail_detail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val cocktailName = view.findViewById<TextView>(R.id.fragment_cocktail_detail_cocktail_name)
        val cocktailIgredients = view.findViewById<TextView>(R.id.fragment_cocktail_detail_cocktail_igredients)
        val cocktailMethod = view.findViewById<TextView>(R.id.fragment_cocktail_detail_cocktail_method)
//        val textView3 = view.findViewById<TextView>(R.id.detail_textview3)
//        val textView4 = view.findViewById<TextView>(R.id.detail_textview4)
        cocktailName.text = this.arguments?.getString("route")
        cocktailIgredients.text = this.arguments?.getString("description")

//        val sharedTime = requireActivity().getSharedPreferences("com.example.listdetail.shared",0)
//        textView3.text = "Best time: ${sharedTime.getString(textView.text.toString(), "None")}"
//        textView4.text = "Last time: ${sharedTime.getString("${textView.text.toString()} last", "None")}"

        if (savedInstanceState == null) {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                add<TimerFragment>(
                    R.id.fragment_cocktail_detail_timer_container,
                    "SS",
                    Bundle().apply { putString("route", cocktailName.text.toString()) }
                )
            }
        }

    }
}