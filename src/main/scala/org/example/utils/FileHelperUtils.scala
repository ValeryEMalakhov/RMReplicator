package org.example.utils

import scala.io.Source

trait FileHelperUtils {

  def getQueryFromResource(resourceName: String): String = {
    Source.fromInputStream(
      getClass.getResourceAsStream(resourceName)
    ).getLines.mkString(" ")
  }
}
