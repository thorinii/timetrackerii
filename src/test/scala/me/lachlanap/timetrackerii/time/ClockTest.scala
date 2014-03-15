package me.lachlanap.timetrackerii.time

import com.github.nscala_time.time.Imports._
import org.scalatest._

class ClockTest extends FlatSpec with Matchers {
  class FakeMinuteClock(mins: Int) extends Clock {
    def now = new DateTime(2014, 1, 1, 0, mins)
  }

  "Clock" should "round to 0 mins when time is 2 mins" in {
    val clock = new FakeMinuteClock(2)
    clock.roundedNow shouldEqual new DateTime(2014, 1, 1, 0, 0)
  }

  "Clock" should "round to 5 mins when time is 3 mins" in {
    val clock = new FakeMinuteClock(3)
    clock.roundedNow shouldEqual new DateTime(2014, 1, 1, 0, 5)
  }

  "Clock" should "round to 20 mins when time is 22 mins" in {
    val clock = new FakeMinuteClock(22)
    clock.roundedNow shouldEqual new DateTime(2014, 1, 1, 0, 20)
  }

  "Clock" should "round to 25 mins when time is 23 mins" in {
    val clock = new FakeMinuteClock(23)
    clock.roundedNow shouldEqual new DateTime(2014, 1, 1, 0, 25)
  }
}
