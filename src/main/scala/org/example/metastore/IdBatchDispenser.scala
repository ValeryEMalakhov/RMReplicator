package org.example.metastore

class IdBatchDispenser extends BatchDispenser {

  override def getBatches(startRange: StartRange, batchLimit: Int, batchStepSize: Int): List[BatchWindow] = {
    // Some calc for IDs, with step and LIMIT
    List(("", ""))
  }
}
