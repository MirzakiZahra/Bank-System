public enum Account_Type {
    CHECKING_ACCOUNT("check"),LOAN_ACCOUNT("loan"), SAVING_ACCOUNT("save");
    private String abbr;

    public String getAbbr() {
        return abbr;
    }

    Account_Type(String abbr) {
        this.abbr = abbr;
    }
}