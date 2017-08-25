DELIMITER //
CREATE PROCEDURE sp_get_places_by_distance
(IN location POINT,
 IN distance BIGINT)
BEGIN
	SELECT * FROM place p WHERE st_distance_sphere(p.coordinate, location) <= distance;
END; //
DELIMITER ;