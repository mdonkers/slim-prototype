package nl.codecentric.pissalot.pi

import scala.collection.mutable.Map
import scala.util.Success
import scala.util.Failure
import dispatch._
import Defaults._

object MessageHandler {

  val lastProcessedMessage = Map[Int, String]()

  def process(message: String) = {
    try {
      val pissMessage = PissMessage.fromString(message)
      if (lastProcessedMessage(pissMessage.sensorId) != message) {
        send(pissMessage)
        lastProcessedMessage += (pissMessage.sensorId -> message)
      }
    } catch {
      case e: IllegalArgumentException => println("Illegal message:" + message);

    }
  }

  def send(message: PissMessage) = {
    val event = PissEvent.createFromMessage(message)
    if (event != null) {
      val host = url(Constants.BACKEND_URL)
      println(event.toJson)
      val post = host.POST.addHeader("Content-Type", "application/json").setBody(event.toJson())
      val response = Http(post OK as.String)
      response.onComplete {
        case Success(x) => println(x)
        case Failure(x) => x.printStackTrace()
      }
    }
  }

}