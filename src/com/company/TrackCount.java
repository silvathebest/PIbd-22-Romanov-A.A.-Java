package com.company;

public enum TrackCount {

    four,
    five,
    six;

    public static TrackCount getCount(int count) {
        return switch (count) {
            case 0 -> four;
            case 1 -> five;
            case 2 -> six;
            default -> null;
        };
    }
}
