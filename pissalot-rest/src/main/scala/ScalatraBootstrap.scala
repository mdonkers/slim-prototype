import nl.codecentric.pissalot.api.rest.{MeasurementSwagger, ResourceApp, MeasurementService}
import org.scalatra.LifeCycle
import javax.servlet.ServletContext

/**
 *
 * Hylke Stapersma (codecentric nl)
 * hylke.stapersma@codecentric.nl
 *
 */
class ScalatraBootstrap extends LifeCycle {

  implicit val swagger = new MeasurementSwagger

  override def init(context: ServletContext) {
    context.mount(new MeasurementService, "/measurement/*")
    context.mount(new ResourceApp, "/api-docs/*")
  }

}
