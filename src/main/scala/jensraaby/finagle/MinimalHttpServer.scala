package jensraaby.finagle

import com.twitter.finagle.{Http, Service}
import com.twitter.util.{Await, Future}
import java.net.InetSocketAddress
import org.jboss.netty.handler.codec.http._

object MinimalHttpServer extends App {

//  create a service - it takes a Netty HttpRequest and returns a Future[HttpResponse]
  val service = new Service[HttpRequest, HttpResponse] {
    def apply(req: HttpRequest): Future[HttpResponse] =
      Future.value(new DefaultHttpResponse(
        req.getProtocolVersion, HttpResponseStatus.OK))
  }

  // an Http server just takes an address and a service
  val server = Http.serve(":8080", service)
  Await.ready(server)
}

object Client extends App {

  // clients are also services for HttpRequests!
  val client: Service[HttpRequest, HttpResponse] = Http.newService("www.google.com:80")

  // requests can be reused
  val request = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/")

  // nice - a service is a function that takes a request and gives a Future[Response!
  val response: Future[HttpResponse] = client(request)

  // this callback is the one which Scala's own Future API is based on
  response onSuccess { resp: HttpResponse =>
    println("GET success: " + resp)
  }

  Await.ready(response)
}

object Proxy extends App {

  val client = Http.newService("www.google.com:80")

  // wire up the service to a server:
  val server = Http.serve(":8080", client)

  Await.ready(server)
}