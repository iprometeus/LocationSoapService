INSERT INTO place (name, type_id, coordinate)
VALUES 	('National', 1, POINT(1, 2)),
		('CitadelInn', 2, POINT(5, 5)),
		('Madlenn', 3, POINT(10, 1)),
        ('Lviv', 4, POINT(8, 9)),
        ('King Cross', 5, POINT(4, 9)),
        ('Victoria Gardens', 5, POINT(11, 11)),
        ('Forum', 5, POINT(21, 25));
        
INSERT INTO user (username, firstname, lastname, email, place_id)
VALUES 	('olegp', 'Oleg', 'P', 'olegp@test.com', 1),
		('mariak', 'Maria', 'K', 'mariak@test.com', 2),
        ('markr', 'Mark', 'R', 'markr@test.com', 2),
		('victorl', 'Victor', 'L', 'victorl@test.com', 3),
        ('andrewm', 'Andrew', 'M', 'andym@test.com', 3);