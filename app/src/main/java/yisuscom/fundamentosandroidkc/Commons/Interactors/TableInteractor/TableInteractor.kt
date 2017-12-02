package yisuscom.fundamentosandroidkc.Commons.Interactors.TableInteractor

import yisuscom.fundamentosandroidkc.Commons.Domains.Table

/**
 * Created by jesus on 02/12/2017.
 */

interface TableInteractor {

    abstract fun getTables (): ArrayList<Table>

}