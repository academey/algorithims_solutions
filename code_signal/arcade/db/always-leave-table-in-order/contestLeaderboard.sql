/*Please add ; after each select statement*/
CREATE PROCEDURE contestLeaderboard()
BEGIN
	select name from leaderboard order by score desc LIMIT 5 OFFSET 3;
ENDd