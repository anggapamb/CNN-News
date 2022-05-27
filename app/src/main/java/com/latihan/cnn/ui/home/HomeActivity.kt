package com.latihan.cnn.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import com.crocodic.core.base.adapter.CoreListAdapter
import com.latihan.cnn.R
import com.latihan.cnn.base.activity.BaseActivity
import com.latihan.cnn.data.article.ArticleEntity
import com.latihan.cnn.databinding.ActivityHomeBinding
import com.latihan.cnn.databinding.ArticleItemBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {

    private var articleData = ArrayList<ArticleEntity?>()
    var isLoading: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLayoutRes(R.layout.activity_home)

        getTerbaru()

        observe()

        initView()

        binding.isLoading = isLoading

    }

    private fun initView() {
        binding.rvArticle.adapter =
            CoreListAdapter<ArticleItemBinding, ArticleEntity>(R.layout.article_item).initItem(articleData)
    }

    private fun observe() {
        binding.isLoading = true
        viewModel.dataArticle.observe(this) {
            Log.d("CheckDataTerbaru", "Terbaru: $it")
            articleData.clear()
            binding.rvArticle.adapter?.notifyDataSetChanged()

            articleData.addAll(it)
            binding.rvArticle.adapter?.notifyItemInserted(0)
            binding.isLoading = false
        }
    }

    private fun getTerbaru() {
        viewModel.listTerbaru()
    }
}