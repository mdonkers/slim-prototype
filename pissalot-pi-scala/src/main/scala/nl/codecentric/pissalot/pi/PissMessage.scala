package nl.codecentric.pissalot.pi

import com.pi4j.util.StringUtil

case class PissMessage(header: Int, sensorId: Int, duration: Int, messageNumber: Int, voltage: Int)

object PissMessage {

  def fromString(message: String) = {
    val messageParts = message.split(" ").map(_.trim());
    if (messageParts.length != 9) {
      throw new IllegalArgumentException("Message did not (only) contain the 9 elements expected :" + message)
    }
    if (!messageParts.forall(_.matches("\\d{1,3}"))) {
      throw new IllegalArgumentException("Message did contain an unexpected character :" + message)
    }
    val numericMessageParts = messageParts.map(Integer.valueOf)
    if (!numericMessageParts.forall(x => x >= 0 && x <= 255)) {
      throw new IllegalArgumentException("Message did contain a value that was out of bounds :" + message)
    }

    PissMessage(
      header = numericMessageParts(0),
      sensorId = numericMessageParts(3) + 256 * numericMessageParts(4),
      duration = numericMessageParts(1) + 256 * numericMessageParts(2),
      messageNumber = numericMessageParts(5) + 256 * numericMessageParts(6),
      voltage = numericMessageParts(7) + 256 * numericMessageParts(8))
  }

}