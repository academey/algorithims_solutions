/*Please add ; after each select statement*/
CREATE PROCEDURE mostExpensive()
BEGIN
	select name from Products ORDER BY price*quantity desc, name LIMIT 1;
END