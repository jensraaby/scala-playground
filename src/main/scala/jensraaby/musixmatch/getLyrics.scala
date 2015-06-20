package musixmatch

import org.jmusixmatch.MusixMatch
import org.jmusixmatch.entity.track.TrackData

class GetLyrics(apiKey: String) {

  val mxmatch = new MusixMatch(apiKey)

  def getLyricsFor(title: String, artist: String) = {
    val track = mxmatch.getMatchingTrack(title, artist)
    println(track.getTrack.getAlbumName)
    println(s"trackId: ${track.getTrack.getTrackId()}")

    val lyrics = mxmatch.getLyrics(track.getTrack.getTrackId())
    println(lyrics.getLyricsBody)
  }


}


object TrackIdFinder extends App {
  private val apiKey: String = "something"
  val g = new GetLyrics(apiKey)
  g.getLyricsFor("Beat It", "Michael Jackson")
}
