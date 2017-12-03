package yisuscom.fundamentosandroidkc.Commons.Interactors.Di

import yisuscom.fundamentosandroidkc.Commons.Interactors.PlateInteractor.PlateInteractor
import yisuscom.fundamentosandroidkc.Commons.Interactors.PlateInteractor.PlateInteractorImpl
import yisuscom.fundamentosandroidkc.Commons.Interactors.TableInteractor.TableInteractor
import yisuscom.fundamentosandroidkc.Commons.Interactors.TableInteractor.TableInteractorFakeImpl
import yisuscom.fundamentosandroidkc.Commons.Interactors.TableInteractor.TableInteractorImpl

/**
 * Created by jesus on 02/12/2017.
 */
class InteractorAssembly {

    private val fakeTableInteractor = TableInteractorFakeImpl()
    private val plateInteractor = PlateInteractorImpl()

    fun getTableInteractorFake (): TableInteractor {
        return fakeTableInteractor
    }

    fun getTableInteractor (): TableInteractor {
        return  TableInteractorImpl()
    }

    fun getPlateInteraactor (): PlateInteractor {
        return plateInteractor
    }

}