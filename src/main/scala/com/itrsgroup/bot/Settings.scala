package com.itrsgroup.bot

import com.typesafe.config.ConfigFactory
import collection.JavaConversions._

/**
 * Created by zpabon on 20/09/16.
 */
object Settings {

  val conf = ConfigFactory.load()

  // @todo set as an Option
  val token = conf.getString("token")
  val username = conf.getString("username")
  val message = conf.getString("message")
  val users = conf.getStringList("users").toList // Get a Scala list, it returns a Java list (import collection.JavaConversions._)

}
