package misc.codejam.src.a
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import scala.collection.mutable.ListBuffer

@RunWith(classOf[JUnitRunner])
class PathFinderSpec extends Spec {
  describe("Pathfinder should return all available paths") {
    it("Find all paths from leaf1 to leaf4") {
        val leaf1 = new Leaf(1,new ListBuffer(),new ListBuffer());
        val leaf2 = new Leaf(2,new ListBuffer(),new ListBuffer());
        val leaf3 = new Leaf(3,new ListBuffer(),new ListBuffer());
        val leaf4 = new Leaf(4,new ListBuffer(),new ListBuffer());
        val leaf5 = new Leaf(5,new ListBuffer(),new ListBuffer());
        
        leaf1.accessibleIds += 2
        leaf1.accessibleIds += 3
        leaf1.accessibleIds += 4
        leaf2.accessibleIds += 5
        leaf3.accessibleIds += 5
        leaf4.accessibleIds += 5
        
    	val analyzer =new TreeAnalyzer(Map(1->leaf1,2->leaf2, 3->leaf3, 4->leaf4, 5->leaf5))
        Console.println(analyzer.pathFinder(leaf1, leaf5).size)
    }
  }

}