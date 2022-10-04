[![Coverage Status][coveralls-badge]][coveralls-status]

# scoverage samples

A sample program for demonstrating scoverage's code coverage. This sample is an akka based mock quote engine. Note: This project deliberately doesn't have 100% coverage for demonstration purposes.

To run the sample you need to ...

```bash
sbt clean coverage test coverageReport
```

Afterwards you can find the report in ...

```
./target/scala-2.13/scoverage-report/index.html
```

You can also upload the report to [coveralls][]. To make that work you need to ...

* ... create/have an account on coveralls 
* ... get the api token
* ... set `export COVERALLS_REPO_TOKEN=<your token>`
* ... run `sbt clean compile test:compile test coverageReport coveralls`
* ... go to [coveralls][] to see the report

[coveralls]: https://coveralls.io
[coveralls-badge]: https://coveralls.io/repos/github/scoverage/sbt-scoverage-samples/badge.svg
[coveralls-status]: https://coveralls.io/github/scoverage/sbt-scoverage-samples
