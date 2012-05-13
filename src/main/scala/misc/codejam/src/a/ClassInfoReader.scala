package misc.codejam.src.a

import scala.collection.mutable.ListBuffer
import misc.codejam.common._

// todo : resource path에 pattern matching + implicit type conversion 활용
// pre-initializing
class ClassInfoReader(resourcePath: String)
  extends CodejamCaseReader[Claz](resourcePath)
  with Headline {

  // chunk 처리용 type 선언
  type ChunkType = Map[Int, Claz]

  override val headLine = lines.next

  override def readNext(): Map[Int, Claz] = {
    val totalClass = lines.next.toInt
    require(totalClass > 0)

    val mutableMap = scala.collection.mutable.Map[Int, Claz]()
    for (idx <- 1 to totalClass) {
      val info = Tuple2(idx, new Claz(idx, new ListBuffer(), new ListBuffer()))
      //      Console.println(info)
      mutableMap += info
    }

    for (idx <- 1 to totalClass) {
      val columns: List[String] = lines.next.split(" ").toList
      val parentCount = columns.head.toInt;
      if (parentCount > 0) {
        val inheritList = columns.tail
        val clazz = mutableMap(idx)
        for (pidStr <- inheritList) {
          val pid = pidStr.toInt
          clazz.accessibleIds +=  pid
          mutableMap(pid).referBy += clazz.id
        }
      }
    }
    mutableMap.toMap
  }

}   
