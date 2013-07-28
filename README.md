Scala SWT Builder DSL
=====================

This project is attempt to create DSL for SWT GUI. 

Small Example
-------------

With SWT Builder you can create windows quite easily. For example please see `main.scala` file.

Please note that there are two notations possible. Basic one with one controll per line:

	group text "Name" gridLayout 2 gridData (SWT.FILL, SWT.FILL, true, true) withChildren {
		label text "First"
		edit text "Bullet" gridData (SWT.FILL, SWT.CENTER, true, true) name "first"
		label text "Last"
		edit text "Tooth" gridData (SWT.FILL, SWT.CENTER, true, true) name "last"
	}

Using alternative syntax you can avoid declaring each controll in one line:

	group()
		.text("Name")
		.gridLayout(2)
		.gridData(SWT.FILL, SWT.FILL, true, true)
		.withChildren {
			label().text("First")
			edit().text("Bullet").gridData(SWT.FILL, SWT.CENTER, true, true).name("first")
			label().text("Last")
			edit().text("Tooth").gridData(SWT.FILL, SWT.CENTER, true, true).name("last")
		}