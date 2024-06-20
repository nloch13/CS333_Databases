SELECT PlayerName, Grade
FROM Gamer
WHERE Grade IN ('Senior', 'Junior');

SELECT PlayerName, KDA
FROM Gamer
ORDER BY KDA DESC;

SELECT MapName, MapBanPersent
FROM Map
ORDER BY MapBanPersent DESC;

SELECT AVG(KDA) AS AverageKDA FROM Gamer;

SELECT LeagueName, COUNT(TeamName) AS NumTeams, AVG(TeamRecord) AS AverageRecord
FROM EsportTeam
GROUP BY LeagueName;

SELECT Season, SUM(PrizePool) AS TotalPrizePool
FROM League
GROUP BY Season;

SELECT TeamName, AVG(TeamRecord) AS AverageRecord
FROM EsportTeam
GROUP BY TeamName
ORDER BY AverageRecord DESC;

SELECT Rank, COUNT(IGN) AS NumPlayers
FROM Gamer
GROUP BY Rank;

SELECT TeamName, Place
FROM EsportTeam
ORDER BY TeamName, Place;

SELECT LeagueName, PrizePool
FROM League
ORDER BY PrizePool DESC;

SELECT EsportTeam.TeamName, Record_RD.RoundDifferential
FROM EsportTeam
JOIN Record_RD ON EsportTeam.Place = Record_RD.Place
ORDER BY Record_RD.RoundDifferential DESC;

/*DELETE FROM Gamer
WHERE KDA >= 0.0 AND KDA <= 3.0; */

SELECT * FROM Gamer 