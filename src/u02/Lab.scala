package u02

import u02.Optionals.Option

object Lab extends App:
  //************************************** TASK 2A **************************************
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
  println()

  val empty: String => Boolean = _ == ""
  // val neg: (String => Boolean) => String => Boolean = f => s => !f(s)
  val neg: (String => Boolean) => String => Boolean = f => !f(_)
  val notEmpty: String => Boolean = neg(empty)

  println(s"empty('s') = ${empty("")}")
  println(s"notEmpty('') = ${notEmpty("")}")
  println(s"notEmpty('foo') && !notEmpty('') = ${notEmpty("foo") && !notEmpty("")}")
  println()

  def neg2(f: String => Boolean)(s: String): Boolean = !f(s)
  val notEmpty2: String => Boolean = neg2(empty)

  println(s"notEmpty2('') = ${notEmpty2("")}")
  println(s"notEmpty2('foo') && !notEmpty2('') = ${notEmpty("foo") && !notEmpty("")}")
  println()

  def neg3[X](f: X => Boolean)(x: X): Boolean = !f(x)

  //************************************** TASK 2B **************************************
  // val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  val p1 = (x: Int) => (y: Int) => (z: Int) => x <= y && y == z
  // val p2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z
  val p2 = (x: Int, y: Int, z: Int) => x <= y && y == z
  def p3(x: Int)(y: Int)(z: Int) = x <= y && y == z
  def p4(x: Int, y: Int, z: Int) = x <= y && y == z

  println(p3(5)(5)(5))
  println(p4(10, 5, 5))
  println()

  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))

  println(compose(_ - 1, _ * 2)(5))
  println()

  def compose3[X, Y, Z](f: Y => Z, g: X => Y): X => Z = x => f(g(x))

  println(compose3((n: Int) => n * 2, (s: String) => s.length)("hello"))
  println()

  //************************************** TASK 3 ***************************************
  @annotation.tailrec
  def gcd(a: Int, b: Int): Int = a % b match
    case 0 => b
    case r => gcd(b, r)

  println(gcd(8, 12))
  println(gcd(14, 7))
  println(gcd(7, 14))
  println()

  //************************************** TASK 4 ***************************************
  enum Shape:
    case Rectangle(width: Double, height: Double)
    case Square(size: Double)
    case Circle(radius: Double)

  object Shape:
    def perimeter(shape: Shape): Double = shape match
      case Rectangle(w, h) => 2 * (w + h)
      case Square(s) => 4 * s
      case Circle(r) => 2 * Math.PI * r

    def contains(shape: Shape, point: (Double, Double)): Boolean = (shape, point) match
      case (Rectangle(w, h), (x, y)) => isInside(x)(0)(w) && isInside(y)(0)(h)
      case (Square(s), (x, y)) => isInside(x)(0)(s) && isInside(y)(0)(s)
      case (Circle(r), (x, y)) => Math.sqrt((x * x) + (y * y)) <= r

    private def isInside(x: Double)(infLimit: Double)(maxLimit: Double) = x >= infLimit && x <= maxLimit

  //************************************** TASK 5 ***************************************
  import Option.*

  def filter[A](opt: Option[A])(predicate: A => Boolean): Option[A] = opt match
    case Some(a) if predicate(a) => opt
    case _ => None()

  def map[A, B](opt: Option[A])(transform: A => B): Option[B] = opt match
    case Some(a) => Some(transform(a))
    case _ => None()

  def fold[A, B](opt: Option[A])(default: B)(transform: A => B): B = opt match
    case Some(a) => transform(a)
    case _ => default

  println(filter(Some(5))(_ > 2))
  println(filter(Some(5))(_ > 8))
  println(filter(None[Int]())(_ > 2))
  println()

  println(map(Some(5))(_ > 2))
  println(map(Some(5))(_ > 8))
  println(filter(None[Int]())(_ > 2))
  println()

  println(fold(Some(5))(1)(_ + 1))
  println(fold(None[Int]())(1)(_ + 1))
  println(fold(Some("Hi Scala :)"))(None())((s: String) => Some(s.length)))
  println()
