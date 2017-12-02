package yisuscom.fundamentosandroidkc.Commons.Interactors.TableInteractor

import yisuscom.fundamentosandroidkc.Commons.Domains.Table

/**
 * Created by jesus on 02/12/2017.
 */
class TableInteractorFakeImpl: TableInteractor {

    override fun getTables(): ArrayList<Table> {
        val tables = ArrayList<Table>()
        tables.add(Table(1))
        tables.add(Table(2))
        tables.add(Table(3))
        tables.add(Table(4))
        tables.add(Table(5))
        return tables
    }

}