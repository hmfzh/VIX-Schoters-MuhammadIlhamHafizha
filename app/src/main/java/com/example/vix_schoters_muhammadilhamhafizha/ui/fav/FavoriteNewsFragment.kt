package com.example.vix_schoters_muhammadilhamhafizha.ui.fav

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.vix_schoters_muhammadilhamhafizha.databinding.AppbarToolbarBinding
import com.example.vix_schoters_muhammadilhamhafizha.databinding.FragmentFavoriteNewsBinding
import com.example.vix_schoters_muhammadilhamhafizha.model.ArticleModel
import com.example.vix_schoters_muhammadilhamhafizha.ui.adapter.NewsAdapter
import com.example.vix_schoters_muhammadilhamhafizha.ui.detail.DetailActivity
import com.google.android.ads.mediationtestsuite.activities.HomeActivity
import org.koin.dsl.module

val favoriteModule = module {
    factory { FavoriteNewsFragment() }
}

class FavoriteNewsFragment : Fragment() {

    private lateinit var binding : FragmentFavoriteNewsBinding
    private lateinit var bindingToolbar : AppbarToolbarBinding
    private val viewModel: FavoriteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentFavoriteNewsBinding.inflate(layoutInflater, container, false)
        bindingToolbar = binding.apptolbar
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        bindingToolbar.title = viewModel.title
        binding.listBookmark.adapter = newsAdapter
        viewModel.articles.observe(viewLifecycleOwner, {
            newsAdapter.clear()
            newsAdapter.add( it )
        })

        binding.imageView10.setOnClickListener {
            startActivity(Intent(requireContext(), HomeActivity::class.java))
            ActivityCompat.finishAffinity(requireActivity())
        }
    }

    private val newsAdapter by lazy {
        NewsAdapter(arrayListOf(), object : NewsAdapter.OnAdapterListener {
            override fun onClick(articleModel: ArticleModel) {
                startActivity(
                    Intent(requireActivity(), DetailActivity::class.java)
                        .putExtra("detail", articleModel)
                )
            }
        })
    }
}