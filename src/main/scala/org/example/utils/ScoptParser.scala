package org.example.utils

import scopt.OptionParser

trait ScoptParser {

  val parser: OptionParser[ScoptConfig] = new scopt.OptionParser[ScoptConfig]("RMReplicator") {
    opt[String]('s', "batch size").optional().text("defines the size of the batch")
      .action { (x, c) => c.copy(batchSize = x.toInt) }
    opt[String]('p', "batch step").optional().text("defines the size of the batch step")
      .action { (x, c) => c.copy(batchStep = x.toInt) }
    opt[String]('t', "batch type").optional().text("defines the type of batch identifier")
      .action { (x, c) => c.copy(batchKeyType = x.toLowerCase) }
  }
}
