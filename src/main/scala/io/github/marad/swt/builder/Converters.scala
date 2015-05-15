package io.github.marad.swt.builder

import org.eclipse.swt.events.{SelectionListener,SelectionAdapter,SelectionEvent}
import org.eclipse.swt.widgets._
import org.eclipse.swt.layout._

trait Converters {
  type WidgetWithText = {def setText(text: String)}
  implicit class SetTextWrapper[T <: WidgetWithText](val subject: T) {
    def text(t:String): T = {
      subject.setText(t)
      subject
    }
  }

  type WidgetWithLayout = {def setLayout(layout: Layout)}
  implicit class SetLayoutWrapper[T <: WidgetWithLayout](val subject: T) {
    def fillLayout(layoutType:Int): T = {
      subject.setLayout(new FillLayout(layoutType))
      subject
    }

    def fillLayout(layoutType:Int, margin:Int): T = {
      val layout = new FillLayout(layoutType)
      layout.marginHeight = margin
      layout.marginWidth = margin
      subject.setLayout(layout)
      subject
    }

    def gridLayout(columns:Int, equalWidth:Boolean): T = {
      subject.setLayout(new GridLayout(columns, equalWidth))
      subject
    }
  }

  type WidgetWithLayoutData = {def setLayoutData(data: Object)}
  implicit class SetLayoutDataWrapper[T <: WidgetWithLayoutData](val subject: T) {
    def gridData(data:GridData): T = {
      subject.setLayoutData(data)
      subject
    }

    def gridData(style:Int): T = {
      subject.setLayoutData(new GridData(style))
      subject
    }

    def gridData(width:Int, height:Int): T = {
      subject.setLayoutData(new GridData(width,height))
      subject
    }

    def gridData(hAlignment:Int, vAlignment:Int,
                 grabExcessHorizontalSpace:Boolean, grabExcessVerticalSpace:Boolean): T = {
      subject.setLayoutData(new GridData(hAlignment, vAlignment, grabExcessHorizontalSpace, grabExcessVerticalSpace))
      subject
    }

    def gridData(hAlignment:Int, vAlignment:Int, grabExcessHorizontalSpace:Boolean, grabExcessVerticalSpace:Boolean,
                 verticalSpan:Int, horizontalSpan:Int): T = {
      subject.setLayoutData(new GridData(hAlignment, vAlignment, grabExcessHorizontalSpace,
        grabExcessVerticalSpace, verticalSpan, horizontalSpan))
      subject
    }
  }

  type SelectableWidget = {def addSelectionListener(listener:SelectionListener)}
  implicit class SetSelectionWrapper[T <: SelectableWidget](val subject:T) {
    def onSelect(f: => Unit) : T = {
      subject.addSelectionListener(new SelectionAdapter() {
        override def widgetSelected(e:SelectionEvent) : Unit = f
      })
      subject
    }
  }
}
