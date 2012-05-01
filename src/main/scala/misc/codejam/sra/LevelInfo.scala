package misc.codejam.sra

object StarLevel extends Enumeration {
  val NotFished, One, Two = Value
} 

class LevelInfo ( val level:Int, val oneStar:Int, val twoStar:Int, var prevStarLevel:StarLevel.Value) {
    override def toString() = {
    	"(L%d: %d, %d, %s)".format(level, oneStar, twoStar, prevStarLevel.id)
    }
}