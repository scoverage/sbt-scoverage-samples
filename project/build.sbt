resolvers += Classpaths.typesafeReleases

resolvers ++= Seq(
  "scct-github-repository" at "http://mtkopone.github.com/scct/maven-repo",
  "oss sonatype" at "https://oss.sonatype.org/content/groups/public/"
)

addSbtPlugin("com.github.scct" % "sbt-scct" % "0.2.1")