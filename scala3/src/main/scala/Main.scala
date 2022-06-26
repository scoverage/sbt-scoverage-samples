@main
def hello(): Unit = {
  val isScala3 = true
  println("Hello world!")
  println(msg(isScala3))
}

def msg(isScala3: Boolean): String = {
  if (isScala3) {
    "I was compiled by Scala 3. :)"
  } else {
    "I was compiled by Scala 2. :)"
  }
}
