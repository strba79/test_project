package rs.nenadstrbic.testproject.fragments.base

import androidx.fragment.app.Fragment
import rs.nenadstrbic.testproject.activities.base.BaseActivity

open class BaseFragment : Fragment() {
    val xmlParser by lazy {
        (activity as BaseActivity).activityComposition.xmlParser
    }
}