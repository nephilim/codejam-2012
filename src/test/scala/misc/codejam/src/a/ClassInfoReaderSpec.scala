package misc.codejam.src.a
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import scala.collection.mutable.ListBuffer

@RunWith(classOf[JUnitRunner])
class ClassInfoReaderSpec extends Spec {
	describe("읽어 ") {
	  it("파일을") {
		val caseReader = new ClassInfoReader("A-test.in");
		Console.println(caseReader.readNext())
		Console.println(caseReader.readNext())
		Console.println(caseReader.readNext())
	    caseReader.closeStream()
	  }
	}
}