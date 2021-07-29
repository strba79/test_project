package rs.nenadstrbic.testproject.fragments.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import rs.nenadstrbic.testproject.databinding.FragmentInfoBinding


class InfoFragment : Fragment() {

    private lateinit var infoViewModel: InfoViewModel
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        infoViewModel = ViewModelProvider(this).get(InfoViewModel::class.java)
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val webview = _binding!!.webView
        webview.settings.javaScriptEnabled = true
        webview.loadUrl("https://drive.google.com/file/d/10TlD9OlmR9jZSAPADM3Qo1aLQIEi43HH/view?usp=sharing")
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}