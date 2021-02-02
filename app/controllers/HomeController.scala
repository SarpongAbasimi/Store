package controllers

import javax.inject._
import play.api.mvc._
import service._
import scala.concurrent.{ExecutionContext, Future}
import PaymentsTypesService._
import form._
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
object ProductPrice {
  val ps5RetailPrice= 700
}
@Singleton
class HomeController @Inject()(cc: ControllerComponents, productService: ProductService, payment : PaypalService)(implicit ec: ExecutionContext)
  extends AbstractController(cc) with play.api.i18n.I18nSupport{

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action.async { implicit request: Request[AnyContent] =>
      productService.all.map(eachProduct => Ok(views.html.index(eachProduct, Forms.itemQuantityForm)))
    }

  def post() = Action.async { implicit request: Request[AnyContent] =>
    Forms.itemQuantityForm.bindFromRequest.fold( errors =>  {
      productService.all.map(eachProduct => BadRequest(views.html.index(eachProduct, errors)))
    }, succes => Future {
      val amoutToPay = succes.quantity.toInt * ProductPrice.ps5RetailPrice

      val currencyCode: CurrencyCode = CurrencyCode("USD")
      val purcahseValue:PurchaseValue = PurchaseValue(amoutToPay.toString)

      payment.order(currencyCode, purcahseValue)
      Redirect(routes.HomeController.index())
    })
  }
}
