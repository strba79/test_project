package rs.nenadstrbic.testproject.fragments.symbol

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import rs.nenadstrbic.testproject.adapters.SymbolAdapter
import rs.nenadstrbic.testproject.databinding.FragmentSymbolBinding
import rs.nenadstrbic.testproject.fragments.base.BaseFragment
import rs.nenadstrbic.testproject.model.Symbol

class SymbolFragment : BaseFragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var homeViewModel: SymbolViewModel
    private var _binding: FragmentSymbolBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(SymbolViewModel::class.java)
        _binding = FragmentSymbolBinding.inflate(inflater, container, false)
        recyclerView = binding.recyclerSymbol
        recyclerView.layoutManager = LinearLayoutManager(binding.root.context)
        recyclerView.adapter = SymbolAdapter(parseXml())
        return binding.root
    }

    private fun parseXml(): List<Symbol>? {
        var symbols: List<Symbol>? =
            context?.assets?.let { xmlParser.parse(it.open("tt_symbol_list.xml")) };
        if (symbols != null) {
            Log.i("checkParsing", symbols.size.toString())
        }
        symbols?.get(13)?.let { Log.i("checkParsing", it.toString()) }
        return symbols
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}