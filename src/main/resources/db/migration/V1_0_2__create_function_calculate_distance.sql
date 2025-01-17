CREATE OR REPLACE FUNCTION calculate_distance(
    start_lat DOUBLE PRECISION,
    start_long DOUBLE PRECISION,
    end_lat DOUBLE PRECISION,
    end_long DOUBLE PRECISION
)
RETURNS DOUBLE PRECISION AS
$$
DECLARE
    d_lat DOUBLE PRECISION;
    d_long DOUBLE PRECISION;
    a DOUBLE PRECISION;
    c DOUBLE PRECISION;
    earth_radius DOUBLE PRECISION := 6371;
BEGIN
    d_lat := RADIANS(end_lat - start_lat);
    d_long := RADIANS(end_long - start_long);

    start_lat := RADIANS(start_lat);
    end_lat := RADIANS(end_lat);

    a := POWER(SIN(d_lat / 2), 2) + COS(start_lat) * COS(end_lat) * POWER(SIN(d_long / 2), 2);
    c := 2 * ATAN2(SQRT(a), SQRT(1 - a));

    RETURN earth_radius * c;
END;
$$ LANGUAGE plpgsql IMMUTABLE;