package marad.scala.swt.builder;

import scala.util.DynamicVariable
import org.eclipse.swt.SWT
import org.eclipse.swt.events.{SelectionListener,SelectionAdapter,SelectionEvent}
import org.eclipse.swt.widgets._
import org.eclipse.swt.layout._

class ShellBuilder(val display : Display) {

	// Wrapper classes
	class SetTextWrapper[T <: {def setText(text:String)}](val subject:T) {	
		def text(t:String) : T = {
			subject.setText(t)
			return subject
		}
	}
	implicit def convertToSetTextWrapper[T <: {def setText(text:String)}] (t:T) = new SetTextWrapper(t)


	class SetLayoutWrapper[T <: {def setLayout(layout:Layout)}](val subject:T) {
		def fillLayout(layoutType:Int) : T = {
			subject.setLayout(new FillLayout(layoutType))
			return subject
		}

		def fillLayout(layoutType:Int, margin:Int) : T = {
			val layout = new FillLayout(layoutType)
			layout.marginHeight = margin
			layout.marginWidth = margin
			subject.setLayout(layout)
			return subject
		}

		def gridLayout(columns:Int) : T = {
			return gridLayout(columns, false)
		}

		def gridLayout(columns:Int, equalWidth:Boolean) : T = {
			subject.setLayout(new GridLayout(columns, equalWidth))
			return subject
		}
	}
	implicit def convertToSetLayoutWrapper[T <: {def setLayout(layout:Layout)}](t:T) = new SetLayoutWrapper(t)

	class SetLayoutDataWrapper[T <: {def setLayoutData(data:Object)}](val subject:T) {

		def gridData(data:GridData) : T = {
			subject.setLayoutData(data)
			return subject
		}

		def gridData(style:Int) : T = {
			subject.setLayoutData(new GridData(style))
			return subject
		}

		def gridData(width:Int, height:Int) : T = {
			subject.setLayoutData(new GridData(width,height))
			return subject
		}

		def gridData(hAlignment:Int, vAlignment:Int, grabExcessHorizontalSpace:Boolean, grabExcessVerticalSpace:Boolean) : T = {
			subject.setLayoutData(new GridData(hAlignment, vAlignment, grabExcessHorizontalSpace, grabExcessVerticalSpace))
			return subject
		}

		def gridData(hAlignment:Int, vAlignment:Int, grabExcessHorizontalSpace:Boolean, grabExcessVerticalSpace:Boolean, verticalSpan:Int, horizontalSpan:Int) : T = {
			subject.setLayoutData(new GridData(hAlignment, vAlignment, grabExcessHorizontalSpace, grabExcessVerticalSpace, verticalSpan, horizontalSpan))
			return subject
		}
	}
	implicit def convertToSetLayoutDataWrapper[T <: {def setLayoutData(data:Object)}](t:T) = new SetLayoutDataWrapper(t)

	class SetSelectionWrapper[T <: {def addSelectionListener(listener:SelectionListener)}](val subject:T) {
		def onSelect(f: => Unit) : T = {
			subject.addSelectionListener(new SelectionAdapter() {
				override def widgetSelected(e:SelectionEvent) : Unit = f
			})
			return subject
		}
	}
	implicit def convertToSetSelectionWrapper[T <: {def addSelectionListener(listener:SelectionListener)}](t:T) = new SetSelectionWrapper(t)

	// one additional converter to save names
	class CompositeWrapper[T <: Composite](c :T) {
		def withChildren(f: => Unit) : T = {
			context.withValue(c) { f } 
			return c
		}
	}
	implicit def convertToCompositeWrapper[T <: Composite](c:T) = new CompositeWrapper(c)

	class WidgetNameWrapper[T <: Widget](w : T) {
		def name(t:String) : T = {
			ctls += (t -> w)
			return w
		}
	}
	implicit def convertToWidgetNameWrapper[T <: Widget](w:T) = new WidgetNameWrapper(w)

	// the shell we're building
	val shellObject = new Shell(display)
	val context = new DynamicVariable[Composite]( shellObject )
	var ctls:Map[String,Widget] = Map()

	def get() : Tuple2[Shell, Map[String,Widget]] = (shellObject, ctls)
	def shell() : Shell = shellObject

	def label() : Label = new Label(context.value, SWT.NONE)
	def label(style:Int) : Label = new Label(context.value, style)
	def button() : Button = new Button(context.value, SWT.PUSH)
	def button(style:Int) : Button = new Button(context.value, style)
	def radio() : Button = new Button(context.value, SWT.RADIO)
	def checkbox() : Button = new Button(context.value, SWT.CHECK)
	def edit() : Text = new Text(context.value, SWT.SINGLE)
	def edit(style:Int) : Text = new Text(context.value, style)
	def spinner() : Spinner = new Spinner(context.value, SWT.NONE)
	def spinner(style:Int) : Spinner = new Spinner(context.value, style)
	def composite() : Composite = new Composite(context.value, SWT.NONE)
	def composite(style:Int) : Composite = new Composite(context.value, style)
	def group() : Group = new Group(context.value, SWT.NONE)
	def group(style:Int) : Group = new Group(context.value, style)
	def canvas() : Canvas = new Canvas(context.value, SWT.NONE)
	def canvas(style:Int) : Canvas = new Canvas(context.value, style)
}
