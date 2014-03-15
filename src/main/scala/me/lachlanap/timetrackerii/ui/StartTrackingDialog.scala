package me.lachlanap.timetrackerii.ui

import java.awt.GridBagLayout
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing._
import me.lachlanap.timetrackerii.time.Clock
import me.lachlanap.timetrackerii.Constants

class StartTrackingDialog(clock: Clock) {
  private val frame = new JFrame
  private var startTimeLbl: JLabel = _
  private var taskLbl: JLabel = _
  setupDialog(frame)

  def show() = frame.setVisible(true)

  private def setupDialog(frame: JFrame) = {
    frame.setTitle(Constants.formatTitle("Start Tracking"))
    frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE)
    frame.addWindowListener(new WindowAdapter() {
      override def windowClosing(e: WindowEvent): Unit = System.exit(0)
    })

    setupComponents(frame)
    frame.pack
    frame.setSize(frame.getWidth + 200, frame.getHeight)
    frame.setResizable(false)

    updateUI
  }

  private def setupComponents(frame: JFrame) = {
    import Anchor._
    import Fill._
    import UIConstructHelpers._

    val panel = new JPanel

    {
      import panel._

      setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5))
      setLayout(new GridBagLayout)

      startTimeLbl = label("time")
      add(label("Begin", 1.7f), GBC(0, 0, anchor = East).toGBC)
      add(startTimeLbl, GBC(1, 0, fill = Horizontal, weightX = 1).toGBC)
      add(button("Choose..."), GBC(2, 0, fill = Horizontal).toGBC)

      taskLbl = label("Null Task")
      add(label("Task", 1.7f), GBC(0, 1, anchor = East).toGBC)
      add(taskLbl, GBC(1, 1, fill = Horizontal, weightX = 1).toGBC)
      add(button("Choose..."), GBC(2, 1, fill = Horizontal).toGBC)

      add(button("Start"), GBC(0, 2, width = 3, fill = Both, weightX = 1, weightY = 1).toGBC)
    }

    val container = frame.getContentPane
    container.add(panel)
  }

  private def updateUI = {
    startTimeLbl.setText(UITextualHelpers.formatTime(clock.roundedNow))
  }
}
