package org.example.utils

import java.text.SimpleDateFormat
import java.util.TimeZone

trait DateUtils {

  val HOUR_IN_MILLIS: Long = 3600 * 1000
  val MINUTE_IN_MILLIS: Long = 60 * 1000

  private val UTC_TMZ = TimeZone.getTimeZone("UTC")
  private val dateFormat = new SimpleDateFormat("yyyy-MM-dd")
  private val dateTimeFormatWithHours = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm")

  def getСurrentTimeMillis: Long = {
    System.currentTimeMillis
  }

  def getStringFromMillis(millis: Long): String = {
    dateFormat.format(millis)
  }

  def getMillisFromString(date: String): Long = {
    dateTimeFormatWithHours.setTimeZone(UTC_TMZ)
    dateTimeFormatWithHours.parse(date).getTime
  }

  def tupleToDate(firstDate: String, secondDate: String): (String, String) = {
    (getStringFromMillis(firstDate.toLong), getStringFromMillis(secondDate.toLong))
  }
}
