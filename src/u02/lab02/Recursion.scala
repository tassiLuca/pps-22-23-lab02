package u02.lab02

object Recursion extends App:

  @annotation.tailrec
  def gcd(a: Int, b: Int): Int = a % b match
    case 0 => b
    case r => gcd(b, r)

  println(gcd(8, 12))
  println(gcd(14, 7))
