package rs.nenadstrbic.testproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import rs.nenadstrbic.testproject.R

class SymbolAdapter() : RecyclerView.Adapter<MyViewHolder>() {
    val symbolList = listOf(
        "MSFT-Microsoft",
        "AMZN-Amazon.com",
        "GOOG-Alphabet Inc.",
        "WMT-Walmart Inc.",
        "MSFT-Microsoft",
        "AMZN-Amazon.com",
        "GOOG-Alphabet Inc.",
        "WMT-Walmart Inc.",
        "MSFT-Microsoft",
        "AMZN-Amazon.com",
        "GOOG-Alphabet Inc.",
        "WMT-Walmart Inc.",
        "MSFT-Microsoft",
        "AMZN-Amazon.com",
        "GOOG-Alphabet Inc.",
        "WMT-Walmart Inc."
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item_symbol, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tvListItem).text = symbolList[position]
    }

    override fun getItemCount(): Int {
        return symbolList.size
    }
}

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

}