
package me.lachlanap.timetrackerii.ui

import java.awt.Dimension
import java.awt.GridBagLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing._
import me.lachlanap.timetrackerii.Constants

class StartTrackingDialog {
  private val frame = new JFrame
  setupDialog(frame)

  def show(): Unit = frame.setVisible(true)

  private def setupDialog(frame: JFrame): Unit = {
    frame.setTitle(Constants.formatTitle("Start Tracking"))
    frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE)
    frame.addWindowListener(new WindowAdapter() {
      override def windowClosing(e: WindowEvent): Unit = System.exit(0)
    })

    setupComponents(frame)
    frame.pack
    frame.setSize(frame.getWidth + 200, frame.getHeight)
    frame.setResizable(false)
  }

  private def setupComponents(frame: JFrame): Unit = {
    import Anchor._
    import Fill._

    val panel = new JPanel

    {
      import panel._

      setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5))
      setLayout(new GridBagLayout)

      add(label("Begin", 1.7f), GBC(0, 0, anchor = East).toGBC)
      add(label("11:40 AM"), GBC(1, 0, fill = Horizontal, weightX = 1).toGBC)
      add(button("Choose..."), GBC(2, 0, fill = Horizontal).toGBC)

      add(label("Task", 1.7f), GBC(0, 1, anchor = East).toGBC)
      add(label("Null Task"), GBC(1, 1, fill = Horizontal, weightX = 1).toGBC)
      add(button("Choose..."), GBC(2, 1, fill = Horizontal).toGBC)

      add(button("Start"), GBC(0, 2, width = 3, fill = Both, weightX = 1, weightY = 1).toGBC)
    }

    val container = frame.getContentPane
    container.add(panel)
  }

  private def label(text: String, fontMult: Float = 1f): JLabel = {
    val label = new JLabel(text)

    if (fontMult != 1) {
      val font = label.getFont
      label.setFont(font.deriveFont(font.getSize * fontMult))
    }

    label
  }

  private def button(text: String, listener: => Unit = ()): JButton = {
    val button = new JButton(text)
    button.addActionListener(new ActionListener {
      def actionPerformed(e: ActionEvent): Unit = {
        listener
      }
    })

    button
  }
}
