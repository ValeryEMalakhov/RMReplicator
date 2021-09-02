package org.example.metastore

import org.example.dal.RedshiftExecutable

abstract class BatchDispenserCore extends BatchDispenser {

  val batchType: String

  override def getBatches(startRange: StartRange, batchLimit: Int, batchStepSize: Int): List[BatchWindow] = {

    batchType match {
      case "id" => {
        val dispenser = new IdBatchDispenser
        dispenser.getBatches(startRange, batchLimit, batchStepSize)
      } // id as Int
      case "batch_id" => {
        val dispenser = new DateBatchDispenser
        dispenser.getBatches(startRange, batchLimit, batchStepSize)
      } // date in Timestamp
      case "dates" => {
        val dispenser = new DateBatchDispenser
        dispenser.getBatches(startRange, batchLimit, batchStepSize).map(b => tupleToDate(b._1, b._2))
      } // date as String
    }
  }
}
