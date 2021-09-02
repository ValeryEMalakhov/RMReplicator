package org.example.dal

import org.example.utils.FileHelperUtils
import scalikejdbc.{AutoSession, ConnectionPool, SQL}

import java.net.URI

class RedshiftExecutable extends DBExecutable with FileHelperUtils {

  private val redshiftRawUrl = config.getString("redshift.url")
  private val redshiftURI = new URI(redshiftRawUrl.replaceAll("jdbc:", ""))
  private val rsUserInfoArr = redshiftURI.getUserInfo.split(":")

  val baseUrl = "jdbc:redshift://" + redshiftURI.getHost + ":" +
    redshiftURI.getPort + redshiftURI.getPath + "?" + redshiftURI.getQuery
  val login = rsUserInfoArr(0)
  val pass = rsUserInfoArr(1)
  val driver = config.getString("redshift.driver")

  private var poolInitialized = false
  implicit val session = AutoSession
  Class.forName(driver)

  def initConnectionPool() = {
    if (!poolInitialized) {
      ConnectionPool.singleton(baseUrl, login, pass)
    }
    poolInitialized = true
  }

  def flushConnectionPool() = {
    poolInitialized = false
  }

  override def executeQuery(query: String): Unit = {
    logger.info("Executing query: " + query.toCharArray.take(250).mkString(""))

    initConnectionPool()
    SQL.apply(query).execute().apply()
  }

  def getSingleColumnListQuery(query: String, columnName: String): List[String] = {
    initConnectionPool()
    SQL.apply(query)
      .map(_.string(columnName))
      .list.apply()
  }
}
