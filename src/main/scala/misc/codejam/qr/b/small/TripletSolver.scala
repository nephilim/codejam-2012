package misc.codejam.qr
import scala.collection.mutable.ListBuffer

class SurprisingConditionException extends RuntimeException

object TripletSolver {
  type IsSurprising = Boolean
  type ScoreDistributionBasis = Tuple2[Int,Boolean]
  private val numJudges:Int = 3;
  
  def countBestScoreOverP (
      totalScores:ListBuffer[ScoreDistributionBasis], 
      pPoint:Int):Int  = {
      totalScores.count( bestScore(_) >= pPoint)
  }
  
  def bestScore(basis:ScoreDistributionBasis):Int = {
    bestScore( basis._1, basis._2 )
  }
  
  def bestScore(totalScore:Int, isSurprising:IsSurprising = false):Int = {
     if ( totalScore < 2 && isSurprising ) {
    	 throw new SurprisingConditionException
     }
	 val remnant:Int = totalScore % numJudges	// 나머지
	 val normScore:Int = (totalScore - remnant)/numJudges // 기준점수
	 
	 // Adjust the norm score to best score 
	 // to match conditions by cases
	 if ( isSurprising && remnant == 2 ) normScore + 2
	 else if ( !isSurprising && remnant == 0 ) normScore 
	 else normScore + 1
  }
}