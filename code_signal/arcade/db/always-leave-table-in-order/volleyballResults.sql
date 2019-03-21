/*Please add ; after each select statement*/
CREATE PROCEDURE volleyballResults()
BEGIN
	SELECT * from results order by wins;
END