/*Please add ; after each select statement*/
CREATE PROCEDURE gradeDistribution()
BEGIN
select Name, ID from Grades where 
        Final > Midterm1 * 0.25 + Midterm2 * 0.25 + Final * 0.5 &&
        Final > Midterm1 * 0.5 + Midterm2 * 0.5
        order by left(name, 3), id;
END