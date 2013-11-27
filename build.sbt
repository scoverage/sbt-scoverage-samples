import org.scalescc.sbt.ScalesSbtPlugin

name := "scoot-test"

organization := "com.sksamuel.scoot"

version := "0.11.0-SNAPSHOT"

scalaVersion := "2.10.3"

parallelExecution in Test := false

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

libraryDependencies ++= Seq(
  "commons-io" % "commons-io" % "2.4",
  "com.typesafe.akka" %% "akka-actor" % "2.2.3",
  "com.typesafe.akka" %% "akka-actor-tests" % "2.2.3",
  "org.scalatest" %% "scalatest" % "2.0" % "test"
)

addSbtPlugin("com.sksamuel.scoot" %% "sbt-scoot" % "0.11.0-SNAPSHOT" % "provided")

seq(ScalesSbtPlugin.instrumentSettings: _*)
