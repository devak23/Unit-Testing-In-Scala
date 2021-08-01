package assertions

import com.h2.entities.Dollars
import org.scalatest.flatspec.AnyFlatSpec

class DollarsSpec extends AnyFlatSpec {

  behavior of "A Dollar Object"

  it should "create an Object of Dollars correctly" in {
    val tenDollars = new Dollars(amount = 10)
    assert("$10" == tenDollars.toString)
  }

  it should "correctly identify that $10 > $5" in {
    val tenDollars = new Dollars(amount = 10)
    val fiveDollars = new Dollars(amount = 5)

    assert(tenDollars > fiveDollars)
  }

  it should "correctly add $2 and $8 to make it $10" in {
    val twoDollars = new Dollars(amount = 2)
    val eightDollars = new Dollars(amount = 8)
    assertResult("$10") {
      (twoDollars + eightDollars).toString
    }
  }

  it should "correctly subtract $6 from $10 to give us $4" in {
    assertResult("$4") {
      (new Dollars(amount = 10) - new Dollars(amount = 6)).toString
    }
  }

  it should "correctly multiply $2 and $10 to give us $20" in {
    assertResult("$20") {
      (new Dollars(2) * new Dollars(10)).toString
    }

  }

  it should "correctly identify $4 as $4 (equality should pass)" in {
    val fourDollars = new Dollars(4)
    assertResult(true) {
      fourDollars === fourDollars
      fourDollars == new Dollars(4)
    }
  }
}
