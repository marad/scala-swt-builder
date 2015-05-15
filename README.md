# Scala SWT Builder DSL

This project is attempt to create DSL for SWT GUI.

## Version

This project is under development (not ready for use yet). It currently supports creation of most of the SWT widgets. 
I'd like to throw in event handling as well (currently only `onSelect` is implemented). 

## Installation (SBT 0.13.6+)

In SBT 0.13.6+ you only need to add my Bintray repository

	resolvers += Resolver.bintrayRepo("moriturius", "maven")

and add the dependency

	libraryDependencies += "io.github.marad" %% "swt-builder" % "1.0.0"

## Small Example

With SWT Builder you can create windows quite easily.

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

For bigger example please see `main.scala` file.
		

## Run the demo in Linux

Project is currently configured to only run on 64bit Linux. You can adjust the SWT dependencies
in build.sbt to run on any other platform.

To start the demo you can simply run following command:

	$ sbt run

Assuming that you have SBT installed it'll download dependencies and start the program.

