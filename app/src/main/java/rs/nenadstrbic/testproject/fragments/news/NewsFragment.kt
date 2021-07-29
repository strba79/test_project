package rs.nenadstrbic.testproject.fragments.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import rs.nenadstrbic.testproject.adapters.NewsAdapter
import rs.nenadstrbic.testproject.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dashboardViewModel: NewsViewModel
    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(NewsViewModel::class.java)
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        recyclerView = binding.recyclerNews
        recyclerView.layoutManager = LinearLayoutManager(binding.root.context)
        recyclerView.adapter = NewsAdapter()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}