name := "scala-playground"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.2",
  "com.typesafe.akka" %% "akka-actor" % "2.3.11",
  "com.sachinhandiekar" % "jMusixMatch" % "1.1.2",
  "com.twitter" %% "finagle-http" % "6.25.0")
