import javax.swing.JOptionPane

fun main (args:Array<String>) {
   JOptionPane.showMessageDialog(null, "Hello")
   val dbConnection: DBC = DBC()
   dbConnection.getConnection()
   dbConnection.executeMySQLQuery()


}