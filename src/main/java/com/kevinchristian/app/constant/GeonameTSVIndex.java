package com.kevinchristian.app.constant;

public class GeonameTSVIndex {
    private GeonameTSVIndex() {
        throw new IllegalStateException(ErrorMessage.DO_NOT_INSTANTIATE);
    }

    public static final int ID_INDEX = 0;
    public static final int NAME_INDEX = 1;
    public static final int ASCII_INDEX = 2;
    public static final int ALT_NAME_INDEX = 3;
    public static final int LAT_INDEX = 4;
    public static final int LONG_INDEX = 5;
    public static final int FEAT_CLASS_INDEX = 6;
    public static final int FEAT_CODE_INDEX = 7;
    public static final int COUNTRY_INDEX = 8;
    public static final int CC2_INDEX = 9;
    public static final int ADMIN1_INDEX = 10;
    public static final int ADMIN2_INDEX = 11;
    public static final int ADMIN3_INDEX = 12;
    public static final int ADMIN4_INDEX = 13;
    public static final int POPULATION_INDEX = 14;
    public static final int ELEVATION_INDEX = 15;
    public static final int DEM_INDEX = 16;
    public static final int TZ_INDEX = 17;
    public static final int MODIFIED_AT_INDEX = 18;
}
