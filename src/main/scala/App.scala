/*
 * Copyright (C) 2016 Zuri Pabon - All Rights Reserved
 * You may use, distribute and modify this code under the
 * terms of the MIT license.
 *
 * A slack bot to manage breakfast time.
 * Visit https://api.slack.com/bot-users for details
 *
 * Authors:
 *
 * zuri pabon <zpabon@itrsgroup.com>
 */
import com.itrsgroup.bot.Bot

/*
  Replace token with your bot token (https://api.slack.com/tokens)
  and name with your bot username
 */
object App {

  val token = "<my_bot_token>"
  val username = "pitufo-bot"

  def main(args: Array[String]):Unit = Bot(token, username)

}
