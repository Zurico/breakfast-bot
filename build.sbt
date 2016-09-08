enablePlugins(JavaAppPackaging)

name := "breakfast-bot"
version := "1.0"
// HTTP Client
libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.3.0"
// JSON parser JacksMapper
libraryDependencies += "com.lambdaworks" %% "jacks" % "2.3.3"
//libraryDependencies += "com.flyberrycapital" %% "scala-slack" % "0.3.0"