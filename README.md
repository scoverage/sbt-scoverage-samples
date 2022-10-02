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
