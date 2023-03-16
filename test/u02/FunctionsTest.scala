package u02

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import u02.Lab.*

class FunctionsTest:

  @Test def testNegOnInt(): Unit =
    val f: Int => Boolean = _ >= 0
    assertTrue(neg3(f)(-1))
    assertFalse(neg3(f)(0))

  @Test def testNegOnString(): Unit =
    val f: String => Boolean = _ == ""
    assertTrue(neg3(f)("hello"))
    assertFalse(neg3(f)(""))
