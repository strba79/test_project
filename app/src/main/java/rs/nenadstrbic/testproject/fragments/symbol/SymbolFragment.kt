package rs.nenadstrbic.testproject.fragments.symbol

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import rs.nenadstrbic.testproject.adapters.SymbolAdapter
import rs.nenadstrbic.testproject.databinding.FragmentSymbolBinding

class SymbolFragment : Fragment() {

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
        recyclerView.adapter = SymbolAdapter()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}