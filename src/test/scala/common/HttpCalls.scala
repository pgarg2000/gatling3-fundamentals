package common

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

trait HttpCalls extends Simulation{

  val httpConf: HttpProtocolBuilder = http.baseUrl("http://localhost:8080/app/")
    .header("Accept", "application/json")

  def getAllVideoGames: ChainBuilder = {
    exec(
      http("Get All Video Games")
        .get("videogames")
        .check(status.is(200)))
  }

}
