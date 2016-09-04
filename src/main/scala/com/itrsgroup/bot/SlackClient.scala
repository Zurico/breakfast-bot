package com.itrsgroup.bot

import scalaj.http._

/**
 * Created by zpabon on 04/09/16.
 */
class SlackClient(token:String, name:String) {

  def start():Unit = {

    val startHTTPResponse = api("rtm.start")

    println(startHTTPResponse)

  }

  def normalizeParams(params:Seq[(String, String)]):Seq[(String, String)] =
    params ++ Seq(("token", token))

  def api(method:String, params:Seq[(String, String)] = Seq.empty) =
    Http("https://slack.com/api/" + method).postForm(normalizeParams(params)).asString


  // Make sure token and name is not empty
  // @todo a better way to manage this? Option(token) match
  if(Option(token).getOrElse("").isEmpty || Option(name).getOrElse("").isEmpty)
    throw new Exception("No token or name")

  start()

}
