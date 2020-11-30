package com.company;

public enum TrackCount {

    four,
    five,
    six;

    public static TrackCount getCount(int count) {
        return switch (count) {
            case 4 -> four;
            case 5 -> five;
            case 6 -> six;
            default -> null;
        };
    }
}
