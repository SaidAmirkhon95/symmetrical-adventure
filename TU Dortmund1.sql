--SQL Skript
--1 Tabellen Anlegen
--1.1
--CREATE TABLE STUDENT (Name VARCHAR(255) PRIMARY KEY, 
--MatrNr INTEGER NOT NULL, Semester INTEGER NOT NULL, Studiengang VARCHAR(255))
--CREATE TABLE VERANSTALTUNG (Nummer INTEGER NOT NULL PRIMARY KEY,
--Name VARCHAR(255), Studiengang VARCHAR(255), Ort VARCHAR(255), 
--FOREIGN KEY(Name) REFERENCES STUDENT(Name), 
--FOREIGN KEY(Studiengang) REFERENCES STUDENT (Studiengang))
--CREATE TABLE ANMELDUNG (Kursnummer INTEGER NOT NULL PRIMARY KEY, 
--MatrNr INTEGER NOT NULL PRIMARY KEY, FOREIGN KEY(Kursnummer) REFERENCES Veranstaltung(Nummer),
--FOREIGN KEY (MatrNr) REFERENCES STUDENT (MatrNr))

--2.2
--1
--SELECT PRES_NAME
--FROM PRESIDENT
--WHERE BIRTH_YEAR=1946
--2
--SELECT PRES_NAME
--FROM PRESIDENT
--WHERE DEATH_AGE IS NULL
--3
--SELECT PRES_NAME, BIRTH_YEAR, YEARS_SERV, DEATH_AGE, PARTY, STATE_BORN
--FROM PRESIDENT 
--WHERE PRES_NAME='Obama B H'
--4
--SELECT PRES_NAME, BIRTH_YEAR, STATE_BORN
--FROM PRESIDENT
--ORDER BY STATE_BORN ASC, BIRTH_YEAR DESC
--5
--SELECT PRES_NAME, DEATH_AGE
--FROM PRESIDENT 
--WHERE DEATH_AGE>=50 AND DEATH_AGE<=60
--6
--SELECT p.PRES_NAME
--FROM PRESIDENT p, ADMIN_PR_VP v
--WHERE p.PRES_NAME=v.VICE_PRES_NAME
--ORDER BY p.PRES_NAME ASC
--7
--SELECT PRES_NAME, YEARS_SERV
--FROM PRESIDENT
--WHERE YEARS_SERV=1 OR YEARS_SERV=2 OR YEARS_SERV=12
--ORDER BY YEARS_SERV ASC, PRES_NAME ASC
--8
--SELECT p.PRES_NAME
--FROM PRESIDENT p
--WHERE p.BIRTH_YEAR>=ALL(SELECT q.BIRTH_YEAR FROM PRESIDENT q)

