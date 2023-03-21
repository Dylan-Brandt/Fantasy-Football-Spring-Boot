# FantasyFootballSpringBoot
A Spring Boot application which shows football players statistics for the 2022 NFL season. Player data is displayed on a webpage in a table. The table may be sorted in ascending or descending order by any of the columns by clicking on the column's label. Features include searching for players by name, and filtering the table by position. Data is stored in a Postgres database and retrieved using JDBC, then displayed using a Thymeleaf template engine. Initial game data obtained from https://www.advancedsportsanalytics.com/nfl-raw-data and aggregated over the entire 2022 season using a Python script.

## Landing page
![image](https://user-images.githubusercontent.com/97772869/226406659-da50bd86-884a-4637-af1a-68e051bc927e.png)

## Show only QBs
![image](https://user-images.githubusercontent.com/97772869/226407389-c8a171ae-27c2-4010-afd3-22f326b42539.png)

## Search QBs for names containing "allen"
![image](https://user-images.githubusercontent.com/97772869/226407011-8ce74094-052d-42ca-9859-8506c5de6fc2.png)

## Sort the table by the column for passing touchdowns in descending order
![image](https://user-images.githubusercontent.com/97772869/226407248-1de6d867-93fe-4718-9a60-acd53615a6d2.png)
