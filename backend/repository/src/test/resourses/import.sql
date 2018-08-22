insert into country(phone_code, short_name, name) values (375, 'by', 'Belarus')
insert into state(name, country_id) values ('Minskaya oblast', 1)
insert into city(name, state_id) values ('Borisov', 1)
insert into city (name, state_id) values ('cxvcxbxc', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress (adress, city_id) values ('42, 58', 2)
insert into adress (adress, city_id) values ('42, 58', 2)


insert into client (email, lastname, name, password, phone, city_id)values ('email', 'lastname', 'name', 'string', '123123123', 1)
insert into client_roles values (1, 0), (1, 1), (1, 2)
insert into post (information, price, rooms_count, title, building_type, post_type, client_id)values ('info1', 100, 2, 'title4', 'APARTMENT', 'SALE', 1)
insert into post (information, price, rooms_count, title, building_type, post_type, client_id)values ('info2', 125, 4, 'title5', 'APARTMENT', 'SALE', 1)
insert into post (information, price, rooms_count, title, building_type, post_type, client_id)values ('info3', 175, 6, 'title6', 'APARTMENT', 'SALE', 1)
insert into post (information, price, rooms_count, title, building_type, post_type, client_id)values ('info3', 200, 8, 'title6', 'APARTMENT', 'SALE', 1)

insert into post_images(post_id, images) values (1, '123'), (2, '123'), (3, '345')

