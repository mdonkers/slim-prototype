package nl.codecentric.pissalot.api.rest

import org.scalatra.ScalatraServlet
import org.scalatra.json.NativeJsonSupport
import org.scalatra.swagger.{Swagger, SwaggerSupport}
import org.json4s.{DefaultFormats, Formats}
import javax.xml.bind.annotation.XmlRootElement
import org.joda.time.LocalDateTime
import nl.codecentric.pissalot.model.Measurement

/**
 *
 * Hylke Stapersma (codecentric nl)
 * hylke.stapersma@codecentric.nl
 *
 */
class MeasurementService(implicit val swagger: Swagger) extends ScalatraServlet with NativeJsonSupport with SwaggerSupport {

  protected implicit val jsonFormats: Formats = DefaultFormats

  override protected val applicationName = Some("measurement")
  protected val applicationDescription = "The flowershop API. It exposes operations for browsing and searching lists of flowers, and retrieving single flowers."


  before() {
    contentType = formats("json")
  }

  val get = (apiOperation[String]("get")
    summary "get x"
    notes "none"
    parameter queryParam[Option[String]]("").description("none")
    )

  get("/",operation(get)) {
    Measurement(user=None,bowl=null,start=new LocalDateTime(),end=new LocalDateTime())
  }

  post("/bla",operation(get)) {
    Measurement(user=None,bowl=null,start=new LocalDateTime(),end=new LocalDateTime())
  }
  
}
