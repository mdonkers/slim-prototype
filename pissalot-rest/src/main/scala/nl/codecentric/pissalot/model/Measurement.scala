package nl.codecentric.pissalot.model

import org.joda.time.LocalDateTime

case class Measurement(user:Option[User],bowl:Bowl,start:LocalDateTime,end:LocalDateTime) 