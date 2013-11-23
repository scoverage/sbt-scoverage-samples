name := "scales-test"

organization := "org.scalescc"

version := "0.1.0-SNAPSHOT"

autoCompilerPlugins := true

scalaVersion := "2.10.3"

publishMavenStyle := true

publishArtifact in Test := false

parallelExecution in Test := false

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

libraryDependencies += "org.scalatest" %% "scalatest" % "2.0" % "test"

libraryDependencies += "commons-io" % "commons-io" % "2.4"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.10" % "2.2.3"