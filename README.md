# LawnAgency Web Application
<hr>
COP4010 - Software Engineering Project
<br>

### Requirements
<hr>
Java JDK 1.8<br>
MySQL 8.0
<br>

### Setup
<hr>
1. Import MySQL database provided in the resources folder using the MySQL Command Line Client, and entering the following command. <br>

```
lawndb < file.sql
```

<br>
2. Under the resources folder create a .env file, and enter a google maps api key using the variable "mapApiKey".
<br>

### Running LawnAgency
<hr>

Run LawnWebappApplication.

<br>

### Exporting Database
<hr>
If you want to export the database at any point for any reason use the following command in the MySQL Command Line Client.

```
mysqldump -u root -p lawndb > lawndb.sql
```
