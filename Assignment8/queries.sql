SELECT Player_ID, PlayerAge, PlayerName, Gender FROM Players;

SELECT Child, ParentName, Phone_Number_ FROM Parent_;

SELECT * FROM Players WHERE PlayerAge = 10;

SELECT COUNT(*) AS AfternoonPracticeCount
FROM Practice_Time
WHERE Time_of_day = 'Afternoon';

SELECT Child, ParentName
FROM Parent_;

SELECT DISTINCT Players.Player_ID, Players.PlayerName, Teams.TeamName
FROM Players
JOIN Team_Roster ON Players.Player_ID = Team_Roster.Player_ID
JOIN Teams ON Team_Roster.Team_ID = Teams.Team_ID;

SELECT DISTINCT TeamName
FROM Teams;

SELECT Teams.TeamName, AVG(Players.PlayerAge) AS AvgAge
FROM Players
JOIN Team_Roster ON Players.Player_ID = Team_Roster.Player_ID
JOIN Teams ON Team_Roster.Team_ID = Teams.Team_ID
GROUP BY Teams.TeamName
HAVING AVG(Players.PlayerAge) = 7;

SELECT PlayerName, PlayerAge
FROM Players
ORDER BY PlayerAge DESC;

SELECT PlayerName, PlayerAge
FROM Players
WHERE PlayerName LIKE '%John%';

SELECT Teams.TeamName, Coach.CoachName
FROM Teams
JOIN Coach ON Teams.Team_ID = Coach.Team_ID;

SELECT Teams.TeamName, Players.PlayerName
FROM Teams
JOIN Team_Roster ON Teams.Team_ID = Team_Roster.Team_ID
JOIN Players ON Team_Roster.Player_ID = Players.Player_ID;


DELIMITER //
CREATE TRIGGER trg_InsertParent
AFTER INSERT ON Players
FOR EACH ROW
BEGIN
    IF NEW.PlayerName IS NOT NULL THEN
        INSERT INTO Parent_ (ParentName, Phone_Number_)
        VALUES (NEW.PlayerName, NEW.PlayerName); 
    END IF;
END;
//
DELIMITER ;


DELIMITER //
CREATE PROCEDURE UpdateCoachQualification(
    IN p_CoachName VARCHAR(255),
    IN p_NewQualification VARCHAR(255)
)
BEGIN
    DECLARE coach_ID INT;
    
    SELECT Coach_ID INTO coach_ID FROM Coach WHERE CoachName = p_CoachName;
    
    IF coach_ID IS NOT NULL THEN
        UPDATE Coach SET Qualifications_ = p_NewQualification WHERE Coach_ID = coach_ID;
    END IF;
END;
//
DELIMITER ;

