package jensraaby.mapreduce

/**
 * Created by jens on 16/05/2015.
 */
trait MRCoordinator[A,B,C] {
  // A is the input type
  // B is the intermediate type for combining into the results
  // C is the result type



  def start(numMappers: Int): MRCoordinator[A,B,C]

  def job(mapFun: Mapper[A,B],
          reduceFun: Reducer[B,C],
          initial: C,
          data: List[A]): Option[C]

}

trait Mapper[A,B] {
  def map(in: A): B
}

trait Reducer[B,C] {
  def reduce(c: C, b: B): C
}



class STMRCoordinator[A,B,C] extends MRCoordinator[A,B,C] {

  def start(numMappers: Int) = {
    println("Starting single threaded map reducer")
    new STMRCoordinator[A, B, C]()
  }

  override def job(mapFun: Mapper[A, B],
                   reduceFun: Reducer[B,C],
                   initial: C,
                   data: List[A]): Option[C] = {

    data match {
      case Nil => None
      case (lst) =>
        val bs = lst.map(mapFun.map)

        Some(bs.foldLeft(initial)(reduceFun.reduce))
    }
  }

}

