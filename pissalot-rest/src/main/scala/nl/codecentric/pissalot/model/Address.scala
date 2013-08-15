package nl.codecentric.pissalot.model

case class Address(
    countryCode:String,
    addressLine1:String,
    addressline2:String,
    postalCode:String,
    city:String)