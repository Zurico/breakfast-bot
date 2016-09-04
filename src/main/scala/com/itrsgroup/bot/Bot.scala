package com.itrsgroup.bot

case class Bot(token:String, name:String) {

  val client = new SlackClient(token, name)


}