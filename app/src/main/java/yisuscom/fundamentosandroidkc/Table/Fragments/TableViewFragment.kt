package yisuscom.fundamentosandroidkc.Table.Fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import yisuscom.fundamentosandroidkc.Commons.Domains.Table

import yisuscom.fundamentosandroidkc.R

/**
 * A simple [Fragment] subclass.
 */
class TableViewFragment : Fragment() {

    companion object {
        val ARG_TABLE = "ARG_TABLE"

        fun newInstance(table: Table): TableViewFragment {
            val arguments = Bundle()
            arguments.putSerializable(ARG_TABLE, table)
            val fragment = TableViewFragment()
            fragment.arguments = arguments

            return fragment
        }
    }

    lateinit var root: View

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        if (inflater != null) {
            root = inflater.inflate(R.layout.fragment_table_view,container,false)
            val table = arguments?.getSerializable(ARG_TABLE) as Table
            val tableIdText = root.findViewById<TextView>(R.id.tableId)
            val tableDescription = root.findViewById<TextView>(R.id.tableDescription)
            tableIdText.text = root.context.getString(R.string.fragment_table_view_id,table.id.toString())
            tableDescription.text = table.description
        }

        return root
    }

}
