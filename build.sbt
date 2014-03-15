//
// Headers
//
name := "Time Tracker II"

version := "1.0"

scalaVersion := "2.10.3"


//
// Dependencies
//
libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "0.8.0"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.1.0" % "test"


//
// Scoverage
//
ScoverageSbtPlugin.instrumentSettings

publishArtifact in Test := false

parallelExecution in Test := false


//
// ScalaTest JUnit Output
//
testOptions in Test <+= (target in Test) map {
  t => Tests.Argument(TestFrameworks.ScalaTest, "-u", "%s" format (t / "test-reports"))
}

testOptions in Test += Tests.Argument("-oS")
