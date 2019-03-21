/*Please add ; after each select statement*/
CREATE PROCEDURE projectsTeam()
BEGIN
	SELECT distinct name from projectLog ORDER BY name;
ENDp