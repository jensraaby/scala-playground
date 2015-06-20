package jensraaby.xmlprocessing

import org.scalatest.{FlatSpec, Matchers, FunSuite}


/**
 * Created by jens on 20/06/2015.
 */
class HtmlParserTest extends FlatSpec with Matchers {

  val basicHtml =
    """
         <html>
         <head></head>
         <body>
          <p>hello</p>
          <p>goodbye</p>
         </body>
         </html>
    """

  "bodyText" should "return the text in the Html" in {
    val parser = new HtmlParser(basicHtml)
    val bodyText = parser.bodyText

    bodyText shouldBe ("hellogoodbye")
  }

  "paragraphs" should "return a collection of strings" in {
    val parser = new HtmlParser(basicHtml)
    val paragraphs = parser.paragraphs

    paragraphs.length shouldBe (2)
    paragraphs.head shouldBe ("hello")
    paragraphs.last shouldBe ("goodbye")
  }

}
