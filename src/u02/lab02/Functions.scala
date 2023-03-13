package u02.lab02

object Functions extends App:

  val positive: Int => String = _ match
    case n if n >= 0 => "positive"
    case n if n < 0 => "negative"

  def positive2(number: Int): String = number match
    case n if n >= 0 => "positive"
    case n if n < 0 => "negative"

  println(s"positive(5) = ${positive(5)}")
  println(s"positive2(5) = ${positive2(5)}")
  println(s"positive(-1) = ${positive(-1)}")
  println(s"positive2(-1) = ${positive2(-1)}")

  println(s"${"-".repeat(50)}")

  // val neg: (String => Boolean) => String => Boolean = f => s => !f(s)
  val neg: (String => Boolean) => String => Boolean = f => !f(_)
  val empty: String => Boolean = _ == ""
  val notEmpty = neg(empty)

  println(s"empty('s') = ${empty("")}")
  println(s"notEmpty('') = ${notEmpty("")}")
  println(s"notEmpty('foo') && !notEmpty('') = ${notEmpty("foo") && !notEmpty("")}")

  def neg2(f: String => Boolean)(s: String): Boolean = !f(s)
  val notEmpty2 = neg2(empty)
  println(s"notEmpty2('') = ${notEmpty2("")}")
  println(s"notEmpty2('foo') && !notEmpty2('') = ${notEmpty("foo") && !notEmpty("")}")
  def neg3[X](f: X => Boolean)(x: X): Boolean = !f(x)

  println(s"${"-".repeat(50)}")

  // val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  val p1 = (x: Int) => (y: Int) => (z: Int) => x <= y && y == z
  // val p2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z
  val p2 = (x: Int, y: Int, z: Int) => x <= y && y == z
  def p3(x: Int)(y: Int)(z: Int) = x <= y && y == z
  def p4(x: Int, y: Int, z: Int) = x <= y && y == z

  println(p3(5)(5)(5))
  println(p4(10, 5, 5))

  println(s"${"-".repeat(50)}")

  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))
  // def compose2(f: Int => Int, g: Int => Int): Int => Int = f/(g(_))

  println(compose(_ - 1, _ * 2)(5))

  def compose3[X, Y, Z](f: Y => Z, g: X => Y): X => Z = x => f(g(x))

  // val g: String => Int = s => s.size
  // val f: Int => Int = _ * 2
  println(compose3((n: Int) => n * 2, (s: String) => s.size)("hello"))