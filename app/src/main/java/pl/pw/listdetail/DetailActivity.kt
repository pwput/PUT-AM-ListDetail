package pl.pw.listdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_COCKTAIL_ID = "id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val frag =
            supportFragmentManager.findFragmentById(R.id.detail_frag) as (CocktailDetailFragment)
        val cocktailId = intent.extras?.getLong(EXTRA_COCKTAIL_ID)
        frag.cocktailId = cocktailId
    }
}
