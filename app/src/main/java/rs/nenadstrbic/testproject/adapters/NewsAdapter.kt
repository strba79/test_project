package rs.nenadstrbic.testproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import rs.nenadstrbic.testproject.R

class NewsAdapter() : RecyclerView.Adapter<MyViewHolderInfo>() {
    private val infoList = listOf(
        "Vest broj1",
        "Vest broj2",
        "Vest broj3",
        "Vest broj4",
        "Vest broj5",
        "Vest broj6",
        "Vest broj7",
        "Vest broj8",
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderInfo {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item_news, parent, false)
        return MyViewHolderInfo(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolderInfo, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tvListItem).text = infoList[position]
    }

    override fun getItemCount(): Int {
        return infoList.size
    }
}

class MyViewHolderInfo(view: View) : RecyclerView.ViewHolder(view) {

}