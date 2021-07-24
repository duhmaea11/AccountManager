package br.com.revobank.entity.account;

public enum JobTitle {
    DIRECTOR,
    COUNTER,
    PROGRAMMER;

    public static JobTitle asJobTitle(String str) {
        for (JobTitle me : JobTitle.values()) {
            if (me.name().equalsIgnoreCase(str))
                return me;
        }
        return null;
    }
}
