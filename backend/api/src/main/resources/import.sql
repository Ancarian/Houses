insert into country(phone_code, short_name, name) values (375, 'by', 'Belarus')
insert into country(phone_code, short_name, name) values (234, 'ru', 'Russia')
insert into state(name, country_id) values ('Minskaya oblast', 1)
insert into state(name, country_id) values ('Vitebskaya oblast', 1)
insert into state(name, country_id) values ('Grodnenskaya oblast', 1)
insert into state(name, country_id) values ('Mogilevskaya oblast', 1)
insert into state(name, country_id) values ('Brestskaya oblast', 1)
insert into state(name, country_id) values ('Gomelskaya oblast', 1)
insert into city(name, state_id) values ('Borisov', 1)
insert into city(name, state_id) values ('Minsk', 1)
insert into city(name, state_id) values ('Bitebsk', 2)
insert into city(name, state_id) values ('Polock', 2)
insert into city(name, state_id) values ('Grodno', 3)
insert into city(name, state_id) values ('Mogilev', 4)
insert into city(name, state_id) values ('Brest', 5)
insert into city(name, state_id) values ('Gomel', 6)
insert into state(name, country_id) values ('Moskowskaya oblast', 2)
insert into city(name, state_id) values ('Moskow', 7)

insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)
insert into adress(adress, city_id) values ('42, 58', 1)


insert into client (email, lastname, name, password, phone, city_id)values ('email@gmail.com', 'lastname', 'name', 'password', '352345532', 1)
insert into client_roles values (1, 0), (1, 1), (1, 2)

insert into client (email, lastname, name, password, phone, city_id)values ('email2@gmail.com', 'lastname', 'name', 'password', '324534267', 1)
insert into client_roles values (2, 1)

