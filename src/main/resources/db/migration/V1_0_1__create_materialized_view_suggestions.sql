create materialized view materialized_view_suggestions as
select
	g."secure_id",
	array_to_string(ARRAY[g.ascii, g.alt_name], ',') as query,
	array_to_string(ARRAY[g.ascii, g.country], ', ') as "name",
	g.lat,
	g.long
from geonames g;

create index query_index ON materialized_view_suggestions (query);

comment on materialized view materialized_view_suggestions is '17/01/2025 by Kevin Christian';