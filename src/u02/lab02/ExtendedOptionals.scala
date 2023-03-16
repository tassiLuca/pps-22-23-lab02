package u02.lab02

import u02.Optionals.Option

object ExtendedOptionals extends App:

  import Option.*

  def filter[A](opt: Option[A])(predicate: A => Boolean): Option[A] = opt match
    case Some(a) if predicate(a) => opt
    case _ => None()

  println(filter(Some(5))(_ > 2))
  println(filter(Some(5))(_ > 8))
  println(filter(None[Int]())(_ > 2))

  def map[A, B](opt: Option[A])(transform: A => B): Option[B] = opt match
    case Some(a) => Some(transform(a))
    case _ => None()

  println(map(Some(5))(_ > 2))
  println(map(Some(5))(_ > 8))
  println(filter(None[Int]())(_ > 2))

  def fold[A, B](opt: Option[A])(default: B)(transform: A => B): B = opt match
    case Some(a) => transform(a)
    case _ => default

  println(fold(Some(5))(1)(_ + 1))
  println(fold(None[Int]())(1)(_ + 1))
  println(fold(Some("Hello Scala :)"))(None())((s: String) => Some(s.length)))