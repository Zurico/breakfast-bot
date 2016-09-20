package com.itrsgroup.bot

//import scala.util.parsing.json.JSON
import com.lambdaworks.jacks.JacksMapper
import scalaj.http._

/**
 * Created by zpabon on 04/09/16.
 */
class SlackClient(token:String, name:String) {

  private var users:List[Any] = List()
  private var ims:List[Any] = List()

  private def connect(connectionData:Map[String, Any]) = {

    users = connectionData.get("users").get.asInstanceOf[List[Any]]
    ims = connectionData.get("ims").get.asInstanceOf[List[Any]]
  }

  private def normalizeParams(params:Seq[(String, String)]) =
    params ++ Seq(("token", token))

  // JacksMappers(https://github.com/wg/jacks) is faster than JSON
  private def normalizeResponse(json:String) = JacksMapper.readValue[Map[String,Any]](json)
  //def normalizeResponse(response:String) = JSON.parseFull(response).get.asInstanceOf[Map[String,Any]]

  private def api(method:String, params:Seq[(String, String)] = Seq.empty) =
    normalizeResponse(Http("https://slack.com/api/" + method).postForm(normalizeParams(params)).asString.body)

  private def _postMessage(msg:String, im:String) =
    api("chat.postMessage", Seq(("text", msg), ("username", name), ("channel", im)))

  private def openIM(userID:String) = {

    val imHTTPResponse = api("im.open", Seq(("user", userID)))

    imHTTPResponse.get("id").get.asInstanceOf[String]

  }

  def postMessageToUser(user:String, msg:String) = {

    val userData = users.find(_.asInstanceOf[Map[String, Any]].getOrElse("name", "") == user).get.asInstanceOf[Map[String, Any]]

    val userID = userData.get("id").get.asInstanceOf[String]

    val imData = ims.find(_.asInstanceOf[Map[String, Any]].getOrElse("user", "") == userID)

    // If imsData does not exists, then open im
    imData match {

      case None => _postMessage(msg, openIM(userID))
      case _ => {

        val imID = imData.get.asInstanceOf[Map[String, Any]].get("id").get.asInstanceOf[String]

        _postMessage(msg, imID)
      }
    }
  }

  // Make sure token and name is not empty
  // @todo a better way to manage this? Option(token) match
  if(Option(token).getOrElse("").isEmpty || Option(name).getOrElse("").isEmpty)
    throw new Exception("No token or name")

  connect(api("rtm.start"))

}
