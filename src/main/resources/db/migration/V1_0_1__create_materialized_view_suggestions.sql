CREATE MATERIALIZED VIEW materialized_view_suggestions AS
SELECT
	g."secure_id",
	array_to_string(ARRAY[g.ascii, g.alt_name], ',') AS query,
	array_to_string(ARRAY[g.ascii, g.country], ', ') AS "name",
	g.lat,
	g.long
FROM geonames g;

CREATE INDEX query_index ON materialized_view_suggestions (query);

COMMENT ON MATERIALIZED VIEW materialized_view_suggestions is '17/01/2025 by Kevin Christian';