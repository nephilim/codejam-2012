package misc.codejam.common

object Combinator {
  def apply[T](n: Int, list: List[T]): List[List[T]] = {
    require( (n <= list.size) && ( n > 0))
    //if( n > list.size) { Console.println("--- %d, %s".format(n,list))}
    list match {
      case _ if n == 1 => 
      	list.map(List(_))
      case _ if n == list.size =>
        List(list)
      case _ => {
        list.dropRight(n-1).flatMap( elem => {
            val target = list.dropWhile( _ != elem ).tail
            apply(n-1, target).map( elem :: _ ) 
        })
      }
    }}
}

