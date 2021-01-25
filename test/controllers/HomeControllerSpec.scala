package controllers
import model.Item
import org.scalatest.matchers.should._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.mockito.MockitoSugar
import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._
import scala.concurrent.{ExecutionContext, Future}
import org.mockito.Mockito._
import service.ProductService


class HomeControllerSpec extends AnyWordSpec with Results with Matchers with MockitoSugar  {
  "A request" when {
    "sent to the / route" should {
      "be successful" in {
        implicit val ec: ExecutionContext = ExecutionContext.global
        val productService = mock[ProductService]


        when(productService.all).thenReturn(Future(List( Item(1, "Milo", 3, None, 2))))
        val homeController = new HomeController(Helpers.stubControllerComponents(), productService)

        val result = homeController.index().apply(FakeRequest())
        val body: String = contentAsString(result)
        body.contains("Milo") shouldEqual(true)
      }
    }
  }
}
