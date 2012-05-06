package misc.codejam.src.a
import misc.codejam.common.Combinator
import scala.collection.mutable.ListBuffer

class TreeAnalyzer(val clazzes: Map[Int, Leaf]) {
  type Path = List[Leaf]
  private def _pathFinder(start: Leaf, dest: Leaf): List[Path] = {
    if (start.id == dest.id) return List(Nil)
    val accessibleIds: List[Int] = start.accessibleIds.toList
    accessibleIds match {
      case Nil => List(Nil)
      case list: List[Int] => {
        list.flatMap(id => {
          _pathFinder(clazzes(id), dest).map(clazzes(id) :: _)
        })
      }
    }
  }
    
  def pathFinder(start: Leaf, dest: Leaf): List[List[Leaf]] = {
	  val paths:List[List[Leaf]] = _pathFinder(start,dest);
	  paths.filter( (path) => 
	    path !=Nil && path.last.id == dest.id )
  }
  
  def mutipleParents: List[Leaf] = {
    clazzes.values.filter(_.accessibleIds.size > 1).toList
  }
  def mutipleChilds: List[Leaf] = {
    clazzes.values.filter(_.referBy.size > 1).toList
  }
}

object Main extends App {
  val caseReader = new ClassInfoReader("A-test.in");
  val total: Int = caseReader.headLine.toInt
  for (idx <- 1 to total) {
    val clazzes = caseReader.readNext();
    val analyzer = new TreeAnalyzer(clazzes)
    Console.println("Case #%d: %s".format( idx, if(isDiamond(analyzer)) "Yes" else "No"));
  }
  caseReader.closeStream()

  def isDiamond(analyzer: TreeAnalyzer): Boolean = {
    val mutilParent = analyzer.mutipleParents;
    val mutilChild = analyzer.mutipleChilds;

    for (to<- mutilChild; from <- mutilParent) {
      val paths = analyzer.pathFinder(from, to)
      if (paths.size > 1) {
//          Console.println("Diadond:" + from + " - " +to)
//          Console.println(analyzer.pathFinder(from, to))
    	  return true
      }
    }
    false;
  }
}