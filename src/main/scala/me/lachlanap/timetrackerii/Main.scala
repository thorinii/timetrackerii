package me.lachlanap.timetrackerii

import me.lachlanap.timetrackerii.ui.Helpers
import me.lachlanap.timetrackerii.ui.StartTrackingDialog

object Main {
  def main(args: Array[String]): Unit = {
    Helpers.setLaF

    val startTrackingDialog = new StartTrackingDialog
    startTrackingDialog.show
  }
}
