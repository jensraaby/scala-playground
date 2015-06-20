package jensraaby.xmlprocessing

import scala.xml._

/**
 * Created by jens on 20/06/2015.
 */
class HtmlParser(html: String) {


  val htmlElem = XML.loadString(html)


  def bodyText = {
    val pTags = htmlElem \ "body" \ "p"
    pTags.text
  }

  def paragraphs: Seq[String] = {
    val pTags = htmlElem \ "body" \ "p"
    pTags map (_.text)
  }
}
