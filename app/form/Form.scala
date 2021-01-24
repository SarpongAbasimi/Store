package form
import play.api.data._
import play.api.data.Forms._

case class ItemQuantityForm(quantity: Int)

object Forms {
  lazy val itemQuantityForm = Form(
    mapping(
    "quantity" -> number
    )(ItemQuantityForm.apply)(ItemQuantityForm.unapply)
  )
}