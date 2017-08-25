type schema\create_database_locations.sql >> full_script.sql
echo. >> full_script.sql
type use\use_database.sql >> full_script.sql
echo. >> full_script.sql
type tables\create_table_place_type.sql >> full_script.sql
echo. >> full_script.sql
type tables\create_table_place.sql >> full_script.sql
echo. >> full_script.sql
type tables\create_table_user.sql >> full_script.sql
echo. >> full_script.sql
type procedures\sp_get_places_by_distance.sql >> full_script.sql
echo. >> full_script.sql
type data\insert_place_type_data.sql >> full_script.sql
echo. >> full_script.sql
type data\insert_test_data.sql >> full_script.sql
echo. >> full_script.sql