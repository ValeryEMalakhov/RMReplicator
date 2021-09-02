package org.example.metastore

import com.typesafe.scalalogging.LazyLogging
import org.example.utils.DateUtils

trait BatchDispenser extends DateUtils with LazyLogging {

  type StartRange = String
  type EndRange = String
  type BatchWindow = (StartRange, EndRange)

  // lazy val SAFE_WINDOW = 8 * MINUTE_IN_MILLIS

  def getBatches(startRange: StartRange, batchLimit: Int, batchStepSize: Int): List[BatchWindow]
}
