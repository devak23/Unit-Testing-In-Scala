package matchers

import com.h2.services.Currency
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class EqualitySpec extends AnyFlatSpec with Matchers {

  behavior of "Currency equal"

  it should "match two 10 USD currencies as equal when using the 'should equal' syntax" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 should equal(currency2)
  }

  it should "match two 10 USD currencies as equal when using the '===' syntax" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 === currency2
  }

  it should "match two 10 USD currencies as equal when using the 'shouldEqual' syntax" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 shouldEqual currency2
  }

  it should "match two 10 USD currencies as equal when using the 'shouldBe' syntax" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 shouldBe currency2
  }

  it should "match two 10 USD currencies as equal when using the 'should be' syntax" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 should be(currency2)
  }
}
