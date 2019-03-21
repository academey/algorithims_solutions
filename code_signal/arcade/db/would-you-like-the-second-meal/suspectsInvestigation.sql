/*Please add ; after each select statement*/
CREATE PROCEDURE suspectsInvestigation()
BEGIN
	select id, name, surname from Suspect where LEFT(name,1) = 'B' && surname LIKE 'gre_n' && height <= 170 order by id;
END