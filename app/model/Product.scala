package model

final case class Id      (id: String)               extends AnyVal
final case class Name    (name: String)             extends AnyVal
final case class Price   (price: Double)            extends AnyVal
final case class Discount(discount: Option[Double]) extends AnyVal
final case class Stock   (stock: Int)               extends AnyVal

case class Product(id: Id, name: Name, price: Price, discount: Discount, stock: Stock)