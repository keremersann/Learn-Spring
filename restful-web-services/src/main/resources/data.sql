insert into user_details (id, name, birth_date)
values(1001, 'Kerem', current_date());

insert into user_details (id, name, birth_date)
values(1002, 'Salim', current_date());

insert into user_details (id, name, birth_date)
values(1003, 'Ertan', current_date());

insert into post (id, description, user_id)
values(2001, 'Learn Dance', 1001);

insert into post (id, description, user_id)
values(2002, 'Learn Reading', 1002);

insert into post (id, description, user_id)
values(2003, 'Learn Writing', 1001);

insert into post (id, description, user_id)
values(2004, 'Learn Singing', 1003);