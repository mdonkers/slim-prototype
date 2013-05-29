package test

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

/**
 * add your integration spec here.
 * An integration test will fire up a whole play application in a real (or headless) browser
 */
class IntegrationSpec extends Specification {
  
  "Application" should {
    
    "work from within a browser" in {
      running(TestServer(9001), HTMLUNIT) { browser =>

        browser.goTo("http://localhost:9001/")

        browser.pageSource must contain("Pissalot Application")

        browser.pageSource must contain("angular.min.js")
       
      }
    }
    
  }
  
}
