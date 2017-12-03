package yisuscom.fundamentosandroidkc.Commons.Activities

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_table.*
import yisuscom.fundamentosandroidkc.Commons.Domains.Plate
import yisuscom.fundamentosandroidkc.Commons.Domains.Table
import yisuscom.fundamentosandroidkc.Di.CoreAssembly
import yisuscom.fundamentosandroidkc.Plate.Fragments.PlateRecyclerViewFragment
import yisuscom.fundamentosandroidkc.R
import yisuscom.fundamentosandroidkc.Table.Fragments.TableViewFragment

class TableActivity : AppCompatActivity() {

    companion object {
        val EXTRA_TABLE = "EXTRA_TABLE_POSITION"

        fun intent(context: Context, position: Int) : Intent {
            val intent = Intent(context, TableActivity::class.java)
            intent.putExtra(EXTRA_TABLE, position)
            return intent
        }
    }

    lateinit var table: Table
    lateinit var plateListFragment: PlateRecyclerViewFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

        table = CoreAssembly.getInstance().interactorAssembly.getTableInteractorFake().getTable(intent.getSerializableExtra(EXTRA_TABLE) as Int)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (fragmentManager.findFragmentById(R.id.tableView) == null) {
            val fragment = TableViewFragment.newInstance(table)
            fragmentManager.beginTransaction()
                    .add(R.id.tableView,fragment)
                    .commit()
        }

        if (fragmentManager.findFragmentById(R.id.plateList) == null) {
            plateListFragment = PlateRecyclerViewFragment.newInstance(table.getPlates())
            fragmentManager.beginTransaction()
                    .add(R.id.plateList,plateListFragment)
                    .commit()
        }


        btnBill.setOnClickListener {
            AlertDialog.Builder(this)
                    .setTitle(getString(R.string.bill))
                    .setMessage( getString(R.string.bill_pay) + table.getTotalPrice())
                    .setPositiveButton(getString(android.R.string.ok), { dialog, _ ->
                        dialog.dismiss()
                    })
                    .show()
        }

        btnAddPlate.setOnClickListener { view ->
            startActivityForResult(PlateRecyclerViewActivity.intent(this),1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val plate = data?.getSerializableExtra(PlateDetailActivity.EXTRA_PLATE) as Plate
                table.addPlate(plate)
                plateListFragment.update()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }
        return true
    }
}
