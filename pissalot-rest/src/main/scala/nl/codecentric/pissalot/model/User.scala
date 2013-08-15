package nl.codecentric.pissalot.model

import org.joda.time.LocalDateTime

case class User(email:String,displayName:String,created:LocalDateTime, updated:LocalDateTime)
