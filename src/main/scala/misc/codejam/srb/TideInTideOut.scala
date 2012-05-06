package misc.codejam.srb
import scala.collection.mutable.ListBuffer

import misc.codejam.srb.CellInfo

object TideInTideOut {
	val cave:Cave = null;
	
	val direction = cave.getMovableDirection();
		
		val (second, nextCave)  = cave.moveTo(direction(0))
		
		
}
class Cave(val pos:(Int,Int), val height: Int, val cave: List[List[CellInfo]]) {
  type Second = Int
  type Height = Int
 
  val (curX, curY) = pos
  val curCell = cave(curY)(curX)
  
  def getMovableDirection():List[(Int,Int)] = {
    def checkMovable(x:Int, y:Int):Boolean ={ 
      if (x> -1 && y> -1 && y< cave.size && x < cave(0).size) {
    	 val to = cave(y)(x)
    	 (!to.isDone) && (curCell.isMovable (to))
      } else {
        false
      }
    }
    val movable:ListBuffer[(Int,Int)] = new ListBuffer();
    // up
    if (checkMovable(curX, curY-1)) movable+=((curX, curY-1))
    // down
    if (checkMovable(curX, curY+1)) movable+=((curX, curY+1))
    // left
    if (checkMovable(curX-1, curY)) movable+=((curX-1, curY))
    // right
    if (checkMovable(curX+1, curY)) movable+=((curX+1, curY))
	
	movable.toList
  }
  
  def moveTo(pos:(Int,Int)):(Second, Cave) = {
    val (x,y) = pos
    curCell.isDone = true
    val timeToMove = getTimeToMove(cave(y)(x))
    val nextHeight = height -  timeToMove * 10 
    (timeToMove, new Cave(pos, nextHeight, cave))
  }
  
  def getTimeToMove( to: CellInfo):Second = {
	  var currentHeight = height;

      // wait time
      val lowerCeiling = Math.min(to.ceiling, curCell.ceiling);
      var waitSec = (currentHeight - (lowerCeiling - 50)) / 10
      if (waitSec < 0) waitSec = 0
      else {
        currentHeight = Math.min(to.ceiling, curCell.ceiling) - 50
      }

      if (currentHeight - curCell.floor > 20) {
        // water
        waitSec + 1
      } else {
        // lands
        waitSec + 10
      }
  }
}

object Test extends App {
//  Console.println(TideInTideOut.getTimeToMove(150, CellInfo(200, 0), CellInfo(100, 0)));
//  Console.println(TideInTideOut.getTimeToMove(150, CellInfo(200, 0), CellInfo(100, 80)));
//  Console.println(TideInTideOut.getTimeToMove(100, CellInfo(200, 100), CellInfo(140, 0)));
//  Console.println(TideInTideOut.getTimeToMove(150, CellInfo(300, 100), CellInfo(170, 0)));
}