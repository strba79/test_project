package rs.nenadstrbic.testproject.recycler

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import rs.nenadstrbic.testproject.adapters.SymbolAdapter

class SwipeToDelete(var adapter: SymbolAdapter) :
    ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        var pos = viewHolder.adapterPosition
        adapter.deleteItem(pos)
    }
}