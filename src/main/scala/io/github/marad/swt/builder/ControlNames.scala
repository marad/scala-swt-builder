package io.github.marad.swt.builder

import org.eclipse.swt.widgets.Widget

trait ControlNames {
  private var _controls = Map[String,Widget]()

  implicit class WidgetNameWrapper[T <: Widget](widget: T) {
    def name(t:String) : T = {
      _controls += (t -> widget)
      widget
    }
  }

  def controls = _controls
  def ctl(name: String) = controls.get(name)
}
