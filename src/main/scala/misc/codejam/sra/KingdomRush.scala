package misc.codejam.sra
import java.io.File
import scalaz.Resource

object KingdomRush extends App{
  
	import scala.io.Source._
	
	val caseReader = new KingdomRushCaseReader("B-small-practice.in");

	var	total:Int = caseReader.headLine.toInt		//테스트 케이스 총 수  
	
	for ( caseNo <- 1 to total) {
	   val levelInfos:List[LevelInfo] = caseReader.readNext()
	   val analyzer = new KingomAnalyzer(levelInfos);
	   val shortest = analyzer.findShortestAll2StarCount() match  {
	     case -1 => "Too Bad"  
	     case x@_ => x.toString
	   }
	   Console.println( "Case #%d: %s".format(caseNo, shortest))
	}
	
	caseReader.closeStream()
	 
}