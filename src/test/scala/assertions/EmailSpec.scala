package assertions

import com.h2.entities.Email
import org.scalatest.flatspec.AnyFlatSpec

class EmailSpec extends AnyFlatSpec {
  behavior of "Email Object"

  it should "correctly set the local part and domain part when passed in a correct email address" in {
    val myEmail = new Email(localPart = "abhayk", domain = "gmail.com")
    assert(myEmail.localPart == "abhayk")
    assert(myEmail.domain == "gmail.com")
  }

  it should "correctly print out email address in human readable form" in {
    val myEmail = new Email(localPart = "abhayk", domain = "gmail.com")
    assert("abhayk@gmail.com" == myEmail.toString)
  }

  it should "not accept email with multiple @ signs" in {
    assertThrows[IllegalArgumentException] {
      Email("abhayk@@gmail.com")
    }
  }

  it should "not accept emails without the @ sign" in {
    assertThrows[IllegalArgumentException] {
      Email("abhaykgmail.com")
    }
  }

  it should "throw an illegal argument exception for a domain of xxyyzzaa" in {
    val exception = intercept[IllegalArgumentException] {Email("abhayk@mymail.xxyyzzaa")}
    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("email should belong to a valid domain"))
  }

  it should "throw an error when it has many periods in the email address" in {
    assertThrows[IllegalArgumentException] {
      Email("a..b.a.y.k...@gmail.com")
    }
  }
}
