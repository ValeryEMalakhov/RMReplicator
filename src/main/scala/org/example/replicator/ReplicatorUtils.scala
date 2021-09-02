package org.example.replicator

import com.typesafe.scalalogging.LazyLogging
import org.example.spark.SparkDriverManager
import org.example.utils.ConfigHelper

trait ReplicatorUtils extends Runnable with LazyLogging with ConfigHelper with SparkDriverManager
