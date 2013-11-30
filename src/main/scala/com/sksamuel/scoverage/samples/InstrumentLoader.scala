package com.sksamuel.scoverage.samples

import org.apache.commons.io.IOUtils
import scala.collection.JavaConverters._
import scala.util.Random
import java.util.Date

/** @author Stephen Samuel */
object InstrumentLoader {

  val qqq = Instrument("sammy", "bobby")

  // this is here just to show the single line per statement colouring
  val beautifulTopLevelVal = if (System.currentTimeMillis() > 0) "hello" else "goodbye"

  // testing new statements
  val birthdate = new Date()

  def randomInstrument: Instrument = {
    Random.shuffle(InstrumentLoader.instruments).head
    qqq
  }

  lazy val instruments = {
    IOUtils.readLines(getClass.getResourceAsStream("/dow.csv"), "UTF-8").asScala
      .map(line => {
      val tokens = line.split(',')
      Instrument(tokens(0).trim, tokens(1).trim)
    }).toSet
  }
}
