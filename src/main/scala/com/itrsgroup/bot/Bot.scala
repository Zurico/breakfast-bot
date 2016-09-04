package com.itrsgroup.bot

import com.flyberrycapital.slack.SlackClient

object Bot {

  val token = ""

  def run():Unit = {

    val client = new SlackClient(token)

  }

}