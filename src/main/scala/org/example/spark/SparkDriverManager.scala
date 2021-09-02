package org.example.spark

import com.typesafe.scalalogging.LazyLogging
import org.apache.spark.sql.SparkSession
import org.example.utils.ConfigHelper

import java.io.File

trait SparkDriverManager extends ConfigHelper with LazyLogging {

  private val warehouseLocation = new File("spark-warehouse").getAbsolutePath

  private lazy val spark = SparkSession
    .builder()
    .config("spark.driver.memory", "6G")
    .config("spark.executor.memory", "6G")
    .config("spark.ui.enabled", "false")
    .config("spark.sql.warehouse.dir", warehouseLocation)
    .appName(config.getString("app.name"))
    .master(config.getString("spark.master"))
    .enableHiveSupport()
    .getOrCreate()

  def initSparkSession: SparkSession = spark
}
