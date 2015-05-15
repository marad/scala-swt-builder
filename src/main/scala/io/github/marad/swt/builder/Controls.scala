package io.github.marad.swt.builder

import org.eclipse.swt.SWT
import org.eclipse.swt.widgets._

import scala.util.DynamicVariable

trait Controls {
  protected def context: DynamicVariable[Composite]

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
