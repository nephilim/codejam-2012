package misc.codejam.common
import scala.io.Source._
import scala.io.Source

abstract class CodejamCaseReader[T](val filePath:String) {
	type ChunkType
	protected val source = fromURL(getClass.getResource(filePath))
	protected val lines = source.getLines()
	
	def readNext():ChunkType

	def closeStream() = source.close
	
}

trait Headline {
	val headLine:String
//	require( headLine )
}