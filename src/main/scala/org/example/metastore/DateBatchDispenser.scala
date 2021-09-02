package org.example.metastore

class DateBatchDispenser extends BatchDispenser {

  override def getBatches(startRange: StartRange, batchLimit: Int, batchStepSize: Int): List[BatchWindow] = {
    val batchStep = batchStepSize * HOUR_IN_MILLIS
    val currSafeHour = getСurrentTimeMillis - batchStep

    val idsList = for {curr <- startRange.toInt until currSafeHour by batchStep
                       } yield (curr.toString, (curr + batchStep).toString)
    idsList.toList.take(batchLimit)
  }
}
