package me.lachlanap.timetrackerii

import org.scalatest._

class ConstantsTest extends FlatSpec with Matchers {

  "Constants" should "format a title correctly" in {
    Constants.formatTitle("Title") shouldEqual ("Time Tracker II - Title")
  }

}
