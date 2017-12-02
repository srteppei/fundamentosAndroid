package yisuscom.fundamentosandroidkc.Table.Fragments

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import yisuscom.fundamentosandroidkc.Commons.Domains.Table
import yisuscom.fundamentosandroidkc.R
import yisuscom.fundamentosandroidkc.Table.Adapters.TableRecyclerViewAdapter


class TableListFragment: Fragment() {

    companion object {

        val ARG_TABLES = "ARG_TABLE"

        fun newInstance(tables: ArrayList<Table>): Fragment {
            val arguments = Bundle()
            arguments.putSerializable(ARG_TABLES, tables)
            val fragment = TableListFragment()
            fragment.arguments = arguments

            return fragment
        }
    }

    lateinit var root: View
    private var onTableSelectedListener: OnTableSelectedListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        if (inflater != null) {
            root = inflater.inflate(R.layout.fragment_table_list, container, false)

            val tableRecycler = root.findViewById<RecyclerView>(R.id.tableRecycler)
            tableRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            tableRecycler.itemAnimator = DefaultItemAnimator()
            val adapter = TableRecyclerViewAdapter(arguments.getSerializable(ARG_TABLES) as ArrayList<Table>)

            adapter.tableViewHolderClick = (object : TableRecyclerViewAdapter.TableViewHolderClick {

                override fun clicked(table: Table) {
                    onTableSelectedListener?.onTableSelected(table)
                }

            })

            tableRecycler.adapter = adapter

        }

        return root
    }

    override fun onDetach() {
        super.onDetach()
        onTableSelectedListener = null
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        commonAttach(context)
    }

    @Suppress("OverridingDeprecatedMember", "DEPRECATION")
    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        commonAttach(activity)
    }

    fun commonAttach(listener: Any?) {
        if (listener is OnTableSelectedListener) {
            onTableSelectedListener = listener
        }
    }

    interface OnTableSelectedListener {
        fun onTableSelected(table: Table)
    }

}
