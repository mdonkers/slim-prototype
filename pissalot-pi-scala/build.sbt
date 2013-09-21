import AssemblyKeys._

assemblySettings

name := "pissalot"

organization := "nl.codecentric"

version := "0.1.0"

scalaVersion := "2.10.1"

showSuccess  := true

showTiming   := true

resolvers += "spray repo" at "http://repo.spray.io"

resolvers += "sonatype repo" at "https://oss.sonatype.org/content/groups/public/"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "1.9.1" % "test" withSources() withJavadoc(),
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.0",
  "org.slf4j" % "slf4j-simple" % "1.6.4",
  "com.pi4j" % "pi4j-core" % "1.0-SNAPSHOT",
  "joda-time" % "joda-time" % "2.3"
)

initialCommands := "import nl.codecentric.pissalot._"
