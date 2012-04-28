package misc.codejam.b.large
import scala.collection.mutable.ListBuffer

/**
 * 조합을 정해진 규칙에 맞는 순서에 따라 다음 조합을 구해주는 리스트
 * 
 * 규칙
 * 1. 끝이 1일 경우 
 * 2. 
 * 
 * 1 = true, 0 = false일 경우
 * 1100 -> 1001 -> 0110 -> 0101 -> 0011  
 */

/*
object Combination {
  
    def createInitialListBuffer(trueCount:Int, size:Int):ListBuffer[Boolean] = {
        val result = ListBuffer[Boolean]()
        val lastIndex = size - 1 
    	for( inx <- 0 to trueCount - 1 ) {
    		result += true
    	}
        for( inx <- trueCount to lastIndex ) {
    		result += false
    	}
        result
    }
    
    def hasNext(current:ListBuffer[Boolean]):Boolean = {
		val lastTruesStartPos = current.findLastIndexOf( _ == false) + 1
	    val firstGroup = current.slice(0,lastTruesStartPos)
		val lastTruePosOfFirstGroup = firstGroup.lastIndexOf(true)
		if (lastTruePosOfFirstGroup < 0 ) {
			false
		} else {
			true
		}
    }
    
    /**
     * 마지막 조합에 이를 경우 IndexOutOfBoundsException 발생
     */
	def next(current:ListBuffer[Boolean]) = {
		if ( current.last ) {		// 규칙 1에 따라 Shift 수행
		  
		  //  끝에 몰려있는 연속된 true의 그룹을 lastTrues, 
		  //  lastTrues 이외의 그룹을 firstGroup 이라고 한다.
		  val lastTruesStartPos = current.findLastIndexOf( _ == false) + 1
		  val firstGroup = current.slice(0,lastTruesStartPos)
		  
		  // firstGroup 끝의 true를 한 칸 우측으로 이동
		  val lastTruePosOfFirstGroup = firstGroup.lastIndexOf(true)
		  if ( lastTruePosOfFirstGroup < 0 ) {
			  throw new IndexOutOfBoundsException
		  }
		  
		  moveTrueToRight(current, lastTruePosOfFirstGroup);
		  
		  // lastTrues를 firstGroup 끝 true 뒤에 붙힘
		  moveTruesToIndex(current, lastTruesStartPos, current.size - 1, lastTruePosOfFirstGroup + 2)
		  
		  // 마지막 조합을 나타내는 경우  
		} else {
		  // 가장 뒤에 있는 true를 한 칸 우측으로 이동
		  val lastIndex = current.findLastIndexOf( _ == true)
		  moveTrueToRight(current, lastIndex)
		}
	}
	
	private def moveTrueToRight(list:ListBuffer[Boolean], index:Int):Unit = {
	  require(index != list.size ) 
	  list(index) = false
	  list(index + 1) = true
	}
	
	
	private def moveTruesToIndex(list:ListBuffer[Boolean], 
	    oldStartInx:Int, oldLastInx:Int, 
	    newStartInx:Int):Unit = {
	  
    	  for( inx <- oldStartInx to oldLastInx) {
			  list(inx) = false;
		  }
		  
    	  val count = oldLastInx - oldStartInx
		  val newLastInx = newStartInx + count
		  for (inx <- newStartInx to newLastInx ) {
			  list(inx) = true;
		  }
	}
}
*/