package dev.ogabek.amazonbeginner.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.ogabek.amazonbeginner.databinding.ItemViewLayoutBinding
import dev.ogabek.amazonbeginner.model.Product

class MainAdapter(private val products: ArrayList<Product>): RecyclerView.Adapter<MainAdapter.ProductViewHolder>() {


    class ProductViewHolder(val binding: ItemViewLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemViewLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val product = products[position]

        holder.binding.apply {
            Glide.with(ivProductPhoto.context).asBitmap().load(product.image).into(ivProductPhoto)
            tvTitleProduct.text = product.name
            tvCategoryProduct.text = product.category
        }

    }

    override fun getItemCount(): Int {
        return products.size
    }

}