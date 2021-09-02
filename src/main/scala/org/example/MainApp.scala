package org.example

import com.typesafe.scalalogging.LazyLogging
import org.example.commons.ScoptParser
import org.example.replicator.DataReplicator
import org.example.utils.{ScoptConfig, ScoptParser}

object MainApp extends App with LazyLogging with ScoptParser {

  parser.parse(args, ScoptConfig()) match {
    case Some(scoptConfig) => {
      val replicator = new DataReplicator(scoptConfig)
      replicator.run()
    }
    case None => {
      logger.error("Invalid input")
      System.exit(1)
    }
  }
}
