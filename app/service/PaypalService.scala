package service

import java.util

import com.paypal.orders.{AmountWithBreakdown, OrderRequest, OrdersCreateRequest, PurchaseUnitRequest}
import PaymentsTypesService._
import javax.inject.Inject
import play.api.Logging

class PaypalService @Inject()(payPalClient: PaypalClient) extends Logging {

  def order(currencyCode: CurrencyCode, purchaseValue: PurchaseValue): Unit = {
    val orderRequest: OrderRequest = new OrderRequest();
    orderRequest.checkoutPaymentIntent("CAPTURE")

    val purchaseUnits = new util.ArrayList[PurchaseUnitRequest]
    purchaseUnits.add(new PurchaseUnitRequest().amountWithBreakdown(new AmountWithBreakdown().currencyCode(currencyCode.currency).value(purchaseValue.value)))


    orderRequest.purchaseUnits(purchaseUnits)

    val request = new OrdersCreateRequest().requestBody(orderRequest);

    try {
      val response = payPalClient.client.execute(request)
      logger.info("Client has made a request -> Waiting for response")
      val result = response.result()

      val orderId = result.id()
      val orderStatus = result.status()

      logger.debug("Order with completed payload")
      logger.debug(s"Order status ${orderStatus}")
      logger.debug(s"Order ID: ${orderId}")


			result.links().forEach(link => println(link.rel() + " => " + link.method() + ":" + link.href()));

    } catch {
      case e: Exception => logger.error(s"There was an error = > ${e.getMessage}")
    }
  }
}
