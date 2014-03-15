
package me.lachlanap.timetrackerii.ui

import java.awt._
import java.awt.event._
import javax.swing._

object Helpers {
  def setLaF: Unit = {
    def lafIsCrossPlatfrom = UIManager.getCrossPlatformLookAndFeelClassName == UIManager.getSystemLookAndFeelClassName

    val lafClass = UIManager.getInstalledLookAndFeels
      .find(_.getClassName.toLowerCase.contains("gtk"))
      .filter(_ => lafIsCrossPlatfrom)
      .map(_.getClassName)
      .getOrElse(UIManager.getCrossPlatformLookAndFeelClassName)

    UIManager.setLookAndFeel(lafClass)
  }

  def label(text: String, fontMult: Float = 1f): JLabel = {
    val label = new JLabel(text)

    if (fontMult != 1) {
      val font = label.getFont
      label.setFont(font.deriveFont(font.getSize * fontMult))
    }

    label
  }

  def button(text: String, listener: => Unit = ()): JButton = {
    val button = new JButton(text)
    button.addActionListener(new ActionListener {
      def actionPerformed(e: ActionEvent): Unit = {
        listener
      }
    })

    button
  }
}
