name := "sbt-scoverage-samples"

organization := "org.scoverage"

version := "1.3.5"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.11.8", "2.10.6")

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

scalacOptions ++= Seq("-unchecked", "-deprecation")

scalacOptions in (Compile, doc) ++= Seq("-unchecked", "-deprecation", "-diagrams", "-implicits", "-skip-packages", "samples")

libraryDependencies ++= Seq(
  "commons-io"                 % "commons-io"              % "2.4",
  "com.typesafe.akka"          %% "akka-actor"             % "2.3.2",
  "com.typesafe.akka"          %% "akka-actor-tests"       % "2.3.2",
  "com.typesafe.scala-logging" %% "scala-logging-slf4j"    % "2.1.2",
  "org.scalatest"              %% "scalatest"              % "2.2.1"            % "test"
)

coverageMinimum := 70

coverageFailOnMinimum := false

coverageHighlighting := {
  if (scalaBinaryVersion.value == "2.11")
    true
  else
    false
}

publishArtifact in Test := false

parallelExecution in Test := false
