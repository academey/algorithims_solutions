/*Please add ; after each select statement*/
CREATE PROCEDURE mischievousNephews()
BEGIN
        SELECT weekday(mischief_date) as weekday, mischief_date, author, title from mischief order by weekday, 
        (
                case author
                when 'Huey' then 1
                when 'Dewey' then 2
                when 'Louie' then 3
                else 4
                end
        ),
        mischief_date,
        title;
END