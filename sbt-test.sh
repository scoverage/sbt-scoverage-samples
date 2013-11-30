cd ../scalac-scoverage-plugin
sbt publishLocal


cd ../sbt-scoverage
sbt publishLocal

cd ../scoverage-samples
sbt test
