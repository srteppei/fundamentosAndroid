package yisuscom.fundamentosandroidkc.Di

import yisuscom.fundamentosandroidkc.Commons.Interactors.Di.InteractorAssembly


/**
 * Created by jesus on 30/11/2017.
 */
class CoreAssembly {

    companion object {

        private var coreAssembly: CoreAssembly? = null

        fun getInstance (): CoreAssembly {
            if (coreAssembly == null) coreAssembly = CoreAssembly()
            return coreAssembly!!
        }
    }

    val interactorAssembly = InteractorAssembly()




}