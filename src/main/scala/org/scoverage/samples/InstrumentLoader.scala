package org.scoverage.samples

import scala.util.Random
import java.util.Date
import org.apache.commons.io.IOUtils
import scala.jdk.CollectionConverters._

object InstrumentLoader {

  // this is here just to show the single line per statement colouring
  val beautifulTopLevelVal =
    if (System.currentTimeMillis() > 0) "hello" else "goodbye"

  // testing new statements
  val loadTime = new Date()

  def randomInstrument: Instrument = Random.shuffle(instruments).head

  lazy val instruments = {
    IOUtils
      .readLines(
        getClass.getResourceAsStream("/org/scoverage/dow.csv"),
        "UTF-8"
      )
      .asScala
      .map(line => {
        val tokens = line.split(',')
        Instrument(tokens(0).trim, tokens(1).trim)
      })
      .toSet
  }
}
