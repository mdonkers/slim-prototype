package nl.codecentric.pissalot.pi

import scala.util.Success
import scala.util.Failure
import dispatch._
import Defaults._
import java.io.BufferedReader
import java.io.InputStreamReader
import com.pi4j.io.serial.SerialFactory
import com.pi4j.io.serial.SerialDataListener
import com.pi4j.io.serial.SerialDataEvent
import com.pi4j.io.serial.Serial
import org.joda.time.LocalDateTime
import org.joda.time.DateTime

object App {

  val lastProcessedMessage = Map[Int,String]()

  def main(args: Array[String]) {
    println("Hello nl.codecentric.pissalot!")
    serialCommunication()
    var askQuestion = true;

    while (askQuestion) {
      println("Press 9 to exit")
      val input = new BufferedReader(new InputStreamReader(System.in));

      input.read() match {
        case '9' => askQuestion = false
      }
    }
  }

  def serialCommunication() = {
    println("Start listening to serial port")
    val serial = SerialFactory.createInstance();
    serial.addListener(new SerialDataListener() {
      def dataReceived(event: SerialDataEvent) = {
        process(event.getData())
      }
    })
    serial.open(Serial.DEFAULT_COM_PORT, 9600)
  }

  def process(message: String) = {
    try {
      val pissMessage=PissMessage.process(message)
      if (lastProcessedMessage(pissMessage.sensorId)!=message){
    	  //TODO : Set message
    	  send(pissMessage)
      }
    } catch {
      case e: IllegalArgumentException => println("Illegal message:" + message);

    }
  }
  
  def send(message:PissMessage)={
      val event = PissEvent.createFromMessage(message)
      if (event != null) {
        val host = url(Constants.BACKEND_URL)
        println(event.toJson)
        val post = host.POST.addHeader("Content-Type", "application/json") << event.toJson()
        val response = Http(post OK as.String)
        response.onComplete {
          case Success(x) => println(x)
          case Failure(x) => x.printStackTrace()
        }
      }
  }

}