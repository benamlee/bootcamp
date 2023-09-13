public enum Rank {
    ONE(1), //
    TWO(2), //
    THREE(3), //
    FOUR(4), //
    FIVE(5), //
    SIX(6), //
    SEVEN(7), //
    EIGHT(8), //
    NINE(9), //
    TEN(10), //
    JACK(11), //
    QUEEN(12), //
    KING(13), //
    JOKER(14), //
    ;

    int number;

    private Rank(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public int compare(Rank rank) { // -1, 0, 1
        if (this.number > rank.getNumber())
            return 1;
        else if (this.number < rank.getNumber())
            return -1;
        return 0;
    }
}
