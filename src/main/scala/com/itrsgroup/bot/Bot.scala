package com.itrsgroup.bot

case class Bot(token:String, name:String) {

  val client = new SlackClient(token, name)

  val message = "ignore it, please"
  val users = List("user1", "user2")

  users.foreach(client.postMessageToUser(_, message))

}