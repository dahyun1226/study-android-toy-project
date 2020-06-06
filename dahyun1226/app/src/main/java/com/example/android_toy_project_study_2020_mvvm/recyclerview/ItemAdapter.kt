package com.example.android_toy_project_study_2020_mvvm.recyclerview


import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_toy_project_study_2020_mvvm.R
import com.example.android_toy_project_study_2020_mvvm.api.RepositoryDetailActivityController.Companion.intentFullName
import com.example.android_toy_project_study_2020_mvvm.ui.RepositoryDetailActivity
import kotlinx.android.synthetic.main.recyclerview_item.view.*


class ItemAdapter (private var items: ArrayList<GitItem>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val listener = View.OnClickListener {
            val intent = Intent(it.context,RepositoryDetailActivity::class.java)
            intent.putExtra(intentFullName,item.fullName)
            it.context.startActivity(intent)
        }
        holder.apply {
            bind(listener, item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(inflatedView)
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view = v
        fun bind(listener: View.OnClickListener, item: GitItem) {
            view.tv_recyclerview_item_FullName.text = item.fullName
            if (item.language == null) {
                view.tv_recyclerview_item_Language.text = view.context.getString(R.string.no_language)
            } else {
                view.tv_recyclerview_item_Language.text = item.language
            }
            view.setOnClickListener(listener)
            Glide.with(view).load(item.avatarUrl).into(view.iv_recyclerview_item_GitAvatarImage)
        }
    }

}