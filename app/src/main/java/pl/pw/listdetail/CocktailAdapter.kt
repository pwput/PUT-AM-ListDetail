package pl.pw.listdetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import pl.pw.listdetail.domain.Cocktail

class CocktailAdapter(private val cocktailList: List<Cocktail>, private val itemClickListener: OnItemClickListener): Adapter<CocktailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_cocktail_list_recyclerview_item,parent,false))
    }

    override fun getItemCount(): Int {
        return  cocktailList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cocktail = cocktailList[position]
        val nameTextView = holder.nameTextView
        val imageView =  holder.imageView

        imageView.setImageResource(cocktail.imgResId)
        nameTextView.text = cocktail.name

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(position)
        }
    }



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTextView: TextView = itemView.findViewById(R.id.fragment_cocktail_list_recyclerview_item_name)
        val imageView: ImageView = itemView.findViewById(R.id.fragment_cocktail_list_recyclerview_item_image)

    }
}