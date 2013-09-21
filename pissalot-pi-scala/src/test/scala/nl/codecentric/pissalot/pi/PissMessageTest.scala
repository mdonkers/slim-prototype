package nl.codecentric.pissalot.pi

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class PissMessageTest extends FunSpec with ShouldMatchers {

  describe("PissMessage parsing") {

    it("should throw an exception on empty message String") {
      intercept[IllegalArgumentException] {
        PissMessage.fromString("")
      }
    }

    it("should throw an exception on message String with only 8 numbers") {
      intercept[IllegalArgumentException] {
        PissMessage.fromString("11 22 33 44 55 66 77 88")
      }
    }

    it("should throw an exception on message String with 10 numbers") {
      intercept[IllegalArgumentException] {
        PissMessage.fromString("11 22 33 44 55 66 77 88 99 111")
      }
    }

    it("should throw an exception when one of the numbers is greater than 255") {
      intercept[IllegalArgumentException] {
        PissMessage.fromString("11 22 33 44 256 66 77 88 99")
      }
    }

    it("should throw an exception on message String with 6 elements but containing not numeric characters") {
      intercept[IllegalArgumentException] {
        PissMessage.fromString("11 22 33 aa 55 66 77 88 99")
      }
    }

    it("should be able to parse 11 12 13 14 15 16 17 18 19") {
      val message = PissMessage.fromString("11 12 13 14 15 16 17 18 19")
      assert(message == PissMessage(11, 3854, 3340, 4368, 4882))
    }

  }
}
