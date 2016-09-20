enablePlugins(JavaAppPackaging)

name := "breakfast-bot"
version := "0.1"
// HTTP Client
libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.3.0"
// JSON parser JacksMapper
libraryDependencies += "com.lambdaworks" %% "jacks" % "2.3.3"
libraryDependencies += "com.typesafe" % "config" % "1.3.0"
//libraryDependencies += "com.flyberrycapital" %% "scala-slack" % "0.3.0"