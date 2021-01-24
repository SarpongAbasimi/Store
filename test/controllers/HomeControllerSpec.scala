package controllers
import org.scalatest.matchers.should._
import org.scalatest.wordspec.AnyWordSpec
import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._


class HomeControllerSpec extends AnyWordSpec with Results with Matchers  {
  "A request" when {
    "sent to the / route" should {
      "be successful" in {
//        val homeController = new HomeController(Helpers.stubControllerComponents())
//        val result = homeController.index().apply(FakeRequest())
//        val body: String = contentAsString(result)
//        body.contains("Product") shouldEqual(true)
      }
    }
  }
}
