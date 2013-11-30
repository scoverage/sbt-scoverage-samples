resolvers ++= Seq(
  Classpaths.sbtPluginReleases,
  Classpaths.sbtPluginSnapshots,
  Resolver.url("local-ivy",
    new URL("file://" + Path.userHome.absolutePath + "/.ivy2/local"))(Resolver.ivyStylePatterns)
)

