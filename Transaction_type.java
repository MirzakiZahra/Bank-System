public enum Transaction_type {
    WITHDRAW("w"),DEPOSIT("d"),INTEREST("i"),FEES("f") ;
    private String abbr;

    public String getAbbr() {
        return abbr;
    }

    Transaction_type(String abbr) {
        this.abbr = abbr;
    }
}
