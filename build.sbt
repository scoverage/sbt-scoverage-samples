name := "sbt-scoverage-samples"

organization := "org.scoverage"

version := "1.6.1"

scalaVersion := "3.2.0"

crossScalaVersions := Seq("2.13.9", "3.2.0")

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-Werror")

libraryDependencies ++= Seq(
  "commons-io"             %  "commons-io"    % "2.11.0",
  "com.typesafe.akka"      %% "akka-actor"    % "2.6.20",
  "com.typesafe.akka"      %% "akka-testkit"  % "2.6.20" % "test",
  "org.scalatest"          %% "scalatest"     % "3.2.14" % "test",
  "com.lihaoyi"            %% "upickle"       % "2.0.0"
)

import org.scoverage.coveralls.Imports.CoverallsKeys._
coverallsTokenFile := Some("./.coverallsToken")

coverageHighlighting := true
coverageFailOnMinimum := false
coverageMinimumStmtTotal := 70
coverageMinimumBranchTotal := 70
coverageMinimumStmtPerPackage := 70
coverageMinimumBranchPerPackage := 70
coverageMinimumStmtPerFile := 70
coverageMinimumBranchPerFile := 70


publishArtifact in Test := false
parallelExecution in Test := false
