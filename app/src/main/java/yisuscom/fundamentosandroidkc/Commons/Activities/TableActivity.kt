package yisuscom.fundamentosandroidkc.Commons.Activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_table.*
import yisuscom.fundamentosandroidkc.Commons.Domains.Plate
import yisuscom.fundamentosandroidkc.Commons.Domains.Table
import yisuscom.fundamentosandroidkc.R
import yisuscom.fundamentosandroidkc.Table.Fragments.TableViewFragment

class TableActivity : AppCompatActivity() {

    companion object {
        val EXTRA_TABLE = "EXTRA_TABLE"

        fun intent(context: Context, table: Table) : Intent {
            val intent = Intent(context, TableActivity::class.java)
            intent.putExtra(EXTRA_TABLE, table)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

        if (fragmentManager.findFragmentById(R.id.tableView) == null) {
            val fragment = TableViewFragment.newInstance(intent.getSerializableExtra(EXTRA_TABLE) as Table)
            fragmentManager.beginTransaction()
                    .add(R.id.tableView,fragment)
                    .commit()
        }

        btnAddPlate.setOnClickListener { view ->
            startActivityForResult(PlateRecyclerViewActivity.intent(this),1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val plate = data?.getSerializableExtra(PlateDetailActivity.EXTRA_PLATE) as Plate
                println(plate.annotations)
            }
        }

    }
}
