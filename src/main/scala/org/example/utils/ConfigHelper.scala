package org.example.utils

import com.typesafe.config.{Config, ConfigFactory}

trait ConfigHelper {

  @transient
  lazy val config: Config = ConfigFactory.load("application.conf")
}
