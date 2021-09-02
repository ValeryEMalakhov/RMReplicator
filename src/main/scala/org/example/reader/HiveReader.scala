package org.example.reader

import org.apache.spark.sql.DataFrame

class HiveReader extends DataReader {

  private val spark = initSparkSession

  import spark.implicits._

  override def readData(batchIds: List[(String, String)]): DataFrame = {

    logger.info("Downloading batch from Hive started: " + batchIds.map(_._2).mkString(", "))

    val result = batchIds.map { batchIdTuple =>
      val formattedQuery = getQueryFromResource("sql/get_data_from_hive.sql")
        .replaceAll("$startRange", batchIdTuple._1)
        .replaceAll("$endRange", batchIdTuple._2)

      spark.sql(formattedQuery)
    }
    result.reduce(_ union _)
  }
}
