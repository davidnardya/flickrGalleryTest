package com.davidnardya.flickrgalleryapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.davidnardya.flickrgalleryapp.R
import com.davidnardya.flickrgalleryapp.adapter.RecyclerViewAdapter
import com.davidnardya.flickrgalleryapp.databinding.GalleryMainBinding
import com.davidnardya.flickrgalleryapp.factory.GalleryViewModelFactory
import com.davidnardya.flickrgalleryapp.viewmodel.GalleryViewModel
import kotlinx.android.synthetic.main.gallery_main.*
import kotlinx.coroutines.flow.collectLatest

class GalleryActivity : AppCompatActivity() {

    //Properties
    private lateinit var viewModel: GalleryViewModel
    private lateinit var binding: GalleryMainBinding
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingPage()
        initRecyclerView()
        getData()
    }

    private fun getData() {
        val viewModelFactory = GalleryViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(GalleryViewModel::class.java)

        lifecycleScope.launchWhenCreated {
            viewModel.getImageList().collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
    }

    private fun bindingPage() {
        binding = DataBindingUtil.setContentView(this, R.layout.gallery_main)
    }

    private fun initRecyclerView() {
        gallery_recyclerview.apply {
            layoutManager = GridLayoutManager(this@GalleryActivity, 3)
            setHasFixedSize(true)
            recyclerViewAdapter = RecyclerViewAdapter(this@GalleryActivity)
            adapter = recyclerViewAdapter
        }
    }
}
