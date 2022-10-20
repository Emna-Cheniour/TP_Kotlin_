package com.gl4.pizzaapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var nom : TextView
    lateinit var prenom : TextView
    lateinit var adresse : TextView
    lateinit var type : RadioGroup
    lateinit var typeBtn : RadioButton
    lateinit var Fromage : CheckBox
    lateinit var Champignon : CheckBox
    lateinit var Oignons : CheckBox
    lateinit var Olives : CheckBox
    lateinit var Button : Button

    lateinit var ingredients : String
    lateinit var nomTxt: String
    lateinit var prenomTxt: String
    lateinit var adresseTxt: String
    lateinit var typeTxt: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_fragment)
        nom = findViewById(R.id.nom_edit_text)
        prenom = findViewById(R.id.prenom_edit_text)
        adresse = findViewById(R.id.adresse_edit_text)
        type = findViewById(R.id.radioGroup)
        Fromage = findViewById(R.id.checkBox)
        Champignon = findViewById(R.id.checkBox2)
        Oignons = findViewById(R.id.checkBox3)
        Olives = findViewById(R.id.checkBox4)
        Button = findViewById(R.id.next_button)
        ingredients = ""
    }

    fun deliver(v: View){

        nomTxt = nom.text.toString()
        prenomTxt = prenom.text.toString()
        adresseTxt = adresse.text.toString()
        val typeSize = type!!.checkedRadioButtonId

        typeBtn= findViewById(typeSize)


        if(Fromage.isChecked){
            ingredients+= "Fromage "
        }
        if(Olives.isChecked){
            ingredients+= "Olives "
        }
        if(Oignons.isChecked){
            ingredients+= "Oignons "
        }
        if(Champignon.isChecked){
            ingredients+= "Champignon "
        }
        val message= "Nom : $nomTxt \n" +
                "Prenom : $prenomTxt \n" +
                "Adresse : $adresseTxt \n" +
                "Type: ${typeBtn.text} \n" +
                "Ingredients : $ingredients \n"

        sendEmail("Delivery@gmail.com" , "We Do Pizza Right, \n Une Nouvelle Commande à traiter" , message)
    }

    fun refresh(){
        finish();
        startActivity(getIntent());
    }
     private fun sendEmail(recipient: String, subject: String, message: String) {
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        mIntent.putExtra(Intent.EXTRA_TEXT, message)


        try {
            startActivity(Intent.createChooser(mIntent, "Choisir l'Email.."))
        }
        catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }

    }
}
