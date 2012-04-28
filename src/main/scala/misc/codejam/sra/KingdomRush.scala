package misc.codejam.sra
import java.io.File

object Problem extends App{
	import scala.io.Source
	
	val caseOutputForm:String = "Case #%d: %d" 
	val n:Int = 1
	
	
	val file = new File("./B-test-attempt.in")
	
	var	T:Int = 0	//테스트 케이스 총 수  
	var caseCount:Int = 0; // 테스트케이스 카운트
	var levelIncase:Int = 0; // 
	var count:Int = 0 // 총 줄 수 카운트
	var nextLevelLine:Int=2;	// 레벨을 표시하는 라인 
	var levelInfos:List[LevelInfo] = List();
	
	for (line <- Source.fromFile(file).getLines) {
		count = count + 1
		
		if ( count == 1 ) {
		  T = line.toInt
		  
		} else if ( count == nextLevelLine) {
		  caseCount = caseCount +1; //몇 번 째 테스트 케이스
		  val gameCount = line.toInt
		  
		  nextLevelLine = nextLevelLine + gameCount + 1; 
		  if (count != 2 ) {
		   //val kingdom = new KingomAnalyzer();
		    //call
		     levelIncase = 0;
		     
			 // Console.println(levelInfos);
			  val analyzer = new KingomAnalyzer(levelInfos);
//			  Console.println(analyzer.findShortestAll2StarCount());
			  levelInfos = List[LevelInfo]();
		  }
		} else {
		  levelIncase = levelIncase + 1;
		  levelInfos++= List(parseLine(levelIncase,line));
		}
	}
	
	//Console.println(levelInfos);
	val analyzer = new KingomAnalyzer(levelInfos);
	Console.println(analyzer.findShortestAll2StarCount());
	
	//파일을 단위로 읽는 메서드 만들기
	def parseLine(count:Int, line:String):LevelInfo = {
	    val strings = line.split(" ")
	    val oneStar = strings(0).toInt 		
	    val twoStar = strings(1).toInt		
	    new LevelInfo(count, oneStar, twoStar, false )
	}    
}