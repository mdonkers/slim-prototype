package nl.codecentric.pissalot.pi

import com.pi4j.util.StringUtil

case class PissEvent(sensorId: String, time: Long, durationInMs: Long) {
  def toJson() = {
    """{"sensorId":"%s","start":%d,"duration":%d}""".format(sensorId, time, durationInMs);
  }
}

object PissEvent {
  def createFromMessage(message: PissMessage) = {
    new PissEvent(Constants.RASPBERRY_PI_ID + "-" + message.sensorId, System.currentTimeMillis(), message.duration)
  }
}
