package com.latihan.cnn.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import com.crocodic.core.base.adapter.CoreListAdapter
import com.crocodic.core.extension.openActivity
import com.crocodic.core.extension.tos
import com.latihan.cnn.R
import com.latihan.cnn.base.activity.BaseActivity
import com.latihan.cnn.data.article.ArticleEntity
import com.latihan.cnn.databinding.ActivityHomeBinding
import com.latihan.cnn.databinding.ArticleItemBinding
import com.latihan.cnn.ui.webview.WebViewActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {

    private var articleData = ArrayList<ArticleEntity?>()
    private var isLoading: Boolean = true
    private var terbaru: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLayoutRes(R.layout.activity_home)

        getListArticle()

        swipeRefres()

        observe()

        initView()

        binding.isLoading = isLoading
        binding.terbaru = terbaru

    }

    private fun swipeRefres() {
        binding.swipeRefress.setOnRefreshListener {
            viewModel.listTerbaru()
            Handler(Looper.getMainLooper()).postDelayed({
                binding.swipeRefress.isRefreshing = false
            }, 2000)
        }
    }

    private fun initView() {
        binding.rvArticle.adapter =
            CoreListAdapter<ArticleItemBinding, ArticleEntity>(R.layout.article_item).initItem(articleData) { position, data ->  
                openActivity<WebViewActivity> {
                    putExtra("dataWEB", data?.link)
                }
            }
    }

    private fun observe() {
        binding.isLoading = true
        viewModel.dataArticle.observe(this) {
            Log.d("CheckDataTerbaru", "Terbaru: $it")
            articleData.clear()
            binding.rvArticle.adapter?.notifyDataSetChanged()

            articleData.clear()
            articleData.addAll(it)
            binding.rvArticle.adapter?.notifyItemInserted(0)
            binding.isLoading = false
        }
    }

    private fun getListArticle() {

        binding.chipTerbaru.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked) {
                viewModel.listTerbaru()
            }
        }

        binding.chipNasional.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked) {
                viewModel.listNasional()
            }
        }

        binding.chipInternasional.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked) {
                viewModel.listInternasional()
            }
        }

        binding.chipTeknologi.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked) {
                viewModel.listTeknologi()
            }
        }

        binding.chipEkonomi.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked) {
                viewModel.listEkonomi()
            }
        }

        binding.chipOlahraga.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked) {
                viewModel.listOlahraga()
            }
        }

        binding.chioGayaHidup.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked) {
                viewModel.listGayaHidup()
            }
        }

        binding.chipHiburan.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked) {
                viewModel.listHiburan()
            }
        }

    }

}