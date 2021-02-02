package form
import play.api.data._
import play.api.data.Forms._

case class ItemQuantityForm(quantity: String)

object Forms {
  lazy val itemQuantityForm = Form(
    mapping(
    "quantity" -> text
    )(ItemQuantityForm.apply)(ItemQuantityForm.unapply)
  )
}