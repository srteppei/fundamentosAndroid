package yisuscom.fundamentosandroidkc.Commons.Interactors.TableInteractor

import yisuscom.fundamentosandroidkc.Commons.Domains.Table

/**
 * Created by jesus on 02/12/2017.
 */
class TableInteractorFakeImpl: TableInteractor {

    val fakeTables = ArrayList<Table>()

    constructor() {
        fakeTables.add(Table(1))
        fakeTables.add(Table(2))
        fakeTables.add(Table(3))
        fakeTables.add(Table(4))
        fakeTables.add(Table(5))
    }

    override fun getTables(): ArrayList<Table> {
        return fakeTables
    }

    override fun getTable(position: Int): Table {
        return fakeTables.get(position)
    }

}