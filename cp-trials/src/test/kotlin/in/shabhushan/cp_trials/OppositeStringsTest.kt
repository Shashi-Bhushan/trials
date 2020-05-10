package `in`.shabhushan.cp_trials

import org.junit.Test
import kotlin.test.assertEquals

class OppositeStringsTest {
    private fun testing(actual: String, expected: String) {
        assertEquals(expected, actual)
    }
    @Test
    fun test() {
        println("Fixed Tests vertMirror")
        var s = "hSgdHQ\nHnDMao\nClNNxX\niRvxxH\nbqTVvA\nwvSyRu"
        var r = "QHdgSh\noaMDnH\nXxNNlC\nHxxvRi\nAvVTqb\nuRySvw"
        testing(OppositeStrings.oper(OppositeStrings::vertMirror, s), r)
        s = "IzOTWE\nkkbeCM\nWuzZxM\nvDddJw\njiJyHF\nPVHfSx"
        r = "EWTOzI\nMCebkk\nMxZzuW\nwJddDv\nFHyJij\nxSfHVP"
        testing(OppositeStrings.oper(OppositeStrings::vertMirror, s), r)

        println("Fixed Tests horMirror")
        s = "lVHt\nJVhv\nCSbg\nyeCt"
        r = "yeCt\nCSbg\nJVhv\nlVHt"
        testing(OppositeStrings.oper(OppositeStrings::horMirror, s), r)
        s = "njMK\ndbrZ\nLPKo\ncEYz"
        r = "cEYz\nLPKo\ndbrZ\nnjMK"
        testing(OppositeStrings.oper(OppositeStrings::horMirror, s), r)

    }

    @Test
    fun test2() {
        println("Fixed Tests rot")
        testing(OppositeStrings.oper(OppositeStrings::rot, "fijuoo\nCqYVct\nDrPmMJ\nerfpBA\nkWjFUG\nCVUfyL"),
            "LyfUVC\nGUFjWk\nABpfre\nJMmPrD\ntcVYqC\nooujif")
        testing(OppositeStrings.oper(OppositeStrings::rot, "rkKv\ncofM\nzXkh\nflCB"),
            "BClf\nhkXz\nMfoc\nvKkr")

        println("Fixed Tests selfieAndRot")
        testing(OppositeStrings.oper( OppositeStrings::selfieAndRot, "xZBV\njsbS\nJcpN\nfVnP"),
            "xZBV....\njsbS....\nJcpN....\nfVnP....\n....PnVf\n....NpcJ\n....Sbsj\n....VBZx")
        testing(OppositeStrings.oper( OppositeStrings::selfieAndRot, "uLcq\nJkuL\nYirX\nnwMB"),
            "uLcq....\nJkuL....\nYirX....\nnwMB....\n....BMwn\n....XriY\n....LukJ\n....qcLu")

    }
}
