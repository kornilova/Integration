package com.estylesoft.integration.Model.Ptks;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 01.04.14
 * Time: 17:41
 * To change this template use File | Settings | File Templates.
 */
public class PtksEnumeration {

    public enum JournalChangeDataDictionaryType {
        INSURER_CATEGORY(1),
        INSURER_STATUS(2),
        KBK(3),
        PFR_STRUCTURE(4),
        OKATO(5),
        OKVED(6),
        OPF(7),
        ADDRESS(8),
        IFNS(9),
        REGISTRATION_ORGAN(10),
        INSURER(11),
        PAYMENT(12),
        REGION(13),
        ADM_TERRITORY(14),
        CITY(15),
        TOWN(16),
        STREET(17),
        INSURER_HISTORY(18),
        REREG_INFO(19),
        PREVIOUS(20),
        FEDERAL_OKRUG(21),
        INSURER_TYPE(22),
        REGISTRATION_START(23),
        REGISTRATION_FINISH(24),
        OPFR(26),
        BASE_DEPARTMENT(27),
        TER_DEPARTMENT_PFR(28),
        TER_ORGAN(29),
        REGISTRATION_TYPE(30);

        JournalChangeDataDictionaryType(int i) {
            this.i = i;
        }

        private final int i;

        public int getValue() {
            return i;
        }
    }

    public enum JournalChangeDataOperationType {
        INSERT(1),
        UPDATE(2),
        DELETE(3);

        JournalChangeDataOperationType(int i) {
            this.i = i;
        }

        private final int i;

        public int getValue() {
            return i;
        }
    }
}
