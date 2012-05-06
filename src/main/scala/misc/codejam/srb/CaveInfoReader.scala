//package misc.codejam.sra
//
//import scala.collection.mutable.ListBuffer
//
//import misc.codejam.common.CodejamCaseReader
//import misc.codejam.common.Headline
//import misc.codejam.sra.LevelInfo
//import misc.codejam.srb.CellInfo
//
//class CaveInfoReader(resourcePath: String)
//  extends CodejamCaseReader[CellInfo](resourcePath)
//  with Headline {
//  
//  // chunk 처리용 type 선언
//  type ChunkType = List[List[CellInfo]]			
//  
//  override val headLine = lines.next
//
//  override def readNext(): List[LevelInfo] = {
////    val totalLevel = lines.next.toInt
////    require(totalLevel > 0)
////
////    val levelInfos:ListBuffer[LevelInfo] = ListBuffer();
////
////    for (idx <- 1 to totalLevel) {
////      val Array(oneStar, twoStar) = lines.next.split(" ")
////     // val levelInfo = new CellInfo(idx, oneStar.toInt, twoStar.toInt, StarLevel.NotFished)
////     // levelInfos+= levelInfo
////    }
////    levelInfos.toList
//    Nil
//  }
//
//}   
