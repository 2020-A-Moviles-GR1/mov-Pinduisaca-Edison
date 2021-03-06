package com.example.moviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_ciclo_vida
            .setOnClickListener { boton ->
                // this.irCicloDeVida()
                irCicloDeVida()
            }

        btn_list_view
            .setOnClickListener { boton ->
                irListView()
            }

        btn_intent_respuesta
            .setOnClickListener {
                irAIntentConRespuesta()
            }

        btn_intent_implicito
            .setOnClickListener {
                enviarIntentConRespuesta()
            }

        btn_resp_propia
            .setOnClickListener {
                enviarIntentConRespuestaPropia()
            }

    }

    fun enviarIntentConRespuestaPropia(){
        val intentExplicito = Intent(
            this,
            IntentEnviarParametros::class.java
        )
        startActivityForResult(intentExplicito,305)
    }

    fun enviarIntentConRespuesta(){
        val intentConRespuesta = Intent(
            Intent.ACTION_PICK,
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        )

        /*
        val uri = data?.data
if (uri != null) {
    val cursor = contentResolver.query(
        uri,
        null,
        null,
        null,
        null,
        null
    )
    cursor?.moveToFirst()
    val indiceTelefono = cursor?.getColumnIndex(
        ContactsContract.CommonDataKinds.Phone.NUMBER
    )
    val telefono = cursor?.getString(indiceTelefono!!)
    cursor?.close()
    Log.i("resultado", "Telefono: ${telefono}")
}
         */
        // this.startActivityForResult(intent, codigoDeRespuesta)
        // 304 lo pusimos nosotros, no es ningun numero en especial
        startActivityForResult(intentConRespuesta, 304)
    }

    fun irAIntentConRespuesta() {
        val intentExplicito = Intent(
            this,
            IntentEnviarParametros::class.java
        )
        intentExplicito.putExtra("numero",2)
        startActivity(intentExplicito)
    }

    fun irListView() {
        val intentExplicito = Intent(
            this,
            BListViewActivity::class.java
        )
        // this.startActivity(intentExplicito)
        startActivity(intentExplicito)
    }

    fun irCicloDeVida() {
        val intentExplicito = Intent(
            this,
            CicloVida::class.java
        )
        // this.startActivity(intentExplicito)
        startActivity(intentExplicito)
    }


}