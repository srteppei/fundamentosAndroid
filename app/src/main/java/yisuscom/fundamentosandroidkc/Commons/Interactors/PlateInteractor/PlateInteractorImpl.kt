package yisuscom.fundamentosandroidkc.Commons.Interactors.PlateInteractor

import org.json.JSONObject
import yisuscom.fundamentosandroidkc.Commons.Domains.Plate
import java.net.URL
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by jesus on 03/12/2017.
 */
class PlateInteractorImpl: PlateInteractor {

    var savedPlates: ArrayList<Plate> = ArrayList()

    override fun getPlates(): ArrayList<Plate> {
        if (savedPlates.count() == 0) {
            downloadPlates()
        }

        return savedPlates
    }

    private fun downloadPlates () {
        val url = URL("http://www.mocky.io/v2/5a2451eb2e0000d70e83bf8a")
        val jsonString = Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next()
        val jsonRoot = JSONObject(jsonString.toString())

        val plateList = jsonRoot.getJSONArray("plates")

        for (plateObj in 0 until plateList.length()) {

            val auxPlate = plateList.getJSONObject(plateObj)

            val id = auxPlate.getInt("id")
            val name = auxPlate.getString("name")
            val description = auxPlate.getString("description")
            val price = auxPlate.getDouble("price")
            val auxAllergens = auxPlate.getJSONArray("allergens")
            val allergerns = Array(auxAllergens.length(),{ i -> auxAllergens.getString(i)})
            val photo = auxPlate.getString("photo")

            savedPlates.add(Plate(id,name,description,price,allergerns,photo))
        }

        println(jsonString)
    }

}