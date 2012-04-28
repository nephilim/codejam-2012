package misc.codejam.qr
import java.util.Iterator
import scala.collection.mutable.ListBuffer
import java.io.File

object DancingWithGooglers extends App {
	import scala.io.Source
	
	val caseOutputForm:String = "Case #%d: %d" 
	val n:Int = 1
	
	
	val file = new File("./codejam-b.dat")
	
	var	T:Int = 0	//테스트 케이스 총 수  
	var count:Int = 0
	for (line <- Source.fromFile(file).getLines) {
		if ( T == 0 ) {
		  T = line.toInt
		} else {
		  count = count + 1
		  Console.println(caseOutputForm.format(count, parseResult(line)))
		}
	}
	
	def parseResult(line:String):Int = {
	    val strings = line.split(" ")
	    val N = strings(0).toInt 		// num of googlers
	    val S = strings(1).toInt		// the number of surprising triplets of scores
	    val p = strings(2).toInt
	    
	    val surprisePickup = Combination.createInitialListBuffer(S, N)
	    val ts:ListBuffer[Int] = new ListBuffer()
	    for ( inx <- 3 to strings.length -1 ) {
	      ts += strings(inx).toInt
	    }
	    
	    var isFirstLoop:Boolean = true
	    var maxCount = 0;
	    do {
	    	if ( isFirstLoop ) isFirstLoop = false else Combination.next(surprisePickup)
	    	try { 
		    	val currentCount = TripletSolver.countBestScoreOverP(ts zip surprisePickup, p)
		    	if ( currentCount > maxCount ) {
		    	  maxCount = currentCount
		    	}
	    	} catch {
	    	  case ex:SurprisingConditionException => 
	    	}
	    } while (Combination.hasNext(surprisePickup))
	      
	    maxCount
	}
	
	
	
}