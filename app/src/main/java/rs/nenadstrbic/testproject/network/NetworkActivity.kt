package rs.nenadstrbic.testproject.network

import android.os.AsyncTask
import android.preference.PreferenceManager
import org.xmlpull.v1.XmlPullParserException
import rs.nenadstrbic.testproject.R
import rs.nenadstrbic.testproject.activities.base.BaseActivity
import rs.nenadstrbic.testproject.model.Symbol
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class NetworkActivity : BaseActivity() {

    companion object {
        const val WIFI = "Wi-Fi"
        const val ANY = "Any"
        const val SO_URL = ""
        private var wifiConnected = false
        private var mobileConnected = false
        var refreshDisplay = true
        var sPref: String? = null
    }


    fun loadPage() {
        if (sPref.equals(ANY) && (wifiConnected || mobileConnected)) {
            DownloadXmlTask().execute(SO_URL)
        } else if (sPref.equals(WIFI) && wifiConnected) {
            DownloadXmlTask().execute(SO_URL)
        } else {
            // show error
        }
    }

    // Implementation of AsyncTask used to download XML feed from stackoverflow.com.
    private inner class DownloadXmlTask : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg urls: String): String {
            return try {
                loadXmlFromNetwork(urls[0])
            } catch (e: IOException) {
                resources.getString(R.string.connection_error)
            } catch (e: XmlPullParserException) {
                resources.getString(R.string.xml_error)
            }
        }
        override fun onPostExecute(result: String) {
        }
    }

    // Uploads XML from stackoverflow.com, parses it, and combines it with
// HTML markup. Returns HTML string.
    @Throws(XmlPullParserException::class, IOException::class)
    private fun loadXmlFromNetwork(urlString: String): String {
        // Checks whether the user set the preference to include summary text
        val pref: Boolean = PreferenceManager.getDefaultSharedPreferences(this)?.run {
            getBoolean("summaryPref", false)
        } ?: false

        val symbolList: List<Symbol> = downloadUrl(urlString)?.use { stream ->
            activityComposition.xmlParser.parse(stream)
        } ?: emptyList()
        return ""
    }

    // Given a string representation of a URL, sets up a connection and gets
// an input stream.
    @Throws(IOException::class)
    private fun downloadUrl(urlString: String): InputStream? {
        val url = URL(urlString)
        return (url.openConnection() as? HttpURLConnection)?.run {
            readTimeout = 10000
            connectTimeout = 15000
            requestMethod = "GET"
            doInput = true
            // Starts the query
            connect()
            inputStream
        }
    }

}