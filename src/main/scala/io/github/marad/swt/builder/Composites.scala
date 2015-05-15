package io.github.marad.swt.builder

import scala.util.DynamicVariable
import org.eclipse.swt.widgets.{Composite, Shell}

trait Composites {
  implicit class CompositeWrapper[T <: Composite](composite :T) {
    def withChildren(f: => Unit) : T = {
      context.withValue(composite) { f }
      composite
    }
  }

  val shell: Shell
  protected lazy val context = new DynamicVariable[Composite]( shell )
}
