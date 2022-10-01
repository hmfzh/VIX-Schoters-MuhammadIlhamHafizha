package com.example.vix_schoters_muhammadilhamhafizha.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.vix_schoters_muhammadilhamhafizha.R
import com.example.vix_schoters_muhammadilhamhafizha.databinding.ActivityDetailBinding
import com.example.vix_schoters_muhammadilhamhafizha.databinding.AppbarToolbarBinding
import com.example.vix_schoters_muhammadilhamhafizha.model.ArticleModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.ext.android.viewModel

val detailModule = module {
    factory { DetailActivity() }
}

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    private lateinit var bindingToolbar : AppbarToolbarBinding
    private val viewModel: DetailViewModel by viewModel()

    private val detail by lazy {
        intent.getSerializableExtra("detail") as ArticleModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        bindingToolbar = binding.toolbar
        setContentView(binding.root)

        setSupportActionBar(bindingToolbar.container)
        supportActionBar!!.apply {
            title = ""
            setDisplayHomeAsUpEnabled(true)
        }

        detail.let {
            viewModel.find(it)
            val web = binding.webView
            web.loadUrl(it.url!!)
            web.webViewClient = object : WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    binding.progressDown.visibility = View.GONE
                }
            }
            val setting  = binding.webView.settings
            setting.javaScriptCanOpenWindowsAutomatically = false
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_favorite, menu)
        val menuBookmark = menu!!.findItem(R.id.action_favorite)
        menuBookmark.setOnMenuItemClickListener {
            viewModel.bookmark(detail)
            menuBookmark.setIcon(R.drawable.ic_favorite)
            true
        }
        viewModel.isBookmark.observe(this,{
            if (it == 0) menuBookmark.setIcon(R.drawable.ic_favorite_border)
            else menuBookmark.setIcon(R.drawable.ic_favorite)
        })
        return super.onCreateOptionsMenu(menu)
    }
}