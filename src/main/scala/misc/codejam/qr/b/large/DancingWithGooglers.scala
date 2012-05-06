package misc.codejam.b.large
import java.io.File

import scala.collection.mutable.ListBuffer
import scala.io.Source

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
	    
	   
	    val ts:ListBuffer[Int] = new ListBuffer()
	    for ( inx <- 3 to strings.length -1 ) {
	      ts += strings(inx).toInt
	    }
	    
	    Console.println("p:" + p + " ts:" + ts)
	    
	    //surprising할 수 없거나 surprising한 상황에서도 안되는 얘들 제거
	    val possibles = ts.filterNot( (x:Int) => (x < 2) || (TripletSolver.bestScore( x , true) < p) )
	    Console.println("p:" + possibles)
	        
	    //surprsing 상황에 따라 갈리는 얘들 목록 
	    val dependsOn = possibles.filter( TripletSolver.bestScore( _ , false) < p)
	    Console.println("d:" + dependsOn)
	    
	     //surprising할 수 없는 아이들 중 p를 만족하는 수
	    val belowTwo = ts.filter( _ < 2)
	    val countInbelowTwo = belowTwo.filter(  TripletSolver.bestScore( _ , false) >= p).size
	    
	    //surprising 안 해도 괜찮은 아이들 수 
	    var count = possibles.size - dependsOn.size + countInbelowTwo;
	    Console.println("count:" + count)
	    
	    
	    val toAdd = Math.min(S,dependsOn.size)
	    count + toAdd
	    
	}
	
	
	
}