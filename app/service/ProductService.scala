package service
import javax.inject._
import play.api.db.Database

import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import anorm._
import model.Item

sealed trait Queries{
  def all : Future[List[Item]]
}

@Singleton
class ProductService @Inject()(db: Database)(implicit ec: ExecutionContext) extends Queries {
  def all: Future[List[Item]] = {
    lazy val fParser = Macro.namedParser[Item]
    Future {
      db.withConnection( implicit connection => {
        SQL("select * from product").as[List[Item]](fParser .*)
      })
    }
  }
}
