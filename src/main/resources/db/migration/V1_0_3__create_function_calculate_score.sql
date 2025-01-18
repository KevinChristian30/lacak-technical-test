CREATE EXTENSION IF NOT EXISTS pg_trgm;

CREATE OR REPLACE FUNCTION calculate_score(
	query TEXT,
	keywords TEXT[],
	start_lat DOUBLE PRECISION,
	start_long DOUBLE PRECISION,
	end_lat DOUBLE PRECISION,
	end_long DOUBLE PRECISION
)
RETURNS DOUBLE PRECISION AS
$$
DECLARE
	keyword text;
	max_similarity DOUBLE PRECISION;
	text_similarity DOUBLE PRECISION;

	distance DOUBLE PRECISION;
	distance_score DOUBLE PRECISION;

	text_similarity_weight DOUBLE PRECISION;
	distance_weight DOUBLE PRECISION;
	max_haversine_value DOUBLE PRECISION;
BEGIN
	-- 1. Declare constants
	text_similarity_weight := 0.75;
	distance_weight := 0.25;
	max_haversine_value := 20000;

	-- 2. Get the maximum similarity between two texts, ranging from 0 to 1
	max_similarity := 0;
	FOREACH keyword IN ARRAY keywords
    LOOP
        text_similarity := similarity(query, keyword);

        IF text_similarity > max_similarity THEN
            max_similarity := text_similarity;
        END IF;
    END LOOP;

   	-- 3. If any of the lat and long is null, immediately return the text similarity
	IF start_lat IS NULL OR
		start_long IS NULL OR
		end_lat IS NULL OR
		end_long IS NULL THEN
		RETURN max_similarity;
	END IF;


	-- 4. Get the distance between two geo points
	distance := (SELECT calculate_distance(start_lat, start_long, end_lat, end_long));

	-- 5. Normalize the distance to be between 0 and 1
	distance_score = 1 - (distance / max_haversine_value);

	-- 6. Apply the weight and return the score
    RETURN max_similarity * text_similarity_weight + distance_score * distance_weight;
END;
$$ LANGUAGE plpgsql IMMUTABLE;