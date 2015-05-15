organization := "io.github.marad"
name := "swt-builder"
version := "1.0.0"

scalaVersion := "2.11.6"

resolvers ++= Seq(
    "swt-repo" at "https://swt-repo.googlecode.com/svn/repo/"
)

libraryDependencies ++= Seq(
    "org.eclipse.swt" % "org.eclipse.swt.gtk.linux.x86_64" % "4.4"
)

fork in run := true

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
