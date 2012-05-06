package misc.codejam.common
import scala.collection.mutable.ListBuffer

class Labyrinth[T <: Cell](
  val pos: (Int, Int), // 이동할 위치
  val infoMatrix: Map[(Int, Int), T], // 해당 cell의 정보 (ex 막혔는지)
  val prevDoneMatrix: Map[(Int, Int), Boolean]) { // 이동 경로 (지나갔는지 여부) 

  type Matrix[U] = Map[(Int, Int), U]

  val curInfo = infoMatrix(pos)
  val doneMatrix: Matrix[Boolean] = {
    val prevMatrix = collection.mutable.Map(prevDoneMatrix.toSeq: _*)
    prevMatrix(pos) = true;
    prevMatrix.toMap
  }
  val (curX, curY) = pos

  def nextMovablePosList(): List[(Int, Int)] = {
    val movable: ListBuffer[(Int, Int)] = new ListBuffer();
    // up
    if (checkMovable(curX, curY - 1)) movable += ((curX, curY - 1))
    // down
    if (checkMovable(curX, curY + 1)) movable += ((curX, curY + 1))
    // left
    if (checkMovable(curX - 1, curY)) movable += ((curX - 1, curY))
    // right
    if (checkMovable(curX + 1, curY)) movable += ((curX + 1, curY))

    movable.toList
  }

  def checkMovable(x: Int, y: Int): Boolean = {
    infoMatrix.get(x, y) match {
      case Some(nextInfo) => curInfo.isMovableTo(nextInfo) && !doneMatrix((x,y))
      case None => false
    }
  }
}

object Labyrinth {
  def pathFinder[T<: Cell](maze:Labyrinth[T], dest:(Int,Int)):List[List[(Int,Int)]] = {
	if ( maze.pos ==  dest) return List(Nil)
	val posList = maze.nextMovablePosList()
	posList match {
	  case Nil => List(Nil)
	  case list:List[(Int,Int)] =>
	    list.flatMap( nextPos => {
	      val newLab = new Labyrinth(nextPos, maze.infoMatrix, maze.doneMatrix)
	      pathFinder(newLab, dest).map(nextPos::_)})
	}
  }
  
  def getInitialDoneMatrix(width:Int, height:Int):Map[(Int,Int),Boolean] = {
	  val mutableMap  = scala.collection.mutable.Map[(Int,Int),Boolean]();
	  for ( y <- 1 to height; x <- 1 to width) {
	    mutableMap((x,y)) = false
	  }
	  mutableMap.toMap
  }
}

abstract class Cell {
  def isMovableTo[U <: Cell](that: U): Boolean
}








