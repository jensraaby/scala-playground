package jensraaby.xmlprocessing

import org.scalatest.{FlatSpec, Matchers}


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

    bodyText should include("hello")
    bodyText should include("goodbye")
  }

  "paragraphs" should "return a collection of strings" in {
    val parser = new HtmlParser(basicHtml)
    val paragraphs = parser.paragraphs

    paragraphs.length shouldBe (2)
    paragraphs.head shouldBe ("hello")
    paragraphs.last shouldBe ("goodbye")
  }

  val htmlWithId =
    """
         <html>
         <head></head>
         <body>
          <h1 id="header" class="big">greetings</h1>
          <h2 id="subheader">this is a subheader</h2>
         </body>
         </html>
    """

  "cssClass" should "return the class attribute of the element with the given ID, or nothing" in {
    val parser = new HtmlParser(htmlWithId)

    val cssClassHeader = parser.cssClass("header")
    cssClassHeader shouldBe ("big")
  }

  it should "not return anything for a non-existent ID" in {
    val parser = new HtmlParser(htmlWithId)

    val cssClassHeader = parser.cssClass("somethingNonExistent")
    cssClassHeader shouldBe ("")
  }

}
