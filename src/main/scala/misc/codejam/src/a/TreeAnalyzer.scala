package misc.codejam.src.a
import misc.codejam.common.Combinator
import scala.collection.mutable.ListBuffer

object PathStatus extends Enumeration {
	type PathStatus = Value
	val Finding, Reached, Changed, Unreachable = Value
}

class Path(val leafs:List[Claz],var status:PathStatus.Value) 

class TreeAnalyzer(val clazzes: Map[Int, Claz]) {
  import misc.codejam.src.a.PathStatus._
  
  type ClazPath = List[Claz]
  private def _pathFinder(start: Claz, dest: Claz): List[ClazPath] = {
    if (start.id == dest.id) return List(Nil)
    val parentIds: List[Int] = start.accessibleIds.toList
    parentIds match {
      case Nil => List(Nil)
      case list: List[Int] => {
        list.flatMap(id => {
          _pathFinder(clazzes(id), dest).map(clazzes(id) :: _)
        })
      }
  }}
  
//  private def _pathFinder2(paths:ListBuffer[Path], dest: Leaf) = {
//    paths.map( path => {
//      appendNexts(paths, path, dest)
//    }) 
//    if (paths.size == 0 || paths.forall( _.status != PathStatus.Reached)) { 
//    	_pathFinder2(paths, dest)
//    }
//  }
//  
//  def appendNexts(pathList:ListBuffer[Path], path:Path, dest:Leaf)= {
//    if ( path.status != PathStatus.Reached ) {
//	  val nextIds: List[Int] = path.leafs.last.accessibleIds.toList
//	  nextIds match { 
//    	  case Nil => 
//    	    path.status = PathStatus.Unreachable
//    	    deletePath(pathList, path)
//    	  case _ => 
//    	    path.status = PathStatus.Changed
//    	    nextIds.map( (id) => { 
//    		  val leaf = clazzes(id)
//    		  val newPath = new Path(leaf::path.leafs, PathStatus.Finding)
//    		  pathList += newPath
//    		  if ( leaf == dest ) newPath.status = PathStatus.Reached 
//    	    })
//    	    deletePath(pathList, path)
//	  }}
//  }
//  
//  def deletePath(pathList:ListBuffer[Path], path:Path) = {
//	  val idx = pathList.indexOf(path)
//	  pathList.remove(idx)
//  }
  
  def pathFinder(start: Claz, dest: Claz): List[ClazPath] = {
	  val paths:List[ClazPath] = _pathFinder(start,dest);
	  paths.filter( (path) => 
	    path !=Nil && path.last.id == dest.id )
  }
  
  def mutipleParents: List[Claz] = {
    clazzes.values.filter(_.accessibleIds.size > 1).toList
  }
  def mutipleChilds: List[Claz] = {
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