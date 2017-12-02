package yisuscom.fundamentosandroidkc.Plate.Fragments

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
import yisuscom.fundamentosandroidkc.Commons.Domains.Plate
import yisuscom.fundamentosandroidkc.Plate.Adapters.PlateRecyclerViewAdapter
import yisuscom.fundamentosandroidkc.R


/**
 * A simple [Fragment] subclass.
 */
class PlateRecyclerViewFragment : Fragment() {

    companion object {

        val ARG_PLATES = "ARG_PLATES"

        fun newInstance(plates: ArrayList<Plate>): android.app.Fragment {
            val arguments = Bundle()
            arguments.putSerializable(ARG_PLATES, plates)
            val fragment = PlateRecyclerViewFragment()
            fragment.arguments = arguments

            return fragment
        }
    }

    lateinit var root: View
    private var plateRecyclerViewFragmentListener: PlateRecyclerViewFragmentListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        if (inflater != null) {
            root = inflater.inflate(R.layout.fragment_plate_recyclerview, container, false)
            val tableRecycler = root.findViewById<RecyclerView>(R.id.recyclerViewPlates)
            tableRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            tableRecycler.itemAnimator = DefaultItemAnimator()
            val adapter = PlateRecyclerViewAdapter(arguments.getSerializable(ARG_PLATES) as ArrayList<Plate>)

            adapter.plateRecyclerViewHolderClick = (object : PlateRecyclerViewAdapter.PlateRecyclerViewHolderClick {

                override fun clicked(plate: Plate) {
                    plateRecyclerViewFragmentListener?.onPlateSelected(plate)
                }

            })
            tableRecycler.adapter = adapter
        }

        return root
    }

    override fun onDetach() {
        super.onDetach()
        plateRecyclerViewFragmentListener = null
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
        if (listener is PlateRecyclerViewFragmentListener) {
            plateRecyclerViewFragmentListener = listener
        }
    }

    interface PlateRecyclerViewFragmentListener {
        fun onPlateSelected(plate: Plate)
    }
}
