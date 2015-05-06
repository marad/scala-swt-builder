name := "scala-swt-builder"
version := "1.0"
scalaVersion := "2.11.6"

resolvers ++= Seq(
    "swt-repo" at "https://swt-repo.googlecode.com/svn/repo/"
)

libraryDependencies ++= Seq(
    "org.eclipse.swt" % "org.eclipse.swt.gtk.linux.x86_64" % "4.4"
)

mainClass in run := Some("marad.scala.swt.builder.TestObject")
fork in run := true
