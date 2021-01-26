package com.example.sbtechincaltest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sbtechincaltest.R
import com.example.sbtechincaltest.adapters.PhotosAdapter
import com.example.sbtechincaltest.viewmodels.PhotoViewModel
import kotlinx.android.synthetic.main.photo_fragment.*

class PhotoFragment : BaseFragment<PhotoViewModel>() {

    companion object {
        fun newInstance() = PhotoFragment()
    }

    override fun getViewModelClass(): Class<PhotoViewModel> = PhotoViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.photo_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val photoAdapter = context?.let { PhotosAdapter(it, mutableListOf()) }

        photos_toolbar.apply {
            setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
            setNavigationOnClickListener { activity?.onBackPressed() }
        }

        photos_recyclerView.apply {
            adapter = photoAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
        }

        //observe viewmodel
        viewModel.outputs.getAllPhotos().subscribe { items -> photoAdapter?.updateData(items)}.autoDispose()

    }
}