--SELECT PRES_NAME, BIRTH_YEAR
--FROM PRESIDENT
--WHERE BIRTH_YEAR>1910 AND BIRTH_YEAR<1960
--ORDER BY BIRTH_YEAR ASC
--9
--SELECT PRES_NAME, COUNT(DISTINCT VICE_PRES_NAME)AS Anzahl
--FROM  ADMIN_PR_VP  
--GROUP BY PRES_NAME
--ORDER BY PRES_NAME ASC
--10
--SELECT STATE_BORN, MIN(DEATH_AGE) AS MinDeathAge, MAX(DEATH_AGE) AS MaxDeathAge, AVG(DEATH_AGE) AS AvgDeathAge, AVG(BIRTH_YEAR+DEATH_AGE) AS AvgDeathYear
--FROM PRESIDENT
--GROUP BY STATE_BORN
--11
--SELECT DISTINCT(p.PRES_NAME) AS Name, a.ELECTION_YEAR-p.BIRTH_YEAR AS Age
--FROM PRESIDENT p, ELECTION a
--WHERE p.PRES_NAME=a.CANDIDATE AND WINNER_LOSER_INDIC='W' AND a.ELECTION_YEAR-p.BIRTH_YEAR>=60
--ORDER BY p.PRES_NAME
--12
--SELECT *
--FROM PRESIDENT
--WHERE PRES_NAME LIKE 'R%'
--13
--SELECT *
--FROM PRESIDENT
--WHERE PRES_NAME NOT LIKE 'R%' AND PRES_NAME LIKE '_e%'
--14
--SELECT PRES_NAME
--FROM PRESIDENT
--WHERE PRES_NAME NOT LIKE '% _ _'
--15
--SELECT PRES_NAME FROM PRESIDENT 
--MINUS
--SELECT DISTINCT(PRES_NAME) FROM PRES_MARRIAGE
--16
--SELECT m.PRES_NAME, m.MAR_YEAR
--FROM PRESIDENT p, PRES_MARRIAGE m
--WHERE p.PARTY='Republican' AND p.PRES_NAME=m.PRES_NAME AND m.MAR_YEAR BETWEEN 1939 AND 1945
--17
--SELECT m.SPOUSE_NAME
--FROM PRES_MARRIAGE m, PRES_HOBBY h
--WHERE m.PRES_NAME=h.PRES_NAME AND HOBBY='Poker'
--18
--SELECT p.PRES_NAME, p.PARTY
--FROM PRESIDENT p, PRES_MARRIAGE m
--WHERE p.PRES_NAME=m.PRES_NAME AND NR_CHILDREN=0
--19
--SELECT PRES_NAME, COUNT (PRES_NAME) AS EHEN
--FROM PRES_MARRIAGE
--GROUP BY PRES_NAME 
--ORDER BY EHEN DESC
--20
--SELECT m.SPOUSE_NAME
--FROM PRESIDENT p, PRES_MARRIAGE m
--WHERE p.PRES_NAME=m.PRES_NAME AND p.BIRTH_YEAR=1924
--21
--SELECT PRES_NAME
--FROM PRES_MARRIAGE 
--WHERE PR_AGE=20
--22
--SELECT m.SPOUSE_NAME
--FROM PRESIDENT p, PRES_MARRIAGE m
--WHERE p.PRES_NAME=m.PRES_NAME AND p.PARTY='Democratic'
--ORDER BY m.SPOUSE_NAME ASC
--23
--SELECT p.PRES_NAME
--FROM PRESIDENT p
--WHERE p.PARTY='Democratic' AND p.PRES_NAME NOT IN(SELECT m.PRES_NAME FROM PRES_MARRIAGE m WHERE p.PRES_NAME=m.PRES_NAME)
--24
--SELECT PRES_NAME, SUM(NR_CHILDREN) AS ANZAHL
--FROM PRES_MARRIAGE
--GROUP BY PRES_NAME
--ORDER BY ANZAHL DESC
--25
--SELECT PRES_NAME, SUM(NR_CHILDREN) AS ANZAHL
--FROM PRES_MARRIAGE
--GROUP BY PRES_NAME
--HAVING SUM(NR_CHILDREN)>=10
--ORDER BY ANZAHL DESC
--26
--SELECT PRES_NAME, SP_AGE-PR_AGE AS DIFF
--FROM PRES_MARRIAGE
--WHERE PR_AGE<SP_AGE
--27
--SELECT p.MAR_YEAR, COUNT(MAR_YEAR)
--FROM PRES_MARRIAGE p
--GROUP BY MAR_YEAR
--HAVING COUNT(MAR_YEAR)=2
--28
--SELECT PRES_NAME
--FROM PRES_HOBBY
--WHERE HOBBY='Fishing'
--29
--SELECT PRES_NAME
--FROM PRESIDENT 
--WHERE PRES_NAME NOT IN (SELECT PRES_NAME FROM PRES_HOBBY)
--oder
--SELECT PRES_NAME FROM PRESIDENT MINUS SELECT PRES_NAME FROM PRES_HOBBY
--30
--SELECT p.PRES_NAME
--FROM PRES_HOBBY p
--WHERE EXISTS(SELECT * FROM PRES_HOBBY h WHERE h.PRES_NAME=p.PRES_NAME AND p.HOBBY='Golf' AND h.HOBBY='Riding')
--31
--SELECT m.PRES_NAME, m.HOBBY
--FROM PRESIDENT p JOIN PRES_HOBBY m
--ON p.PRES_NAME=m.PRES_NAME 
--WHERE p.STATE_BORN='Texas' 
--32
--SELECT PRES_NAME, COUNT(HOBBY) AS HOBBY
--FROM PRES_HOBBY
--GROUP BY PRES_NAME 
--HAVING COUNT(HOBBY)>3
--33
--SELECT DISTINCT(m.HOBBY) AS HOBBY
--FROM PRES_HOBBY m JOIN PRESIDENT p
--ON m.PRES_NAME=p.PRES_NAME
--WHERE p.PARTY='Republican'
--ORDER BY HOBBY
--34
--SELECT DISTINCT(p.PARTY) AS PARTEI
--FROM PRESIDENT p JOIN PRES_HOBBY m
--ON p.PRES_NAME=m.PRES_NAME
--WHERE m.HOBBY='Shooting'
--35
--SELECT p.PRES_NAME
--FROM PRESIDENT p JOIN PRES_HOBBY m
--ON p.PRES_NAME=m.PRES_NAME
--WHERE p.PARTY='Democratic' AND m.HOBBY='Riding'
--ORDER BY p.PRES_NAME
--36
--SELECT m.PRES_NAME
--FROM PRES_HOBBY m
--WHERE m.HOBBY='Poker' AND NOT EXISTS (SELECT * FROM PRES_HOBBY p WHERE m.PRES_NAME=p.PRES_NAME AND p.HOBBY='Golf')
--37
--SELECT DISTINCT(m.PRES_NAME)
--FROM PRES_HOBBY m JOIN PRESIDENT p
--ON p.PRES_NAME=m.PRES_NAME WHERE NOT m.HOBBY='Shooting' AND p.PARTY='Republican'
--GROUP BY m.PRES_NAME
--38
--SELECT *
--FROM PRESIDENT
--WHERE PARTY='Republican'
--39
--SELECT DISTINCT(PARTY)
--FROM PRESIDENT
--40
--SELECT PARTY,  COUNT(PARTY) AS AMOUNT
--FROM PRESIDENT
--WHERE BIRTH_YEAR>1850
--GROUP BY PARTY
--HAVING COUNT(PARTY)>=8
--41
--SELECT PRES_NAME, PARTY
--FROM PRESIDENT 
--WHERE STATE_BORN='Texas' AND NOT PARTY='Republican'
--42
--SELECT PARTY, COUNT(PARTY) AS Anzahl
--FROM PRESIDENT
--GROUP BY PARTY
--ORDER BY Anzahl
--43
--SELECT PRES_NAME
--FROM PRESIDENT
--WHERE PARTY='Whig'
--44
--SELECT PARTY, SUM(YEARS_SERV) AS Dauer, COUNT(PRES_NAME) AS Anzahl, AVG(YEARS_SERV) AS MIDDLE
--FROM PRESIDENT
--GROUP BY PARTY
--ORDER BY Dauer DESC
--45
--SELECT STATE_NAME FROM STATE MINUS SELECT STATE_BORN FROM PRESIDENT
--46
--SELECT p.PRES_NAME
--FROM PRESIDENT p, STATE s
--WHERE p.STATE_BORN=s.STATE_NAME AND s.YEAR_ENTERED=1776
--SELECT PRES_NAME
--FROM PRESIDENT
--WHERE BIRTH_YEAR>1776
--47
--SELECT PRES_NAME, BIRTH_YEAR
--FROM PRESIDENT
--WHERE STATE_BORN='Texas'
--48
--SELECT DISTINCT(STATE_BORN)
--FROM PRESIDENT
--ORDER BY STATE_BORN
--49
--SELECT STATE_BORN, COUNT(STATE_BORN) AS Anzahl
--FROM PRESIDENT
--GROUP BY STATE_BORN
--HAVING COUNT(STATE_BORN)>=2
--ORDER BY COUNT(STATE_BORN) ASC, STATE_BORN DESC
--50
--SELECT PARTY, COUNT(DISTINCT(STATE_BORN)) AS Anzahl
--FROM PRESIDENT
--GROUP BY PARTY
--ORDER BY Anzahl
--51
--SELECT STATE_NAME
--FROM STATE
--WHERE YEAR_ENTERED>1776 ORDER BY STATE_NAME 
--52
--SELECT CANDIDATE
--FROM ELECTION
--MINUS SELECT PRES_NAME FROM PRESIDENT 
--53
--SELECT CANDIDATE, COUNT(CANDIDATE) AS Participate
--FROM ELECTION
--GROUP BY CANDIDATE
--HAVING COUNT(CANDIDATE)>1
--ORDER BY CANDIDATE
--54
--SELECT CANDIDATE, COUNT(CANDIDATE) AS AnzahlTeilnahme, COUNT(CASE WHEN WINNER_LOSER_INDIC='W' THEN 1 END) AS WIN, 
--COUNT(CASE WHEN WINNER_LOSER_INDIC='L' THEN 1 END) AS LOSE
--FROM ELECTION
--GROUP BY CANDIDATE
--ORDER BY COUNT(CASE WHEN WINNER_LOSER_INDIC='W' THEN 1 END) DESC, COUNT(CANDIDATE) ASC
--55
--
--56
--SELECT CANDIDATE, VOTES, ELECTION_YEAR 
--FROM ELECTION
--WHERE WINNER_LOSER_INDIC='W'
--57
--SELECT m.PRES_NAME, m.PR_AGE, p.PARTY
--FROM PRES_MARRIAGE m JOIN PRESIDENT p ON m.PRES_NAME=p.PRES_NAME
--WHERE m.PR_AGE<25 OR p.PARTY='Republican' 
--ORDER BY p.PARTY
--58
--SELECT BIRTH_YEAR
--FROM PRESIDENT 
--GROUP BY BIRTH_YEAR
--HAVING COUNT(BIRTH_YEAR)>=2
--ORDER BY BIRTH_YEAR
--59
--SELECT PRES_NAME
--FROM PRESIDENT
--WHERE STATE_BORN='Texas' AND PARTY='Republican'
--60
--SELECT PRES_NAME
--FROM PRESIDENT
--WHERE STATE_BORN='Texas' OR PARTY='Republican'