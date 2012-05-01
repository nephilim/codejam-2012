package misc.codejam.sra

import scala.collection.mutable.ListBuffer
import misc.codejam.common._

// todo : resource path에 pattern matching + implicit type conversion 활용
// pre-initializing
class KingdomRushCaseReader(resourcePath: String)
  extends CodejamCaseReader[LevelInfo](resourcePath)
  with Headline {
  
  // chunk 처리용 type 선언
  type ChunkType = List[LevelInfo]			
  
  override val headLine = lines.next

  override def readNext(): List[LevelInfo] = {
    val totalLevel = lines.next.toInt
    require(totalLevel > 0)

    val levelInfos:ListBuffer[LevelInfo] = ListBuffer();

    for (idx <- 1 to totalLevel) {
      val Array(oneStar, twoStar) = lines.next.split(" ")
      val levelInfo = new LevelInfo(idx, oneStar.toInt, twoStar.toInt, StarLevel.NotFished)
      levelInfos+= levelInfo
    }
    levelInfos.toList
  }

}   
