package yisuscom.fundamentosandroidkc

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import yisuscom.fundamentosandroidkc.Commons.Activities.TableActivity
import yisuscom.fundamentosandroidkc.Commons.Domains.Plate
import yisuscom.fundamentosandroidkc.Commons.Domains.Table
import yisuscom.fundamentosandroidkc.Di.CoreAssembly
import yisuscom.fundamentosandroidkc.Table.Fragments.TableListFragment

class MainActivity : AppCompatActivity(), TableListFragment.OnTableSelectedListener {

    val coreAssembly = CoreAssembly.getInstance()
    val tableInteractor = coreAssembly.interactorAssembly.getTableInteractorFake()
    var tables: ArrayList<Table>? = null
    var downloadPlates = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!downloadPlates) {
            async (UI) {
                val plates: Deferred<ArrayList<Plate>> = bg {
                    coreAssembly.interactorAssembly.getPlateInteraactor().getPlates()
                }
                plates.await()
                downloadPlates = true
            }
        }

        if (tables == null)
            tables = tableInteractor.getTables()

        if (table_list_fragment != null) {
            if (fragmentManager.findFragmentById(R.id.table_list_fragment) == null) {
                val fragment: Fragment = TableListFragment.newInstance(tables!!)
                fragmentManager.beginTransaction()
                        .add(R.id.table_list_fragment,fragment)
                        .commit()
            }
        }
    }

    override fun onTableSelected(position: Int) {
        val tableFragment =  fragmentManager.findFragmentById(R.id.table_fragment)
        if (tableFragment == null) {
            startActivity(TableActivity.intent(this,position))
        }
    }
}
