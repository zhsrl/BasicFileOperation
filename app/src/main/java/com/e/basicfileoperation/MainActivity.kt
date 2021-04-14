package com.e.basicfileoperation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var addButton: FloatingActionButton

    var contactList: List<Contact> = ArrayList()

    private lateinit var contactAdapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Contact List"

        recyclerView = findViewById(R.id.recView)
        contactAdapter = ContactAdapter(contactList)
        recyclerView.adapter = contactAdapter
        contactAdapter.notifyDataSetChanged()

        addButton = findViewById(R.id.FAB_add)

        addButton.setOnClickListener {
            val intent = Intent(applicationContext, AddContactActivity::class.java)
            startActivity(intent)
        }


    }
}