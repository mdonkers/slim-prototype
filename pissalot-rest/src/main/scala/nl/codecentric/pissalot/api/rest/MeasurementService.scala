package nl.codecentric.pissalot.api.rest

import org.scalatra.ScalatraServlet
import org.scalatra.json.NativeJsonSupport
import org.scalatra.swagger.{Swagger, SwaggerSupport}
import org.json4s.{DefaultFormats, Formats}
import javax.xml.bind.annotation.XmlRootElement
import org.joda.time.LocalDateTime
import nl.codecentric.pissalot.model.Measurement
import nl.codecentric.pissalot.dao.MeasurementDAO

/**
 *
 * Hylke Stapersma (codecentric nl)
 * hylke.stapersma@codecentric.nl
 *
 */
class MeasurementService(implicit val swagger: Swagger) extends ScalatraServlet with NativeJsonSupport with SwaggerSupport {

  protected implicit val jsonFormats: Formats = DefaultFormats

  override protected val applicationName = Some("measurement")
  protected val applicationDescription = "Measurement service allow you to add new measurements"


  before() {
    contentType = formats("json")
  }

  val get = (apiOperation[String]("get")
    summary "get x"
    notes "none"
    parameter queryParam[Option[String]]("").description("none")
    )

  get("/", operation(get)) {
    Measurement("sensor-1", System.currentTimeMillis(), 30000L)
  }

  post("/", operation(get)) {
    val m = parsedBody.extract[Measurement]
    MeasurementDAO.add(m)
    "Something happened"
  }

}
