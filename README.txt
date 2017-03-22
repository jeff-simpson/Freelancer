Jeff Simpson
810-347-517
jeff.simpson@uga.edu


This is for project 3!

The structure of my database is in db.txt, the hardcoded database / username/password for mysql are as follows:

	database: imdb2
	username: demo
	password: demo

Below is the table Reviews we were required to build. Note the keys and auto increments

reviews
+----------+--------------+------+-----+---------+----------------+
| Field    | Type         | Null | Key | Default | Extra          |
+----------+--------------+------+-----+---------+----------------+
| id       | int(11)      | NO   | PRI | NULL    | auto_increment |
| movie_id | int(11)      | YES  | MUL | NULL    |                |
| review   | varchar(256) | YES  |     | NULL    |                |
+----------+--------------+------+-----+---------+----------------+

I have attached my source folder as well so if you need to change the DB login information you can.

To access my page please go to: 

http://wp420.cs.uga.edu:8080/jeff_simpson_review/index.html


Note:

In order to create a movie you must search to see if it exists first. Then you will be prompted to create it. You must also search for a movie to write a review for that movie as well



Thanks!

