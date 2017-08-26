name := "sbt-scoverage-samples"

organization := "org.scoverage"

version := "1.5.1"

scalaVersion := "2.12.3"

crossScalaVersions := Seq("2.11.11", "2.12.3")

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

scalacOptions in (Compile, doc) ++= Seq("-unchecked", "-deprecation", "-diagrams", "-implicits", "-skip-packages", "samples")

libraryDependencies ++= Seq(
  "commons-io"                 %  "commons-io"             % "2.4",
  "com.typesafe.akka"          %% "akka-actor"             % "2.4.16",
  "com.typesafe.akka"          %% "akka-testkit"           % "2.4.16"           % "test",
  "org.typelevel"              %% "macro-compat"           % "1.1.1",
  "org.scala-lang"             %  "scala-reflect"          % scalaVersion.value % "provided",
  "org.scalatest"              %% "scalatest"              % "3.0.0"            % "test",
  compilerPlugin("org.scalamacros" %% "paradise" % "2.1.0" cross CrossVersion.full)
)

coverageMinimum := 70

coverageFailOnMinimum := false

coverageHighlighting := true

publishArtifact in Test := false

parallelExecution in Test := false
