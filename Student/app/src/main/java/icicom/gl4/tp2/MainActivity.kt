package icicom.gl4.tp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val spinner : Spinner by lazy { findViewById(R.id.spinner) }
    val recyclerView : RecyclerView by lazy { findViewById(R.id.recyclerView) }
    val studentSearch: EditText by lazy { findViewById(R.id.textView2)}
    var matieres = listOf<String>("Cours","TP")
    var students = ArrayList<Student>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Haythem = Student("Haythem", "Kaouech", "m", arrayListOf(Presence("TP",true),Presence("Cours", true)))
        val Moetez = Student("Moetez", "Hellal", "m", arrayListOf(Presence("TP",true),Presence("Cours", false)))
        val Emna = Student("Emna", "Cheniour", "f",arrayListOf(Presence("TP",true),Presence("Cours", false)))
        val Hela = Student("Hela", "Selmi", "f",arrayListOf(Presence("TP",false),Presence("Cours", true)))
        val Aziz = Student("Aziz", "Hamouda", "m",arrayListOf(Presence("TP",false),Presence("Cours", true)))

        students.add(Haythem)
        students.add(Moetez)
        students.add(Emna)
        students.add(Hela)
        students.add(Aziz)

        studentSearch.addTextChangedListener {
            val studentAdapter = recyclerView.adapter as StudentListAdapter
            studentAdapter.filter.filter(studentSearch.text)
            studentSearch.doOnTextChanged{text,start,before,count -> studentAdapter.filter.filter(text)}

        }

        spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,matieres)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val toast = Toast.makeText(applicationContext,matieres[position] + " selected ", Toast.LENGTH_LONG)

                toast.show()

            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) {
            }

        }

        var studentAdapter = recyclerView.adapter as StudentListAdapter
        recyclerView.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
        }


    }


}