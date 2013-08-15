package nl.codecentric.pissalot.model

case class Location(
    name:String,
    locationAddress:Address,
    billingAddress:Address,
    enabled:Boolean)