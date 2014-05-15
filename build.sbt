name := "scoverage-samples"

organization := "org.scoverage"

version := "0.99.1"

scalaVersion := "2.11.0"

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

libraryDependencies ++= Seq(
  "commons-io"                 % "commons-io"              % "2.4",
  "com.typesafe.akka"          %% "akka-actor"             % "2.3.2",
  "com.typesafe.akka"          %% "akka-actor-tests"       % "2.3.2",
  "com.typesafe.scala-logging" %% "scala-logging-slf4j"    % "2.1.2",
  "org.scalatest"              %% "scalatest"              % "2.1.6"            % "test"
)

ScoverageSbtPlugin.instrumentSettings

//CoverallsPlugin.singleProject

publishArtifact in Test := false

parallelExecution in Test := false
