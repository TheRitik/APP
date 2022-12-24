package com.example.firstapi
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Request.Method.GET
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.w3c.dom.Text
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getdata()
    }
    private fun getdata(){
        val textView = findViewById<TextView>(R.id.textView)
        val show = findViewById<Button>(R.id.button)
        show.setOnClickListener(View.OnClickListener {
            fetchData();
        })
        val url = "http://api.weatherapi.com/v1/current.json?key=7c1d86e4cf4048a5bee195924221111&q=London&aqi=no"
////        val jsonObjectRequest = JsonObjectRequest(
////            Request.Method.GET, url, null,
////            Response.Listener { response ->
////                //textView.text = response.getString("temp_c")
////                val temp = response.getString("current")
////                textView.text = temp.substring(76,78)
////            },
////            Response.ErrorListener { error ->
////                // TODO: Handle error
////            }
////        )
//        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }
    private fun fetchData() {

        val textView = findViewById<TextView>(R.id.textView)
        val city = findViewById<EditText>(R.id.Name)
        var pres = findViewById<TextView>(R.id.textView5)
        val loc = city.text.toString()
        val url = "http://api.weatherapi.com/v1/current.json?key=7c1d86e4cf4048a5bee195924221111&q="+loc+"&aqi=no"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                //textView.text = response.getString("temp_c")
                val temp = response.getString("current")
                textView.text = temp.substring(76,78)
                pres.text = temp.substring(303,305)
//                pres.text = response.get("pressure_in").toString()
//                val press = response.getString("pressure_in")
            },

                    Response.ErrorListener { error ->
                // TODO: Handle error
            }
        )
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }
}

