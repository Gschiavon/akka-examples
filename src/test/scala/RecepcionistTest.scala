import Recepcionist.Utils
import org.junit.runner.RunWith
import org.scalatest.{Matchers, WordSpec, FunSuite}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RecepcionistTest extends WordSpec with Matchers {


  "Recepcionist" should {

    "Result of checkAvailavility for room 1 " in {
      val expected = true
      val result = Utils.checkAvailability(1)
      result should be(expected)
    }

    "Result of checkAvailavility for room 2 " in {
      val expected = false
      val result = Utils.checkAvailability(2)
      result should be(expected)
    }
    "Result of checkAvailavility for room 3 " in {
      val expected = true
      val result = Utils.checkAvailability(3)
      result should be(expected)
    }
    "Result of checkAvailavility for room 4 " in {
      val expected = false
      val result = Utils.checkAvailability(4)
      result should be(expected)
    }
  }
}
