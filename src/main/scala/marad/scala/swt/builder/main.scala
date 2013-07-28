package marad.scala.swt.builder;

import org.eclipse.swt.events.{SelectionListener, SelectionEvent, SelectionAdapter}
import org.eclipse.swt.layout.{GridData, FillLayout, GridLayout}
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets._


object TestObject {    

	def main(args: Array[String]) {
    val display = new Display()

    val sh = new ShellBuilder(display) {
        shell text "User Profile" gridLayout (2, true)
        group text "Name" gridLayout 2 gridData (SWT.FILL, SWT.FILL, true, true) withChildren {
            label text "First"; 
            edit text "Bullet" gridData (SWT.FILL, SWT.CENTER, true, true) name "first"
            label text "Last"; 
            edit text "Tooth" gridData (SWT.FILL, SWT.CENTER, true, true) name "last"
        }  
        group text "Gender" fillLayout (SWT.HORIZONTAL, 5) gridData (SWT.FILL, SWT.FILL, true, true) withChildren {
            radio text "Male"
            radio text "Female"
        }
        group text "Role" fillLayout (SWT.HORIZONTAL, 5) gridData (SWT.FILL, SWT.FILL, true, true) withChildren {
            checkbox text "Student"
            checkbox text "Employee"
        }
        group text "Experience" fillLayout (SWT.HORIZONTAL, 5) gridData (SWT.FILL, SWT.FILL, true, true) withChildren {
            spinner
            label text "years"
        }

        button text "Save" gridData (SWT.RIGHT, SWT.CENTER, true, true) onSelect {
            (ctls get "first", ctls get "last") match {
                case (Some(f:Text), Some(l:Text)) =>
                    println("Name: " + f.getText + " " + l.getText)
                case _ => println("Something is wrong!")
            }
        }
        button text "Close" gridData (SWT.LEFT, SWT.CENTER, true, true) onSelect {
            shell close
        }
    } shell

    sh.pack
    sh.open
    

    while(!sh.isDisposed) {
      if (!display.readAndDispatch) {
        display.sleep
      }
    }
    display.dispose
  }
}
