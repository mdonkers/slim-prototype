package controllers

import play.api.mvc._
import models.User
import play.api.libs.json.{JsValue, Writes, Json}
import play.api.libs.json.Json._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def users = Action {

    // Defines JSON writer for the User class
    implicit val creatureWrites = new Writes[User] {
      def writes(c: User): JsValue = {
        Json.obj(
          "name" -> c.name,
          "email" -> c.email
        )
      }
    }

    val miel = User(1, "Miel", "miel.donkers@codecentric.nl")
    val hylke = User(2, "Hylke", "hylke.stapersma@codecentric.nl")

    val jsonArray = Json.toJson(Seq(
      toJson(miel), toJson(hylke)
    ))

    Ok(Json.toJson(jsonArray))
  }


  def newUser = TODO

  def deleteUser(id: Long) = TODO

}
