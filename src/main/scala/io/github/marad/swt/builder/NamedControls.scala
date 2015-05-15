package io.github.marad.swt.builder

import org.eclipse.swt.widgets.Widget

trait NamedControls {
  var _controls = Map[String,Widget]()

  implicit class WidgetNameWrapper[T <: Widget](widget: T) {
    def name(t:String) : T = {
      _controls += (t -> widget)
      widget
    }
  }

  def controls = _controls
  def ctls = _controls
  def ctl(name: String) = ctls.get(name)
}
