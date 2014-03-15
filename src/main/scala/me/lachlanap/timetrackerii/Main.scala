package me.lachlanap.timetrackerii

import me.lachlanap.timetrackerii.ui.StartTrackingDialog

object Main {
  def main(args: Array[String]): Unit = {
    val startTrackingDialog = new StartTrackingDialog
    startTrackingDialog.show
  }
}
