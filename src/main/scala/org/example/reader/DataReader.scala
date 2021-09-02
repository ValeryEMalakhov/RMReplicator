package org.example.reader

import org.apache.spark.sql.DataFrame
import org.example.spark.SparkDriverManager
import org.example.utils.FileHelperUtils

trait DataReader extends SparkDriverManager with FileHelperUtils {

  def readData(batchIds: List[(String, String)]): DataFrame
}
