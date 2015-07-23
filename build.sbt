name := "scala-playground"

scalaVersion := "2.11.7"

ScoverageSbtPlugin.ScoverageKeys.coverageMinimum := 70

ScoverageSbtPlugin.ScoverageKeys.coverageFailOnMinimum := true

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.2",
  "com.typesafe.akka" %% "akka-actor" % "2.3.11",
  "com.sachinhandiekar" % "jMusixMatch" % "1.1.2",
  "com.twitter" %% "finagle-http" % "6.25.0")

