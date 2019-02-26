insert into users (id, email, first_name, last_name, password, username, organization_id, position_id, title_id) 
values (1, 'randyyin28@gmail.com', 'randy', 'yin', '1234', 'ryin', '1', '1', '1');

insert into users (id, email, first_name, last_name, password, username, organization_id, position_id, title_id) 
values (2, 'kobe@gmail.com', 'kobe', 'bryant', '4321', 'kbryant', '2', '2', '2');

insert into events (id, event_description, end_time, event_location, event_name, start_time, administrator_id, organizer_id) 
values (1, 'Computer Science Meet and Greet', '2018-06-18 10:34:00', 'Los Angeles', 'Computer Science Banquet', '2018-06-18 11:34:00', '1', '1');

insert into events (id, event_description, end_time, event_location, event_name, start_time, administrator_id, organizer_id) 
values (2, 'Psychology Meet and Greet', '2018-01-02 09:20:00', 'Los Angeles', 'Psychology Banquet', '2018-01-02 10:20:00', '2', '2');

insert into organizations (id, organization_name)
values(1, 'reward organization 1');

insert into organizations (id, organization_name)
values(2, 'reward organization 2');

insert into affiliations (id, affiliation_description, full_name, affiliation_name)
values(1, 'affiliation engineering', 'affiliation engineering 1', 'engineering affiliation');

insert into affiliations (id, affiliation_description, full_name, affiliation_name)
values(2, 'affiliation psychology', 'affiliation psychology 1', 'psychology affiliation');

insert into tags (id, name)
values(1, 'ECST');

insert into tags (id, name)
values(2, 'ACM');

insert into positions(id, name)
values(1, 'student');

insert into positions(id, name)
values(2, 'faculty');

insert into positions(id, name)
values(3, 'staff');

insert into rewards(id, end_time, reward_organization, reward_poster, start_time, administrator_id, provider_id)
values(1,'2018-01-02 09:20:00', 'reward 1', 'reward poster 1', '2018-01-02 09:20:00', '1', '1' );

insert into rewards(id, end_time, reward_organization, reward_poster, start_time, administrator_id, provider_id)
values(2,'2018-01-02 09:20:00', 'reward 2', 'reward poster 2', '2018-01-02 09:20:00', '2', '2' );

insert into roles(id, name)
values(1, 'admin');

insert into roles(id, name)
values(2, 'event organizer');

insert into roles(id, name)
values(3, 'reward provider');

insert into titles(id, name)
values(1, 'director');

insert into titles(id, name)
values(2, 'president');






