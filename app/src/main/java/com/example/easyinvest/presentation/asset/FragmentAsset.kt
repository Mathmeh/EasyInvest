package com.example.easyinvest.presentation.asset

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.easyinvest.databinding.FragmentAssetListBinding
import com.example.easyinvest.presentation.BaseFragment
import com.example.easyinvest.presentation.asset.RV.AssetAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentAsset : BaseFragment<FragmentAssetListBinding>() {

    private val fragmentAssetsViewModel: FragmentAssetViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAssetListBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val assetAdapter = AssetAdapter()

        binding.recyclerviewAssets.apply {
            adapter = assetAdapter
            layoutManager = LinearLayoutManager(context)
        }

        fragmentAssetsViewModel.assetsList.observe(viewLifecycleOwner) { assets ->
            assetAdapter.submitList(assets)
        }
    }
}
