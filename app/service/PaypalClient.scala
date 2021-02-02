package service

import com.paypal.core.{PayPalEnvironment, PayPalHttpClient}
import play.api.Configuration
import javax.inject._
import play.api.Logging

class PaypalClient @Inject()(applicationConf: Configuration) extends Logging  {

  private def payPalEnvironment = {
    val clientId = applicationConf.get[String]("clientId ")
    val secret = applicationConf.get[String]("secret")

    logger.info(s"Getting client Id ${clientId}")
    logger.info(s"Getting application secret ${secret}")

    new PayPalEnvironment.Sandbox(clientId, secret)
  }

  def client = new PayPalHttpClient(payPalEnvironment)
}
