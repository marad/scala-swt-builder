package io.github.marad.swt.builder

import org.eclipse.swt.widgets.{ Display, Shell }

class ShellBuilder(val display : Display)
	extends Converters
	with Controls
	with ControlNames
	with Composites
{
	val shell = new Shell(display)
}
