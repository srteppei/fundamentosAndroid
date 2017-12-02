package yisuscom.fundamentosandroidkc.Commons.Activities


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_plate_recycler_view.*
import yisuscom.fundamentosandroidkc.Commons.Domains.Plate
import yisuscom.fundamentosandroidkc.Commons.Interactors.PlateInteractor.PlateInteractor
import yisuscom.fundamentosandroidkc.Commons.Interactors.PlateInteractor.PlateInteractorFakeImpl
import yisuscom.fundamentosandroidkc.Plate.Fragments.PlateRecyclerViewFragment
import yisuscom.fundamentosandroidkc.R

class PlateRecyclerViewActivity : AppCompatActivity(), PlateRecyclerViewFragment.PlateRecyclerViewFragmentListener {

    companion object {

        fun intent(context: Context) : Intent {
            val intent = Intent(context, PlateRecyclerViewActivity::class.java)
            return intent
        }
    }

    val plateInteractor: PlateInteractor = PlateInteractorFakeImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plate_recycler_view)

        if (fragmentManager.findFragmentById(R.id.recyclerViewFragment) == null) {
            val fragment = PlateRecyclerViewFragment.newInstance(plateInteractor.getPlates())
            fragmentManager.beginTransaction()
                    .add(R.id.recyclerViewFragment,fragment)
                    .commit()
        }

        btnCancel.setOnClickListener { finish() }
    }

    override fun onPlateSelected(plate: Plate) {
        startActivityForResult(PlateDetailActivity.intent(this,plate), 2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
                setResult(Activity.RESULT_OK,data)
                finish()
            }
        }

    }
}
