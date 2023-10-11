package com.example.benproject.infra;
// getter has been done
public enum Code {
    OK(20000, "OK"),
    // 40000 - 49999
    NOTFOUND(40000, "Resource NOT FOUND."), //
    JPH_NOTFOUND(40001, "JsonPlaceHolder RestClientException."), //
    FINNHUB_PROFILE2_NOTFOUND(40002,
            "Finnhub Company Profile2 RestClientException."), //
    FINNHUB_QUOTE_NOTFOUND(40003, "Finnhub Stock Quote RestClientException."), //
    FINNHUB_SYMBOL_NOTFOUND(40004, "Finnhub Stock Symbol RestClientException."), //
    
    // Trader
    TRADER_NOTENOUGH_MONEY(41001, "Trader has not enough money."),
    TRADER_NOTENOUGH_PRODUCT(41002, "Trader has not enough product."),

    // Server
    SERVER_TIMEOUT(50000, "Server Timeout."), //
    THIRD_PARTY_SERVER_UNAVAILABLE(50001, "Third Party Service Unavailable."), //
    REDIS_SERVER_UNAVAILABLE(50002, "Redis unavailable."),
    // RuntimeException: 90000 - 99999
    IAE_EXCEPTION(90000, "Illegal Argument Exception."), //
    ENTITY_NOT_FOUND(90001, "Entity Not Found."), //
    VALIDATOR_FAIL(90002, "Validator Fail.");

    private int code;
    private String desc;

    private Code(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    // no annotation, so write getter myself
    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public static Code fromCode(int code) { // input int code to find Code
        for (Code c : Code.values()) {
            if (c.code == code)
                return c;
        }
        throw new IllegalArgumentException();
    }
}
