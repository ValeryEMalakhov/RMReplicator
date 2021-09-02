package org.example.replicator

import org.apache.spark.sql.DataFrame
import org.example.dal.RedshiftExecutable
import org.example.metastore.BatchDispenserCore
import org.example.reader.HiveReader
import org.example.utils.ScoptConfig

class DataReplicator(scoptConfig: ScoptConfig) extends ReplicatorUtils {

  private lazy val dataReader = new HiveReader {}
  private lazy val redshfit = new RedshiftExecutable {}
  private lazy val batchDispenser = new BatchDispenserCore {
    override val batchType: String = scoptConfig.batchKeyType
  }

  override def run() = {
    val batchIds =  batchDispenser.getBatches(getStartRange, scoptConfig.batchSize, scoptConfig.batchStep)
    val resultDF = dataReader.readData(batchIds)
    // add validation or/and aggregation methods if required
    uploadResultToRedshift(resultDF)
  }

  private def getStartRange: String = {
    val redshiftQuery = redshfit.getQueryFromResource("sql/get_last_batch_id.sql")
    redshfit.getSingleColumnListQuery(redshiftQuery, "rId").head.toString
  }

  private def uploadResultToRedshift(df: DataFrame): Unit ={
    // upload to Redshift
    // move to class RedshiftExecutable OR create class SparkExecutable if more methods appear here
  }
}
