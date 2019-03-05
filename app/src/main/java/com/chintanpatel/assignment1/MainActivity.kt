package com.chintanpatel.assignment1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var vList = ArrayList<GeneralMotors>()
    val myStrings = arrayOf("Year", "Price", "Name")
    var vehicleAdapter: Adapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        val adapterCourses = ArrayAdapter(this, android.R.layout.simple_spinner_item,
            myStrings)
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spSort.adapter = adapterCourses

        spSort.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val sortedList:List<GeneralMotors>

                when(p2)
                {
                    0 -> sortedList = vList.sortedWith(compareBy({ it.releaseYear }))
                    1 -> sortedList = vList.sortedWith(compareBy({ it.price }))
                    2 -> sortedList = vList.sortedWith(compareBy({ it.modelName }))
                    else -> sortedList = vList.sortedWith(compareBy({ it.releaseYear }))
                }

                vList.clear()
                vList.addAll(sortedList)
                vehicleAdapter!!.notifyDataSetChanged()
            }
        }
    }

    // load all data

    fun initData()
    {
        vList.add(GeneralMotors("Camero", 2018, 750, false, 78000.00))
        vList.add(GeneralMotors("Silvarado", 2016, 450, false, 48000.00))
        vList.add(GeneralMotors("Malibu", 2017, 197, true, 43740.00))
        vList.add(GeneralMotors("Sierra", 2017, 285, true, 68200.00))
        vList.add(GeneralMotors("Escalade", 2018, 420, true, 86440.00))

        vList.add(GeneralMotors("Colorado", 2014, 200, false, 22460.00))
        vList.add(GeneralMotors("Equinox", 2016, 170, true, 25195.00))
        vList.add(GeneralMotors("Traverse", 2017, 310, true, 34395.00))
        vList.add(GeneralMotors("Cruze", 2018, 153, true, 16295.00))

        vehicleAdapter = Adapter(this, vList)
        list.setAdapter(vehicleAdapter)
        list.setLayoutManager(LinearLayoutManager(this))
    }
}
