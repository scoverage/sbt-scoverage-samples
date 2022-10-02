name := "sbt-scoverage-samples"

organization := "org.scoverage"

version := "1.6.0"

scalaVersion := "2.13.9"

crossScalaVersions := Seq("2.13.9")

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

scalacOptions in (Compile, doc) ++= Seq("-unchecked", "-deprecation", "-diagrams", "-implicits", "-skip-packages", "samples")

libraryDependencies ++= Seq(
  "commons-io"                 %  "commons-io"             % "2.11.0",
  "com.typesafe.akka"          %% "akka-actor"             % "2.6.20",
  "com.typesafe.akka"          %% "akka-testkit"           % "2.6.20"           % "test",
  "com.github.dmytromitin"     %% "macro-compat"           % "1.1.2",
  "org.scala-lang"             %  "scala-reflect"          % scalaVersion.value % "provided",
  "org.scalatest"              %% "scalatest"              % "3.2.14"            % "test"
  //compilerPlugin("org.scalamacros" %% "paradise" % "2.1.1" cross CrossVersion.full)
)
//enablePlugins(JavaAppPackaging)

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
