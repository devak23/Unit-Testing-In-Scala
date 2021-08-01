package matchers

import com.h2.services.CustomerService
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class StringSpec extends AnyFlatSpec with Matchers {
  val customerService: CustomerService = new CustomerService {}

  behavior of "Customer Service for Strings"

  it should "correctly match the customer email starting with first name" in {
    val (first, last, email, dateOfBirth) = ("John", "Smith", "johnsmith@gmail.com", "1982/12/31")

    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get

    customer.email.toString should startWith(first.toLowerCase)
  }

  it should "correctly match the customer email ending with .com" in {
    val (first, last, email, dateOfBirth) = ("John", "Smith", "johnsmith@gmail.com", "1982/12/31")

    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get

    customer.email.toString should endWith(".com")
  }
}
