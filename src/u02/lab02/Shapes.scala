package u02.lab02

object Shapes:

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
      case (Rectangle(w, h), (x, y)) => x >= 0 && x <= w && y >= 0 && y <= h
      case (Square(s), (x, y)) => x >= 0 && x <= s && y >= 0 && y <= s
      case (Circle(r), (x, y)) => Math.sqrt((x * x) + (y * y)) <= r