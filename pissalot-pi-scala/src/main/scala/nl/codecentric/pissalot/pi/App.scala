package nl.codecentric.pissalot.pi

import java.io.BufferedReader
import java.io.InputStreamReader
import com.pi4j.io.serial.SerialFactory
import com.pi4j.io.serial.SerialDataListener
import com.pi4j.io.serial.SerialDataEvent
import com.pi4j.io.serial.Serial
import org.joda.time.LocalDateTime
import org.joda.time.DateTime

object App {

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
        MessageHandler.process(event.getData())
      }
    })
    serial.open(Serial.DEFAULT_COM_PORT, 9600)
  }
}