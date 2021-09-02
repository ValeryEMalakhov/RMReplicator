import sbt._

object Dependencies {

  val scala212 = "2.12.14"

  private val sparkVersion = "2.4.8"

  private val jdbcVersion          = "3.5.0"
  private val sparkRedshiftVersion = "4.2.0"

  private val scoptVersion = "4.0.1"
  private val configVersion = "1.4.1"

  private val scalaLoggingVersion = "3.9.4"

  private val sparkCore = "org.apache.spark" %% "spark-core" % sparkVersion
  private val sparkSQL  = "org.apache.spark" %% "spark-sql"  % sparkVersion
  private val sparkHive = "org.apache.spark" %% "spark-hive" % sparkVersion

  private val scalikejdbc   = "org.scalikejdbc"                    %% "scalikejdbc"    % jdbcVersion
  private val sparkRedshift = "io.github.spark-redshift-community" %% "spark-redshift" % sparkRedshiftVersion

  private val scopt         = "com.github.scopt" %% "scopt" % scoptVersion
  private val typesafeconfig = "com.typesafe"      % "config" % configVersion

  private val scalalogging = "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingVersion

  val spark = Seq(sparkCore, sparkSQL, sparkHive)
  val redshift = Seq(sparkRedshift, scalikejdbc)
  val utils = Seq(scopt, typesafeconfig, scalalogging)
}
