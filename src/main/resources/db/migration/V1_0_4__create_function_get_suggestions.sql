CREATE OR REPLACE FUNCTION get_suggestions(
	search_query TEXT,
	start_lat DOUBLE PRECISION,
	start_long DOUBLE PRECISION,
	page_number INTEGER,
	per_page INTEGER
)
RETURNS TABLE (
    secure_id VARCHAR(36),
    name TEXT,
    lat DOUBLE PRECISION,
    long DOUBLE PRECISION,
    score DOUBLE PRECISION
) AS
$$
DECLARE
	keywords TEXT[];
BEGIN
	RETURN QUERY
    SELECT
    	mvs.secure_id,
    	mvs."name",
    	mvs.lat,
    	mvs.long,
    	(
    		SELECT *
    		FROM calculate_score(
    			search_query,
    			(SELECT * FROM string_to_array(mvs.query, ',')),
    			start_lat,
    			start_long,
    			mvs.lat,
    			mvs.long
    		)
    	) AS score
    FROM materialized_view_suggestions mvs
   	ORDER BY score DESC
   	LIMIT per_page
   	OFFSET per_page * (page_number - 1);
END;
$$ LANGUAGE plpgsql;