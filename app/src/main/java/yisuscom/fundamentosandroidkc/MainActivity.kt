package yisuscom.fundamentosandroidkc

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import yisuscom.fundamentosandroidkc.Commons.Activities.TableActivity
import yisuscom.fundamentosandroidkc.Commons.Domains.Table
import yisuscom.fundamentosandroidkc.Di.CoreAssembly
import yisuscom.fundamentosandroidkc.Table.Fragments.TableListFragment

class MainActivity : AppCompatActivity(), TableListFragment.OnTableSelectedListener {

    val coreAssembly = CoreAssembly()
    val tableInteractor = coreAssembly.interactorAssembly.getTableInteractorFake()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (table_list_fragment != null) {
            if (fragmentManager.findFragmentById(R.id.table_list_fragment) == null) {
                val fragment: Fragment = TableListFragment.newInstance(tableInteractor.getTables())
                fragmentManager.beginTransaction()
                        .add(R.id.table_list_fragment,fragment)
                        .commit()
            }
        }
    }

    override fun onTableSelected(table: Table) {
        val tableFragment =  fragmentManager.findFragmentById(R.id.table_fragment)
        if (tableFragment == null) {
            startActivity(TableActivity.intent(this,table))
        }
    }
}
