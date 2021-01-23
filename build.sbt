lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """play-scala-hello-world-tutorial""",
    organization := "com.example",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.1",
    libraryDependencies ++= Seq(
      guice,
      jdbc,
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
      "org.scalatest" %% "scalatest" % "3.2.2" % "test",
      "org.postgresql" % "postgresql" % "42.2.18",
      "org.typelevel" %% "cats-core" % "2.1.1",
      "org.playframework.anorm" %% "anorm" % "2.6.7"
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )
