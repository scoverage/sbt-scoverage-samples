class MySuite extends munit.FunSuite {
  test("the message") {
    val obtained = msg(true)
    val expected = "I was compiled by Scala 3. :)"

    assertEquals(obtained, expected)
  }
}
