package u02

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import u02.lab02.Functions.neg3

class FunctionsTest:

  @Test def testNegOnInt() =
    val f: Int => Boolean = _ >= 0
    assertTrue(neg3(f)(-1))
    assertFalse(neg3(f)(0))

  @Test def testNegOnString() =
    val f: String => Boolean = _ == ""
    assertTrue(neg3(f)("hello"))
    assertFalse(neg3(f)(""))
