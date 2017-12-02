package yisuscom.fundamentosandroidkc.Commons.Interactors.PlateInteractor

import yisuscom.fundamentosandroidkc.Commons.Domains.Plate

/**
 * Created by jesus on 02/12/2017.
 */
class PlateInteractorFakeImpl: PlateInteractor {

    override fun getPlates(): ArrayList<Plate> {
        val plates = ArrayList<Plate>()
        plates.add(Plate(1,"Pizza 4 quesos","Brie\nMozarrella\nCabra\nGranapadano",13.5f,arrayOf("a", "b", "c")))
        plates.add(Plate(2,"Espaguetis","Brie\nMozarrella\nCabra\nGranapadano",13.5f,arrayOf("a", "b", "c")))
        plates.add(Plate(3,"Hamburguesa","Brie\nMozarrella\nCabra\nGranapadano",13.5f,arrayOf("a", "b", "c")))
        plates.add(Plate(4,"Albondigas","Brie\nMozarrella\nCabra\nGranapadano",13.5f,arrayOf("a", "b", "c")))
        plates.add(Plate(5,"Helado","Brie\nMozarrella\nCabra\nGranapadano",13.5f,arrayOf("a", "b", "c")))
        plates.add(Plate(6,"Patatas","Brie\nMozarrella\nCabra\nGranapadano",13.5f,arrayOf("a", "b", "c")))
        return plates
    }
}