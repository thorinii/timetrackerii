package me.lachlanap.timetrackerii

import me.lachlanap.timetrackerii.time._
import me.lachlanap.timetrackerii.ui.UIConstructHelpers
import me.lachlanap.timetrackerii.ui.StartTrackingDialog

object Main {
  def main(args: Array[String]) = {
    UIConstructHelpers.setLaF

    val clock = new SystemClock

    val startTrackingDialog = new StartTrackingDialog(clock)
    startTrackingDialog.show
  }
}
