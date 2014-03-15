package me.lachlanap.timetrackerii.time

import com.github.nscala_time.time.Imports._

trait Clock {
  val Increment = 5

  def now: DateTime

  def roundedNow = {
    now.withMinuteOfHour((Math.round(now.getMinuteOfHour().toDouble / Increment) * Increment).toInt)
      .minuteOfDay().roundFloorCopy()
  }
}

class SystemClock extends Clock {
  override def now = DateTime.now
}