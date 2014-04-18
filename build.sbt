name := "scoverage-samples"

organization := "org.scoverage"

version := "0.98.2"

scalaVersion := "2.10.3"

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

libraryDependencies ++= Seq(
  "commons-io"                % "commons-io"              % "2.4",
  "com.typesafe.akka"         %% "akka-actor"             % "2.2.3",
  "com.typesafe.akka"         %% "akka-actor-tests"       % "2.2.3",
  "org.scala-lang"            % "scala-reflect"           % "2.10.3",
  "org.scala-lang"            % "scala-compiler"          % "2.10.3"           % "provided",
  "org.scalatest"             %% "scalatest"              % "2.1.2"            % "test"
)

ScoverageSbtPlugin.instrumentSettings

//CoverallsPlugin.singleProject

publishArtifact in Test := false

parallelExecution in Test := false
