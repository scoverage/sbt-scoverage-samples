[![Coverage Status][coveralls-badge]][coveralls-status]

# scoverage samples

A sample program for demonstrating scoverage's code coverage. This sample is an akka based mock quote engine. Note: This project deliberately doesn't have 100% coverage for demonstration purposes.

To run the sample you need to ...

```bash
sbt clean compile test:compile coverage test coverageReport`
```

Afterwards you can find the report in ...

```
./target/scala-2.13/scoverage-report/index.html
```

You can also upload the report to [coveralls][] by running ...

```
sbt clean compile test:compile coverage test coverageReport coveralls`
```

Afterwards you can find the report on [coveralls][coveralls-status] ...

[coveralls]: https://coveralls.io
[coveralls-badge]: https://coveralls.io/repos/github/scoverage/sbt-scoverage-samples/badge.svg
[coveralls-status]: https://coveralls.io/github/scoverage/sbt-scoverage-samples
