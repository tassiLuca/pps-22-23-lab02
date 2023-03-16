package u02

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.{Assertions, Nested, Test}
import u02.Lab.Shape.*

class ShapeTest:

  @Test def testSquare(): Unit =
    val size = 10
    val square = Square(size)
    assertEquals(size * 4, perimeter(square))
    assertTrue(contains(square, (size, size)))
    assertFalse(contains(square, (size + 1, size + 1)))

  @Test def testRectangle(): Unit =
    val height = 10
    val width = 5
    val rectangle = Rectangle(width = width, height = height)
    assertEquals(2 * (height + width), perimeter(rectangle))
    assertTrue(contains(rectangle, (width, height)))
    assertFalse(contains(rectangle, (width + 1, height + 1)))

  @Test def testCircle(): Unit =
    val radius = 8
    val circle = Circle(radius)
    assertEquals(2 * Math.PI * radius, perimeter(circle))
    assertTrue(contains(circle, (0, 0)))
    assertFalse(contains(circle, (radius + 1, radius + 1)))

