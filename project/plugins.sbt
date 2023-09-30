val pluginSbtScoverageVersion = sys.props.getOrElse(
  "plugin.sbtscoverage.version", "2.0.9"
)

val pluginSbtCoverallsVersion = sys.props.getOrElse(
  "plugin.sbtcoveralls.version", "1.3.11"
)

addSbtPlugin("org.scoverage" % "sbt-scoverage" % pluginSbtScoverageVersion)
addSbtPlugin("org.scoverage" % "sbt-coveralls" % pluginSbtCoverallsVersion)

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.6")
