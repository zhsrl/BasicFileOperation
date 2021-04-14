package com.e.basicfileoperation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.lang.Exception

class AddContactActivity : AppCompatActivity() {

    private lateinit var contactName: EditText
    private lateinit var addContact: MaterialButton

    var fileName: String? = null
    var filePath: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        contactName = findViewById(R.id.ET_add_contact_name)
        addContact = findViewById(R.id.BTN_add_contact)

        fileName = "contactList.txt"
        filePath = "Contacts"

        if(!isExternalStorageAvailableForRW()){
            addContact.isEnabled = false
        }

        addContact.setOnClickListener {
            if(!contactName.equals("")){
                val gettedContactName: String = contactName.editableText.toString().trim()

                val myFile: File = File(getExternalFilesDir(filePath), fileName!!)
                var fos: FileOutputStream? = null

                try {
                    fos = FileOutputStream(myFile)
                    fos.write(gettedContactName.toByteArray())
                }catch (e: FileNotFoundException){
                    e.printStackTrace()
                }catch (e: IOException){
                    e.printStackTrace()
                }



                Toast.makeText(applicationContext, "Contact add successfully", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(applicationContext, "Contact name is empty!", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun isExternalStorageAvailableForRW(): Boolean{
        val extStorageState: String = Environment.getExternalStorageState()
        if(extStorageState == Environment.MEDIA_MOUNTED){
            return true
        }

        return false
    }
}