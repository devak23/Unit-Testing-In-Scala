package com.h2.entities

object Email {
  val validDomains: List[String] = List("com","org","edu")
  def apply(value: String): Email = {
    val strings: Array[String] = value.split("@")
    val tooManyDots: Array[String] = value.split("\\.")
    if (strings.length < 2) {
      throw new IllegalArgumentException("invalid email: does not contain '@' symbol")
    }
    if (strings.length > 2) {
      throw new IllegalArgumentException("invalid email: should not contain '@' symbol more than once")
    }
    if (!validDomains.contains(strings(1).split("\\.")(1))) {
      throw new IllegalArgumentException("invalid email: email should belong to a valid domain")
    }

    if (tooManyDots.length > 5) {
      throw new IllegalArgumentException("invalid email:there are too may dots in the email")
    }
    new Email(strings(0), strings(1))
  }
}

class Email(val localPart: String, val domain: String) {
  override def toString: String = s"$localPart@$domain"
}