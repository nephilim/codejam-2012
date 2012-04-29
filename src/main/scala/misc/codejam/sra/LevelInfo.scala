package misc.codejam.sra

class LevelInfo ( val level:Int, val oneStar:Int, val twoStar:Int, var isDone:Boolean) {
    override def toString() = {
    	"(L%d: %d, %d, %s)".format(level, oneStar, twoStar, isDone)
    }
}