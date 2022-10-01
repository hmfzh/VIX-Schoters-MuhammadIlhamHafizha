package com.example.vix_schoters_muhammadilhamhafizha.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.widget.NestedScrollView
import com.example.vix_schoters_muhammadilhamhafizha.R
import com.example.vix_schoters_muhammadilhamhafizha.databinding.AppbarToolbarBinding
import com.example.vix_schoters_muhammadilhamhafizha.databinding.FragmentHomeNewsBinding
import com.example.vix_schoters_muhammadilhamhafizha.model.ArticleModel
import com.example.vix_schoters_muhammadilhamhafizha.ui.adapter.NewsAdapter
import com.example.vix_schoters_muhammadilhamhafizha.ui.detail.DetailActivity
import org.koin.dsl.module
import org.koin.androidx.viewmodel.ext.android.viewModel

val homeNewsModule = module {
    factory { HomeNewsFragment() }
}

class HomeNewsFragment : Fragment() {
    private lateinit var binding : FragmentHomeNewsBinding
    private lateinit var bindingToolbar : AppbarToolbarBinding
    private val viewModel: HomeNewsViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeNewsBinding.inflate(layoutInflater, container, false)
        bindingToolbar = binding.appbar
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        bindingToolbar.title = viewModel.title
        binding.listNews.adapter= newsAdapter
        viewModel.news.observe(viewLifecycleOwner,{
            if (viewModel.page == 1) newsAdapter.clear()
            newsAdapter.add(it.articles)
        })

        viewModel.message.observe(viewLifecycleOwner,{
            it?.let {
                Toast.makeText(requireContext(),it, Toast.LENGTH_SHORT).show()
            }
        })


        binding.scroll.setOnScrollChangeListener {
                v: NestedScrollView?, _: Int, scrollY: Int, _: Int, _: Int ->
            if (scrollY == v?.getChildAt(0)!!.measuredHeight - v.measuredHeight) {
                if (viewModel.page <= viewModel.total && viewModel.loadMore.value == false) viewModel.fetch()
            }
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