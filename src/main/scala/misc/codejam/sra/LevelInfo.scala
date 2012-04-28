package misc.codejam.sra

class LevelInfo(val level:Int, val oneStar:Int, val twoStar:Int, var isPlayed:Boolean) {
  override def toString() = {
    "L" +level + "- " + oneStar + "," + twoStar + " (" + isPlayed + ")"; 
  }
}