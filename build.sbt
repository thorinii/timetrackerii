name := "Time Tracker II"

version := "1.0"

scalaVersion := "2.10.3"


libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.1.0" % "test"


ScoverageSbtPlugin.instrumentSettings

publishArtifact in Test := false

parallelExecution in Test := false