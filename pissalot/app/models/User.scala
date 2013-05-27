package models

import play.api.libs.json.{Format, JsValue, Json, JsSuccess}

/**
 * TODO update header from template
 */
case class User(id: Long, name: String, email: String)

object User {

  implicit object LeagueFormat extends Format[User] {
    def reads(json: JsValue): JsSuccess[User] = JsSuccess(User(
      (json \ "id").as[Long],
      (json \ "name").as[String],
      (json \ "email").as[String]
    ))

    def writes(u: User): JsValue = {
      Json.obj(
        "name" -> u.name,
        "email" -> u.email
      )
    }
  }

}
