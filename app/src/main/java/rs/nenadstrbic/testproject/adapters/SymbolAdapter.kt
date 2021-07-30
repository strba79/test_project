package rs.nenadstrbic.testproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import rs.nenadstrbic.testproject.R
import rs.nenadstrbic.testproject.model.Symbol

class SymbolAdapter(parseXml: List<Symbol>?) : RecyclerView.Adapter<MyViewHolder>() {
    private val symbolList = parseXml

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item_symbol, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tvListItem).text =
            symbolList?.get(position)?.name
    }

    override fun getItemCount(): Int {
        return symbolList!!.size
    }
}

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

}