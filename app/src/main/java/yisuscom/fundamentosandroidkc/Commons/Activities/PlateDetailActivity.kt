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

    val photos: Map<String, Int> = mapOf(
            "pizza" to R.drawable.pizza,
            "emperador" to R.drawable.emperador,
            "espaguetis" to R.drawable.espaguetis,
            "hamburguesa_completa" to R.drawable.hamburguesa_completa,
            "fallafel" to R.drawable.fallafel
    )

    companion object {
        val EXTRA_PLATE = "EXTRA_PLATE"

        fun intent(context: Context, plate: Plate) : Intent {
            val intent = Intent(context, PlateDetailActivity::class.java)
            intent.putExtra(EXTRA_PLATE, plate)
            return intent
        }
    }

    lateinit var plate: Plate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plate_detail)

        plate = intent.getSerializableExtra(EXTRA_PLATE) as Plate

        productName.text = plate.name
        productDescription.text = plate.description
        productImage.setImageResource(photos[plate.photo] ?: R.drawable.plate)

        btnCancelDetail.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        btnAdd.setOnClickListener {
            val returnIntent = Intent()
            plate.annotations = editText.text.toString()
            returnIntent.putExtra(EXTRA_PLATE,plate)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }



}
