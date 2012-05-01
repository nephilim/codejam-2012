package misc.codejam.sra

class KingomAnalyzer(val levelInfos:List[LevelInfo]) {

	type StarCount = Int 
	var current:StarCount = 0;
	
	def findShortestAll2StarCount():Int = {
		// find 2star
		
		var gamePlayCount:Int = 0;
		while ( levelInfos.filter( _.prevStarLevel == StarLevel.NotFished ).size > 0 ) {
		var result = findLevelAndPlay(StarLevel.Two, true);
		result match {
		  case None => {
			  result = findLevelAndPlay(StarLevel.One, false);
			  result match {
			    case Some(levelInfo) => 
			    case None => return -1
			  }
		  }
		  case _ =>
		}
		gamePlayCount = gamePlayCount +1;
		}
		gamePlayCount;
	}
	
	def findLevelAndPlay(goal:StarLevel.Value, filter:Boolean):Option[LevelInfo] = {
		val result = findLevel(current, goal, filter);
		result match {
		  case Some(levelInfo) => {
		    current = current + goal.id;
			// bonus
			if ( goal == StarLevel.Two && levelInfo.prevStarLevel == StarLevel.One) {
			  current = current + StarLevel.One.id
			}
			levelInfo.prevStarLevel = goal;
		  } 
		  case _ => 
		}
		result
	}
	
	def findLevel(currentStar:Int, goal:StarLevel.Value, filter:Boolean):Option[LevelInfo] = {
		//Console.println("%d to reward %d".format(currentStar,rewardStar, filter));
		var target:List[LevelInfo] = null;
		if ( filter ) {
		  target = levelInfos.filter( _.prevStarLevel == StarLevel.NotFished );
		} 
		else {
		  target = levelInfos;
		}
		
		for ( levelInfo <- target ) {
		  var compareTo = levelInfo.twoStar;
		  if( goal == StarLevel.One) {
		    compareTo = levelInfo.oneStar;
		  }
		  if( currentStar >= compareTo ) {
			return Some(levelInfo);
		  } 
		} 
		None;
	}

}