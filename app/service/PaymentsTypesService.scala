package service

object PaymentsTypesService {
  case class CurrencyCode(currency: String) extends  AnyVal
  case class PurchaseValue(value: String)   extends  AnyVal
}
