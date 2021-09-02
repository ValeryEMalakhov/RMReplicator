import Dependencies._
import sbt.Keys._
import sbt._

name := "RMReplicator"

version := "1.0-SNAPSHOT"

scalaVersion := scala212

Compile / run / mainClass := Some("org.example.MainApp")

fork := true

libraryDependencies ++= spark ++ redshift ++ utils

resolvers ++= Seq(
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  "jitpack" at "https://jitpack.io"
)