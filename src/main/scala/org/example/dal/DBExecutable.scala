package org.example.dal

import com.typesafe.scalalogging.LazyLogging
import org.example.utils.ConfigHelper

trait DBExecutable extends LazyLogging with ConfigHelper {

  def executeQuery(query: String): Unit
}
