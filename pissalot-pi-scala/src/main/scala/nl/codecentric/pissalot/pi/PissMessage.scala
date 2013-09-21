package nl.codecentric.pissalot.pi

import com.pi4j.util.StringUtil

case class PissMessage(header: Int, sensorId: Int, duration: Int,messageNumber:Int,voltage:Int)

object PissMessage {

  def process(message: String) = {
    val messageParts = message.split(" ").map(_.trim());
    if (messageParts.length != 6) {
      throw new IllegalArgumentException("Message did not (only) contain the 6 elements expected :" + message)
    }
    if (!messageParts.forall(_.matches("\\d{1,2,3}"))) {
      throw new IllegalArgumentException("Message did contain an unexpected character :" + message)
    }
    val numericMessageParts = messageParts.map(Integer.valueOf)
    PissMessage(
      header = numericMessageParts(0),
      sensorId = numericMessageParts(3) + 256 * numericMessageParts(4),
      duration = numericMessageParts(1) + 256 * numericMessageParts(2),
      messageNumber = numericMessageParts(5) + 256 * numericMessageParts(6),
      voltage = numericMessageParts(7) + 256 * numericMessageParts(8))
  }

}