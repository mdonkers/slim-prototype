package nl.codecentric.pissalot.pi

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class AppTest extends FunSpec with ShouldMatchers{

  describe("The 'Hello world' string") {

    it("should contain 11 characters") {
      "Hello world" should have length (11)
    }

    it("should start with 'Hello'") {
      "Hello world" should startWith("Hello")
    }

    it("should end with 'world'") {
      "Hello world" should endWith("world")
    }

  }
}
