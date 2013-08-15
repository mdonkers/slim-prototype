package nl.codecentric.pissalot.api.rest

import org.scalatra.swagger.{NativeSwaggerBase, Swagger}
import org.scalatra.{ScalatraFilter, ScalatraServlet}
import org.json4s.{DefaultFormats, Formats}

/**
 *
 * Hylke Stapersma (codecentric nl)
 * hylke.stapersma@codecentric.nl
 *
 */
class ResourceApp(implicit val swagger: Swagger) extends ScalatraServlet with NativeSwaggerBase {
  implicit override val jsonFormats: Formats = DefaultFormats
}
