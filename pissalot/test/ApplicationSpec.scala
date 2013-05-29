package test

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
class ApplicationSpec extends Specification {
  
  "Application" should {

    "return json when requesting all users" in {
      running(FakeApplication()) {
        val home = route(FakeRequest(GET, "/rest/users")).get

        status(home) must equalTo(OK)
        contentType(home) must beSome.which(_ == "application/json")
        contentAsString(home) must contain ("miel")
        contentAsString(home) must contain ("hylke")
      }
    }

    "render the index page for any other url" in {
      running(FakeApplication()) {
        val home = route(FakeRequest(GET, "/")).get
        
        status(home) must equalTo(OK)
        contentType(home) must beSome.which(_ == "text/html")
        contentAsString(home) must contain ("Pissalot Application")
      }

      running(FakeApplication()) {
        val home = route(FakeRequest(GET, "/some/random/url")).get

        status(home) must equalTo(OK)
        contentType(home) must beSome.which(_ == "text/html")
        contentAsString(home) must contain ("Pissalot Application")
      }
    }
  }
}
