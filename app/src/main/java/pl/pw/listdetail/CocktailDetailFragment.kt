package pl.pw.listdetail

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.google.android.material.color.MaterialColors
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CocktailDetailFragment : Fragment(R.layout.fragment_cocktail_detail) {

    private var imageRes: Int?= null
    companion object {
        const val ARG_NAME = "name"
        const val ARG_INGREDIENTS = "ingredients"
        const val ARG_METHOD = "method"
        const val ARG_IMAGE = "image"

        fun newInstance(name: String, ingredients: String, method: String, image: Int): CocktailDetailFragment {
            val fragment = CocktailDetailFragment()
            val args = Bundle()
            args.putString(ARG_NAME, name)
            args.putString(ARG_INGREDIENTS, ingredients)
            args.putString(ARG_METHOD, method)
            args.putInt(ARG_IMAGE, image)
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
        val cocktailIngredients = view.findViewById<TextView>(R.id.fragment_cocktail_detail_cocktail_igredients)
        val cocktailMethod = view.findViewById<TextView>(R.id.fragment_cocktail_detail_cocktail_method)
        val cocktailImage = view.findViewById<ImageView>(R.id.fragment_cocktail_detail_cocktail_image)
        val fab = view.findViewById<FloatingActionButton>(R.id.fragment_cocktail_detail_cocktail_fab)

        startAnimation(cocktailName)

        cocktailName.text = this.arguments?.getString(ARG_NAME)
        cocktailMethod.text = this.arguments?.getString(ARG_METHOD)
        cocktailIngredients.text = this.arguments?.getString(ARG_INGREDIENTS)
        imageRes = arguments?.getInt(ARG_IMAGE)
        imageRes?.let { cocktailImage.setImageResource(it) }
        fab.setOnClickListener { onFabClick() }

        if (savedInstanceState == null) {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                add<TimerFragment>(
                    R.id.fragment_cocktail_detail_timer_container,
                    "SS",
                    Bundle().apply {
                        putString(ARG_NAME, cocktailName.text.toString())
                        putString(ARG_METHOD, cocktailMethod.text.toString())
                        putString(ARG_INGREDIENTS, cocktailIngredients.text.toString())
                        imageRes?.let { putInt(ARG_IMAGE, imageRes!!) }
                    }
                )
            }
        }

    }

    private fun startAnimation(view: TextView){
        val startColor =
            MaterialColors.getColor(requireContext(), com.google.android.material.R.attr.colorPrimaryDark,
                requireContext().getColor(R.color.black))
        val endColor =
            MaterialColors.getColor(requireContext(), com.google.android.material.R.attr.colorOnBackground,
                requireContext().getColor(R.color.black))

        ObjectAnimator.ofArgb(view,"textColor", startColor, endColor).apply { repeatCount = 4
        repeatMode = ValueAnimator.REVERSE
        duration = 500}.start()
        }


    private fun onFabClick(){
        Toast.makeText(context,"Przesłanie listy składników do innej aplikacji",Toast.LENGTH_SHORT).show()
    }
}
