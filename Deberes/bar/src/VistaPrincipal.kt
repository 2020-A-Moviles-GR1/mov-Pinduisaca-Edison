import Vista.menuBar
import javax.swing.JFrame

fun main (args: Array<String>){
    val frame = JFrame("Menu de Cocteles")
    frame.contentPane = menuBar().pnlMenu
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.pack()
    frame.isVisible = true
}