package misc.codejam.srb

case class CellInfo(val ceiling:Int, val floor:Int, var isDone:Boolean) {
  def isMovable(that:CellInfo):Boolean = {
    if (that.ceiling - that.floor < 50) {
    	false
    } else {
	    val diff1 = Math.abs(this.ceiling - that.floor);
	    val diff2 = Math.abs(this.floor - that.ceiling);
	    (Math.min(diff1,diff2) >= 50)
    }
  }
}
