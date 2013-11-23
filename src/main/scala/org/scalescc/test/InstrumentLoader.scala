package org.scalescc.test

import org.apache.commons.io.IOUtils
import scala.collection.JavaConverters._
import scala.util.Random

/** @author Stephen Samuel */
object InstrumentLoader {

  def randomInstrument: Instrument = Random.shuffle(InstrumentLoader.instruments).head

  lazy val instruments =
    IOUtils.readLines(getClass.getResourceAsStream("dow.csv"), "UTF-8").asScala
      .map(line => {
      val tokens = line.split(',')
      Instrument(tokens(0).trim, tokens(1).trim)
    }).toSet
}
