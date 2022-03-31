USE sakila;
-- SHOW TABLES;
DROP TABLE IF EXISTS rating;
CREATE TABLE rating(
	rating_id INT NOT NULL AUTO_INCREMENT,
    num_stars ENUM('0','1','2','3','4', '5') UNIQUE NOT NULL,
    description VARCHAR(20) NOT NULL,
    PRIMARY KEY (rating_id)
);
-- DESC rating;
-- SHOW TABLES;
INSERT INTO rating(num_stars, description)
	VALUES
		('0', 'worst movie ever'),
	    ('1', 'dissapointing'),
	    ('2', 'bearable'),
	    ('3', 'just fine'),
	    ('4', 'pretty good'),
	    ('5', 'awesome');
SELECT * FROM rating;
