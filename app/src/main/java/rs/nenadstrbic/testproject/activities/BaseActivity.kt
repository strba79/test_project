package rs.nenadstrbic.testproject.activities

import androidx.appcompat.app.AppCompatActivity
import rs.nenadstrbic.testproject.dependencyinjection.ActivityCompositionRoot

open class BaseActivity:AppCompatActivity() {
    val activityComposition get()= ActivityCompositionRoot()
}