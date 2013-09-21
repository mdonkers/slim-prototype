package nl.codecentric.pissalot.dao

import spray.json.DefaultJsonProtocol
import nl.codecentric.pissalot.model.Measurement
import scala.concurrent.ExecutionContext

/**
 *
 * Hylke Stapersma (codecentric nl)
 * hylke.stapersma@codecentric.nl
 *
 */
object MeasurementDAO extends App {


  def add(measurement: Measurement) {

    import sprouch.synchronous._
    import sprouch.synchronous.dsl._
    import sprouch.JsonProtocol._

    val databaseName = "pissalot"

    import akka.actor.ActorSystem

    val actorSystem = ActorSystem("MeasurementPersistActor")

    import sprouch.Config
    import ExecutionContext.Implicits.global

    implicit val measurementFormat = DefaultJsonProtocol.jsonFormat3(Measurement)

    val config2 = Config(
      actorSystem,
      hostName = "localhost",
      port = 5984,
      userPass = Some("admin" -> "admin"),
      https = false
    )

    val couch = Couch(config2)

    implicit val db = try {
      couch.getDb(databaseName) //throws an exception if the database does not exist
    } catch {
      case _: sprouch.SprouchException =>
        couch.createDb(databaseName)
    }
    measurement.create
    actorSystem.shutdown()
  }


}
