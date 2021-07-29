package rs.nenadstrbic.testproject.parser

import android.util.Xml
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import rs.nenadstrbic.testproject.model.Symbol
import java.io.IOException
import java.io.InputStream

private val ns: String? = null

class XmlParser {
    @Throws(XmlPullParserException::class, IOException::class)
    fun parse(inputStream: InputStream): List<Symbol> {
        inputStream.use { inputStream ->
            val parser: XmlPullParser = Xml.newPullParser()
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
            parser.setInput(inputStream, null)
            parser.nextTag()
            return readFeed(parser)
        }
    }
    @Throws(XmlPullParserException::class, IOException::class)
    private fun readFeed(parser: XmlPullParser): List<Symbol> {
        val symbols = mutableListOf<Symbol>()
        parser.require(XmlPullParser.START_TAG, ns, "symbols")
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.eventType != XmlPullParser.START_TAG) {
                continue
            }
            if (parser.name == "symbol") {
                symbols.add(readEntry(parser))
            } else {
                skip(parser)
            }
        }
        return symbols
    }

    @Throws(XmlPullParserException::class, IOException::class)
    private fun readEntry(parser: XmlPullParser): Symbol {
        parser.require(XmlPullParser.START_TAG, ns, "symbol")
        var name: String? = null
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.eventType != XmlPullParser.START_TAG) {
                continue
            }
            when (parser.name) {
                "name" -> name = readTitle(parser)
                else -> skip(parser)
            }
        }
        return Symbol(name)
    }

    @Throws(IOException::class, XmlPullParserException::class)
    private fun readTitle(parser: XmlPullParser): String {
        parser.require(XmlPullParser.START_TAG, ns, "name")
        val name = readText(parser)
        parser.require(XmlPullParser.END_TAG, ns, "name")
        return name
    }

    @Throws(IOException::class, XmlPullParserException::class)
    private fun readText(parser: XmlPullParser): String {
        var result = ""
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.text
            parser.nextTag()
        }
        return result
    }

    @Throws(XmlPullParserException::class, IOException::class)
    private fun skip(parser: XmlPullParser) {
        if (parser.eventType != XmlPullParser.START_TAG) {
            throw IllegalStateException()
        }
        var depth = 1
        while (depth != 0) {
            when (parser.next()) {
                XmlPullParser.END_TAG -> depth--
                XmlPullParser.START_TAG -> depth++
            }
        }
    }
}