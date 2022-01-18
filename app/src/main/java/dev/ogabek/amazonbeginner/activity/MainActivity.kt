package dev.ogabek.amazonbeginner.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import dev.ogabek.amazonbeginner.adapter.MainAdapter
import dev.ogabek.amazonbeginner.databinding.ActivityMainBinding
import dev.ogabek.amazonbeginner.model.Product

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    private lateinit var phoneProducts: ArrayList<Product>
    private lateinit var tvProducts: ArrayList<Product>
    private lateinit var laptopProducts: ArrayList<Product>

    private lateinit var allProducts: ArrayList<ArrayList<Product>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.tlMainTabLayout.addTab(mainBinding.tlMainTabLayout.newTab().setText("Phone"))
        mainBinding.tlMainTabLayout.addTab(mainBinding.tlMainTabLayout.newTab().setText("TV"))
        mainBinding.tlMainTabLayout.addTab(mainBinding.tlMainTabLayout.newTab().setText("Laptop"))

        phoneProducts = addPhones()
        tvProducts = addTVs()
        laptopProducts = addLaptops()

        allProducts = ArrayList()

        allProducts.add(phoneProducts)
        allProducts.add(tvProducts)
        allProducts.add(laptopProducts)

        mainBinding.rvMainRecyclerView.adapter = setAdapter(phoneProducts)
        mainBinding.rvMainRecyclerView.layoutManager = GridLayoutManager(this, 2);

        mainBinding.tlMainTabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    mainBinding.rvMainRecyclerView.adapter = setAdapter(allProducts[tab.position])
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    mainBinding.rvMainRecyclerView.adapter = setAdapter(allProducts[tab.position])
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    mainBinding.rvMainRecyclerView.adapter = setAdapter(allProducts[tab.position])
                }
            }

        })

    }

    private fun setAdapter(products: ArrayList<Product>): MainAdapter {
        return MainAdapter(products)
    }

    private fun addPhones(): ArrayList<Product> {
        return ArrayList<Product>().apply {
            for (i in 0..10) {
                this.add(
                    Product(
                        "Iphone 13 Pro Max",
                        "Telephone",
                        "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-13-pro-max-blue-select?wid=940&hei=1112&fmt=png-alpha&.v=1631652955000"
                    )
                )
            }
        }
    }

    private fun addTVs(): ArrayList<Product> {
        return ArrayList<Product>().apply {
            for (i in 0..10) {
                this.add(
                    Product(
                        "Apple TV 4K",
                        "TV",
                        "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/apple-tv-4k-hero-select-202104?wid=940&hei=1112&fmt=jpeg&qlt=80&.v=1619139498000"
                    )
                )
            }
        }
    }

    private fun addLaptops(): ArrayList<Product> {
        return ArrayList<Product>().apply {
            for (i in 0..10) {
                this.add(
                    Product(
                        "MacBook Pro M1 Max 64GB/8TB",
                        "Laptops",
                        "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/mbp16-spacegray-select-202110?wid=1808&hei=1686&fmt=jpeg&qlt=80&.v=1632788574000"
                    )
                )
            }
        }
    }
}