insert into post(information, price, rooms_count,title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit a. Etiam sit amet quam rdiet a ac lacus.ie libero, non sagittis ex. Fusce ac nunc quam.', 100346, 2, 'title214',  'APARTMENT', 'SALE', 1, 1)
insert into post(information, price, rooms_count,title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sitsed mi tempor. Phasellus vestibulum. Etiam sit amet quam vel nec est.  a libero, non sagittis ex. Fusce ac nunc quam.', 125, 4, 'title5',  'APARTMENT', 'SALE', 1,2)
insert into post(information, price, rooms_count, title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, crdum a maesndrerit ex. Ut facilisis odio ut mi venenatis interdum vel ce ac nunc quam.', 175, 6,  'title6',  'APARTMENT', 'SALE', 1,3)
insert into post(information, price, rooms_count, title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, consecteturs consectetur, lobortis vel diam. Pmolestie libero, non sagittis ex. Fusce ac nunc quam.', 2243200, 8,  'title234233',  'APARTMENT', 'SALE', 2,4)
insert into post(information, price, rooms_count,title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit a. Etiam sit amet quam rdiet a ac lacus.ie libero, non sagittis ex. Fusce ac nunc quam.', 103240, 2, 'title4',  'APARTMENT', 'SALE', 1,5)
insert into post(information, price, rooms_count,title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sitsed mi tempor. Phasellus vestibulum. Etiam sit amet quam vel nec est.  a libero, non sagittis ex. Fusce ac nunc quam.', 12325, 4, 'title5',  'APARTMENT', 'SALE', 1,6)
insert into post(information, price, rooms_count, title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, crdum a maesndrerit ex. Ut facilisis odio ut mi venenatis interdum vel ce ac nunc quam.', 175, 6,  'title6',  'APARTMENT', 'SALE', 1,7)
insert into post(information, price, rooms_count, title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, consecteturs consectetur, lobortis vel diam. Pmolestie libero, non sagittis ex. Fusce ac nunc quam.', 20340, 8,  'title2345',  'APARTMENT', 'SALE', 2,8)
insert into post(information, price, rooms_count,title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit a. Etiam sit amet quam rdiet a ac lacus.ie libero, non sagittis ex. Fusce ac nunc quam.', 1032450, 2, 'title4',  'APARTMENT', 'SALE', 1,9)
insert into post(information, price, rooms_count,title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sitsed mi tempor. Phasellus vestibulum. Etiam sit amet quam vel nec est.  a libero, non sagittis ex. Fusce ac nunc quam.', 125, 4, 'title3214',  'APARTMENT', 'SALE', 1,10)
insert into post(information, price, rooms_count, title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, crdum a maesndrerit ex. Ut facilisis odio ut mi venenatis interdum vel ce ac nunc quam.', 175, 6,  'title6',  'APARTMENT', 'SALE', 1,11)
insert into post(information, price, rooms_count, title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, consecteturs consectetur, lobortis vel diam. Pmolestie libero, non sagittis ex. Fusce ac nunc quam.', 200, 8,  'title96786',  'APARTMENT', 'SALE', 2,12)
insert into post(information, price, rooms_count,title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit a. Etiam sit amet quam rdiet a ac lacus.ie libero, non sagittis ex. Fusce ac nunc quam.', 1087580, 2, 'title4',  'APARTMENT', 'SALE', 1,13)
insert into post(information, price, rooms_count,title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sitsed mi tempor. Phasellus vestibulum. Etiam sit amet quam vel nec est.  a libero, non sagittis ex. Fusce ac nunc quam.', 125, 4, 'title5',  'APARTMENT', 'SALE', 1,14)
insert into post(information, price, rooms_count, title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, crdum a maesndrerit ex. Ut facilisis odio ut mi venenatis interdum vel ce ac nunc quam.', 175, 6,  'title6',  'APARTMENT', 'SALE', 1,15)
insert into post(information, price, rooms_count, title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, consecteturs consectetur, lobortis vel diam. Pmolestie libero, non sagittis ex. Fusce ac nunc quam.', 200, 8,  'title6',  'APARTMENT', 'SALE', 2,16)
insert into post(information, price, rooms_count,title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit a. Etiam sit amet quam rdiet a ac lacus.ie libero, non sagittis ex. Fusce ac nunc quam.', 56100, 2, 'title4',  'APARTMENT', 'SALE', 1,17)
insert into post(information, price, rooms_count,title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sitsed mi tempor. Phasellus vestibulum. Etiam sit amet quam vel nec est.  a libero, non sagittis ex. Fusce ac nunc quam.', 125, 4, 'title5',  'APARTMENT', 'SALE', 1,18)
insert into post(information, price, rooms_count, title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, crdum a maesndrerit ex. Ut facilisis odio ut mi venenatis interdum vel ce ac nunc quam.', 175, 6,  'title6',  'APARTMENT', 'SALE', 1,19)
insert into post(information, price, rooms_count, title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, consecteturs consectetur, lobortis vel diam. Pmolestie libero, non sagittis ex. Fusce ac nunc quam.', 200, 8,  'title6',  'APARTMENT', 'SALE', 2,20)
insert into post(information, price, rooms_count,title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit a. Etiam sit amet quam rdiet a ac lacus.ie libero, non sagittis ex. Fusce ac nunc quam.', 65100, 2, 'title4',  'APARTMENT', 'SALE', 1,21)
insert into post(information, price, rooms_count,title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sitsed mi tempor. Phasellus vestibulum. Etiam sit amet quam vel nec est.  a libero, non sagittis ex. Fusce ac nunc quam.', 125, 4, 'title5',  'APARTMENT', 'SALE', 1,22)
insert into post(information, price, rooms_count, title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, crdum a maesndrerit ex. Ut facilisis odio ut mi venenatis interdum vel ce ac nunc quam.', 175, 6,  'title6',  'APARTMENT', 'SALE', 1,23)
insert into post(information, price, rooms_count, title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, consecteturs consectetur, lobortis vel diam. Pmolestie libero, non sagittis ex. Fusce ac nunc quam.', 200, 8,  'title6',  'APARTMENT', 'SALE', 2,24)
insert into post(information, price, rooms_count,title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit a. Etiam sit amet quam rdiet a ac lacus.ie libero, non sagittis ex. Fusce ac nunc quam.', 345100, 2, 'title4',  'APARTMENT', 'SALE', 1,25)
insert into post(information, price, rooms_count,title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sitsed mi tempor. Phasellus vestibulum. Etiam sit amet quam vel nec est.  a libero, non sagittis ex. Fusce ac nunc quam.', 125, 4, 'title5',  'APARTMENT', 'SALE', 1,26)
insert into post(information, price, rooms_count, title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, crdum a maesndrerit ex. Ut facilisis odio ut mi venenatis interdum vel ce ac nunc quam.', 175, 6,  'title6',  'APARTMENT', 'SALE', 1,27)
insert into post(information, price, rooms_count, title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, consecteturs consectetur, lobortis vel diam. Pmolestie libero, non sagittis ex. Fusce ac nunc quam.', 200, 8,  'title6',  'APARTMENT', 'SALE', 2,28)
insert into post(information, price, rooms_count,title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit a. Etiam sit amet quam rdiet a ac lacus.ie libero, non sagittis ex. Fusce ac nunc quam.', 32100, 2, 'title4',  'APARTMENT', 'SALE', 1,29)
insert into post(information, price, rooms_count,title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sitsed mi tempor. Phasellus vestibulum. Etiam sit amet quam vel nec est.  a libero, non sagittis ex. Fusce ac nunc quam.', 125, 4, 'title5',  'APARTMENT', 'SALE', 1,30)
insert into post(information, price, rooms_count, title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, crdum a maesndrerit ex. Ut facilisis odio ut mi venenatis interdum vel ce ac nunc quam.', 175, 6,  'title6',  'APARTMENT', 'SALE', 1,31)
insert into post(information, price, rooms_count, title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, consecteturs consectetur, lobortis vel diam. Pmolestie libero, non sagittis ex. Fusce ac nunc quam.', 200, 8,  'title6',  'APARTMENT', 'SALE', 2,32)
insert into post(information, price, rooms_count,title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit a. Etiam sit amet quam rdiet a ac lacus.ie libero, non sagittis ex. Fusce ac nunc quam.', 2345100, 2, 'title4',  'APARTMENT', 'SALE', 1,33)
insert into post(information, price, rooms_count,title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sitsed mi tempor. Phasellus vestibulum. Etiam sit amet quam vel nec est.  a libero, non sagittis ex. Fusce ac nunc quam.', 125, 4, 'title5',  'APARTMENT', 'SALE', 1,34)
insert into post(information, price, rooms_count, title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, crdum a maesndrerit ex. Ut facilisis odio ut mi venenatis interdum vel ce ac nunc quam.', 175, 6,  'title6',  'APARTMENT', 'SALE', 1,35)
insert into post(information, price, rooms_count, title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, consecteturs consectetur, lobortis vel diam. Pmolestie libero, non sagittis ex. Fusce ac nunc quam.', 200, 8,  'title6',  'APARTMENT', 'SALE', 2,36)
insert into post(information, price, rooms_count,title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit a. Etiam sit amet quam rdiet a ac lacus.ie libero, non sagittis ex. Fusce ac nunc quam.', 3245100, 2, 'title4',  'APARTMENT', 'SALE', 1,37)
insert into post(information, price, rooms_count,title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sitsed mi tempor. Phasellus vestibulum. Etiam sit amet quam vel nec est.  a libero, non sagittis ex. Fusce ac nunc quam.', 125, 4, 'title5',  'APARTMENT', 'SALE', 1,38)
insert into post(information, price, rooms_count, title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, crdum a maesndrerit ex. Ut facilisis odio ut mi venenatis interdum vel ce ac nunc quam.', 124575, 6,  'title6',  'APARTMENT', 'SALE', 1,39)
insert into post(information, price, rooms_count, title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, consecteturs consectetur, lobortis vel diam. Pmolestie libero, non sagittis ex. Fusce ac nunc quam.', 200, 8,  'title6',  'APARTMENT', 'SALE', 2,40)
insert into post(information, price, rooms_count,title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit a. Etiam sit amet quam rdiet a ac lacus.ie libero, non sagittis ex. Fusce ac nunc quam.', 1342500, 2, 'title4',  'APARTMENT', 'SALE', 1,41)
insert into post(information, price, rooms_count,title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sitsed mi tempor. Phasellus vestibulum. Etiam sit amet quam vel nec est.  a libero, non sagittis ex. Fusce ac nunc quam.', 125, 4, 'title5',  'APARTMENT', 'SALE', 1,42)
insert into post(information, price, rooms_count, title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, crdum a maesndrerit ex. Ut facilisis odio ut mi venenatis interdum vel ce ac nunc quam.', 1732455, 6,  'title6',  'APARTMENT', 'SALE', 1,43)
insert into post(information, price, rooms_count, title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, consecteturs consectetur, lobortis vel diam. Pmolestie libero, non sagittis ex. Fusce ac nunc quam.', 200, 8,  'title6',  'APARTMENT', 'SALE', 2,44)
insert into post(information, price, rooms_count,title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit a. Etiam sit amet quam rdiet a ac lacus.ie libero, non sagittis ex. Fusce ac nunc quam.', 75100, 2, 'title4',  'APARTMENT', 'SALE', 1,45)
insert into post(information, price, rooms_count,title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sitsed mi tempor. Phasellus vestibulum. Etiam sit amet quam vel nec est.  a libero, non sagittis ex. Fusce ac nunc quam.', 125, 4, 'title5',  'APARTMENT', 'SALE', 1,46)
insert into post(information, price, rooms_count, title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, crdum a maesndrerit ex. Ut facilisis odio ut mi venenatis interdum vel ce ac nunc quam.', 717575, 6,  'title4646',  'APARTMENT', 'SALE', 1,47)
insert into post(information, price, rooms_count, title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, consecteturs consectetur, lobortis vel diam. Pmolestie libero, non sagittis ex. Fusce ac nunc quam.', 200, 8,  'title6',  'APARTMENT', 'SALE', 2,48)
insert into post(information, price, rooms_count,title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit a. Etiam sit amet quam rdiet a ac lacus.ie libero, non sagittis ex. Fusce ac nunc quam.', 100, 2, 'title234',  'APARTMENT', 'SALE', 1,49)
insert into post(information, price, rooms_count,title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sitsed mi tempor. Phasellus vestibulum. Etiam sit amet quam vel nec est.  a libero, non sagittis ex. Fusce ac nunc quam.', 125, 4, 'title5',  'APARTMENT', 'SALE', 1,50)
insert into post(information, price, rooms_count, title , building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, crdum a maesndrerit ex. Ut facilisis odio ut mi venenatis interdum vel ce ac nunc quam.', 8768175, 6,  'title6346',  'APARTMENT', 'SALE', 1,51)
insert into post(information, price, rooms_count, title, building_type, post_type, client_id, adress_id) values ('Lorem ipsum dolor sit amet, consecteturs consectetur, lobortis vel diam. Pmolestie libero, non sagittis ex. Fusce ac nunc quam.', 200, 8,  'title68767',  'APARTMENT', 'SALE', 2,52)


insert into post_images(post_id, images) values (1, 'https://propertyfox.co.za/wp-content/uploads/2018/03/glass-houses.jpg'), (1, 'http://tcinsulating.com/wp-content/uploads/2018/07/outstanding-amazing-25-best-ideas-about-modern-architecture-house-on-pinterest-for-architecture-modern-houses-attractive.jpg'), (1, 'https://www.mercurynews.com/wp-content/uploads/2017/04/oak-houses-0321-011.jpg'), (1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXLoMvY8dNKSARJvEenscCN2o6UB_AB5okwfxO5AKSCQ_--BKZCQ')

