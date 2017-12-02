package yisuscom.fundamentosandroidkc.Commons.Interactors.Di

import yisuscom.fundamentosandroidkc.Commons.Interactors.TableInteractor.TableInteractor
import yisuscom.fundamentosandroidkc.Commons.Interactors.TableInteractor.TableInteractorFakeImpl
import yisuscom.fundamentosandroidkc.Commons.Interactors.TableInteractor.TableInteractorImpl

/**
 * Created by jesus on 02/12/2017.
 */
class InteractorAssembly {

    fun getTableInteractorFake (): TableInteractor {
        return TableInteractorFakeImpl()
    }

    fun getTableInteractor (): TableInteractor {
        return  TableInteractorImpl()
    }

}