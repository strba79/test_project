package rs.nenadstrbic.testproject.dependencyinjection

import rs.nenadstrbic.testproject.network.NetworkActivity
import rs.nenadstrbic.testproject.parser.XmlParser

class ActivityCompositionRoot {
    val xmlParser get()=XmlParser()
    val networkActivity get()=NetworkActivity()
}