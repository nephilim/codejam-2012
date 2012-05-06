package misc.codejam.src.a
import scala.collection.mutable.ListBuffer

case class Leaf(val id:Int, val accessibleIds:ListBuffer[Int], val referBy:ListBuffer[Int])

