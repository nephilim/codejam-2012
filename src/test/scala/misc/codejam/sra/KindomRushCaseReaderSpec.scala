package misc.codejam.common
import scala.io.Source._
import org.scalatest.BeforeAndAfter
import org.scalatest.Spec
import misc.codejam.sra.KingdomRushCaseReader
import misc.codejam.sra.LevelInfo

class KindomRushCaseReaderSpec extends Spec with BeforeAndAfter {
  
//	val caseReader = ;
    before {
    	
    }
 	
	describe("파일 전체 로딩") {
	  it ("동일 패키지 내 Resource 로딩 여부") {
	    val caseReader = new KingdomRushCaseReader("test.in");
	    caseReader.closeStream()
	  }
	  
	  it("헤더(첫 줄) 내용 확인") {
	    val caseReader = new KingdomRushCaseReader("test.in");
	    assert( caseReader.headLine == "4" )
	    caseReader.closeStream()
	  }
	}
	
	describe("특정 단위로 반복 로딩") {
	   it("각 케이스의 레벨 수 확인") {
		   val caseReader = new KingdomRushCaseReader("test.in");
		   assert( caseReader.readNext().size == 2);
		   assert( caseReader.readNext().size == 3);
		   assert( caseReader.readNext().size == 1);
		   assert( caseReader.readNext().size == 5);
		   caseReader.closeStream()
	   }
	}
}