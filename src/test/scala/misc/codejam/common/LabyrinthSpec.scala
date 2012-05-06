package misc.codejam.common
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class LabyrinthSpec extends Spec {
  describe("경로 탐색 테스트") {
    case class BlockCell(val isBlocked:Boolean) extends Cell {
      
	  override def isMovableTo[U<:Cell](that:U): Boolean = {
	    //type U = MazeCell
		that.asInstanceOf[BlockCell].isBlocked		//?
	  }
	}
	
    it("3*3 미로 찾기") {
      val infoMatrix = Map(	// 벽이 막혀있는지를 나타냄
          (1,1)->BlockCell(true),	(2,1)->BlockCell(true),	(3,1)->BlockCell(true),
          (1,2)->BlockCell(true),	(2,2)->BlockCell(false),(3,2)->BlockCell(true),
          (1,3)->BlockCell(true),	(2,3)->BlockCell(true),	(3,3)->BlockCell(true))
     val doneMatrix = Labyrinth.getInitialDoneMatrix(3,3) 	// 모두 가보지 않은 초기 배열
      var maze = new Labyrinth((1,1), infoMatrix, doneMatrix)
      
      assert(Labyrinth.pathFinder(maze,(3,3)).size == 2)
      assert(Labyrinth.pathFinder(maze,(3,3)).toSet == Set(List((1,2), (1,3), (2,3), (3,3)), List((2,1), (3,1), (3,2), (3,3))))
    }
    
     /* S=시작점, D=목적지
      *     S X D O
      *     O X X O
      *     O O O O
      *     O X O X 
      */
     it("4*4 미로 찾기") {
     val infoMatrix = Map(	// 벽이 막혀있는지를 나타냄
          (1,1)->BlockCell(true),	(2,1)->BlockCell(false),(3,1)->BlockCell(true), (4,1) -> BlockCell(true),
          (1,2)->BlockCell(true),	(2,2)->BlockCell(false),(3,2)->BlockCell(false),(4,2) -> BlockCell(true),
          (1,3)->BlockCell(true),	(2,3)->BlockCell(true),	(3,3)->BlockCell(true), (4,3) -> BlockCell(true),
          (1,4)->BlockCell(true),	(2,4)->BlockCell(false),(3,4)->BlockCell(true), (4,4) -> BlockCell(false))
      val doneMatrix = Labyrinth.getInitialDoneMatrix(4,4)
      var maze = new Labyrinth((1,1), infoMatrix, doneMatrix)
      
      Console.println(Labyrinth.pathFinder(maze,(3,1)))
     }
     /* S=시작점, D=목적지
      *     S X D O X
      *     O X O O O
      *     O O O X O
      *     O X O X O
      *     X X O O O
      */ 
     it("5*5 미로 찾기") {
     val infoMatrix = Map(	// 벽이 막혀있는지를 나타냄
          (1,1)->BlockCell(true),	(2,1)->BlockCell(false),(3,1)->BlockCell(true), (4,1) -> BlockCell(true), (5,1) -> BlockCell(false),
          (1,2)->BlockCell(true),	(2,2)->BlockCell(false),(3,2)->BlockCell(false),(4,2) -> BlockCell(true), (5,2) -> BlockCell(true),
          (1,3)->BlockCell(true),	(2,3)->BlockCell(true),	(3,3)->BlockCell(true), (4,3) -> BlockCell(false), (5,3) -> BlockCell(true),
          (1,4)->BlockCell(true),	(2,4)->BlockCell(false),(3,4)->BlockCell(true), (4,4) -> BlockCell(false), (5,4) -> BlockCell(true),
          (1,5)->BlockCell(false),	(2,5)->BlockCell(false),(3,5)->BlockCell(true), (4,5) -> BlockCell(true), (5,5) -> BlockCell(true))
      val doneMatrix = Labyrinth.getInitialDoneMatrix(5,5)
      var maze = new Labyrinth((1,1), infoMatrix, doneMatrix)
     
      Console.println(Labyrinth.pathFinder(maze,(3,1)))
      //assert(Labyrinth.pathFinder(maze,(3,3)).toSet == Set(List((1,2), (1,3), (2,3), (3,3)), List((2,1), (3,1), (3,2), (3,3))))
    }
    
  }

}