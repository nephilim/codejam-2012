package misc.codejam.sra

class KingomAnalyzer(val levelInfos:List[LevelInfo]) {


	def findShortestAll2StarCount():Int = {
		// find 2star
		var currentStar:Int = 0;
		var gamePlayCount:Int = 0;
		while ( levelInfos.filter( _.isDone == false ).size > 0 ) {
		var levelInfo:LevelInfo = findPossibleLevel(currentStar, 2, true);
		if (levelInfo != null) {
			currentStar = currentStar + 2;
			levelInfo.isDone = true;
		} else {
			levelInfo = findPossibleLevel(currentStar, 1, false);
			if (levelInfo != null) {
			  currentStar = currentStar + 1;
			} else {
			  return -1;
//			  levelInfo = findPossibleLevel(currentStar, 2, false);
//			  if ( levelInfo != null) {
//			    currentStar = currentStar + 2;
//			  }else {
//			  	levelInfo = findPossibleLevel(currentStar, 1, false);
//				  if ( levelInfo != null) {
//				    currentStar = currentStar + 1;
//				  } else {
//					  return -1;
//				  }
//			  }
			}
		}
		Console.println(currentStar, levelInfo);
		gamePlayCount = gamePlayCount +1;
		}
		gamePlayCount;
	}
	
	// -1 when there is no level
	def findPossibleLevel(currentStar:Int, rewardStar:Int, filter:Boolean):LevelInfo = {
		//Console.println("%d to reward %d".format(currentStar,rewardStar, filter));
		var target:List[LevelInfo] = null;
		if ( filter ) {
		  target = levelInfos.filter( _.isDone == false );
		} 
		else {
		  target = levelInfos;
		}
		
		for ( levelInfo <- target ) {
		  var compareTo = levelInfo.twoStar;
		  if( rewardStar == 1) {
		    compareTo = levelInfo.oneStar;
		  }
		  if( currentStar >= compareTo ) {
			return levelInfo;
		  } 
		} 
		return null;
	}

}