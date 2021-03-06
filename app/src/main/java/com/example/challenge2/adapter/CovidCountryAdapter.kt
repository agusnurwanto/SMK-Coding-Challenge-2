package com.example.challenge2.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.challenge2.R
import com.example.challenge2.item.CovidCountryItem
import com.example.challenge2.session.SessionCountry
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.covid_country_item.*
import java.util.*

class CovidCountryAdapter(private val context : Context, private val items :
List<CovidCountryItem>, private val listener : (CovidCountryItem)-> Unit) :
    RecyclerView.Adapter<CovidCountryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(context, LayoutInflater.from(context).inflate(
            R.layout.covid_country_item,
            parent, false))
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position), listener)
    }
    class ViewHolder(val context : Context, override val containerView : View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer{
        @SuppressLint("SetTextI18n")
        fun bindItem(item: CovidCountryItem, listener: (CovidCountryItem) -> Unit) {
            val date = Date(item.attributes.lastUpdate)
            txtCountryNegara.text = item.attributes.countryRegion
            txtCountryPositif.text = item.attributes.confirmed.toString()
            txtCountrySembuh.text = item.attributes.recovered.toString()
            txtCountryMeninggal.text = item.attributes.deaths.toString()
            txtLastUpdate.text = java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(date)
            containerView.setOnClickListener { listener(item) }
        }
    }
}