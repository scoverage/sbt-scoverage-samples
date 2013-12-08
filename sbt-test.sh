cd ../scalac-scoverage-plugin
sbt clean publishLocal

cd ../sbt-scoverage
sbt clean publishLocal

cd ../scoverage-samples
sbt clean scoverage:test
