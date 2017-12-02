package yisuscom.fundamentosandroidkc.Commons.Activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_plate_detail.*
import kotlinx.android.synthetic.main.activity_plate_recycler_view.*
import yisuscom.fundamentosandroidkc.Commons.Domains.Plate
import yisuscom.fundamentosandroidkc.R

class PlateDetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_PLATE = "EXTRA_PLATE"

        fun intent(context: Context, plate: Plate) : Intent {
            val intent = Intent(context, PlateDetailActivity::class.java)
            intent.putExtra(EXTRA_PLATE, plate)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plate_detail)

        btnCancelDetail.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        btnAdd.setOnClickListener {
            val returnIntent = Intent()
            val plate = intent.getSerializableExtra(EXTRA_PLATE) as Plate
            plate.annotations = "yabayabadu"
            returnIntent.putExtra(EXTRA_PLATE,plate)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }



}
