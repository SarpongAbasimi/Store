package model

case class Item(id: Int, name: String, price: Double, discount: Option[Double], stock: Int)