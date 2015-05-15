package io.github.marad.swt.builder

import org.eclipse.swt.widgets._

class ShellBuilder(val display : Display)
	extends Converters
	with Controls
	with NamedControls
	with Composites
{
	val shell = new Shell(display)
}
