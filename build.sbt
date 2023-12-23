name := "sbt-scoverage-samples"

organization := "org.scoverage"

version := "1.6.4"

scalaVersion := "3.3.2-RC1"

crossScalaVersions := Seq("2.13.12") :+ scalaVersion.value

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-Werror")

libraryDependencies ++= Seq(
  "commons-io"             %  "commons-io"    % "2.11.0",
  "com.typesafe.akka"      %% "akka-actor"    % "2.6.20",
  "com.typesafe.akka"      %% "akka-testkit"  % "2.6.20" % "test",
  "org.scalatest"          %% "scalatest"     % "3.2.14" % "test"
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

Test / publishArtifact := false
Test / parallelExecution := false
