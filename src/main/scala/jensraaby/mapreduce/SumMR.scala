package jensraaby.mapreduce

/**
 * Created by jens on 16/05/2015.
 */
object SumMR extends App {


  val mrc = new STMRCoordinator[Int,Int,Int]()

  mrc.start(1)


  val mapper = new Mapper[Int,Int] {
    def map(in: Int) = in
  }

  val reducer = new Reducer[Int,Int] {
    def reduce(in: Int, acc: Int): Int = in * acc
  }

  val input = (1 to 5).toList

  val result = mrc.job(mapper,
    reducer,
    1,
    input)

  println(result)
}
