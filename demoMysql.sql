use vehicle_care_platform;

insert into admin( name, email, age, gender, contactno, address, location, password) values('admin12', 'admin12@gmail.com', '26', 'FEMALE', '8596743210', 'IACSD','Akurdi','admin12');
insert into users( name, email, age, gender, contactno, address, location, password) values('jenna123', 'jenna123@gmail.com', '21', 'FEMALE', '8565461624', 'gurudwara chowk','Akurdi','jenna123');
insert into mechanic( name, email, age, gender, contactno, address, location, password) values('saimotors', 'saimotors@gmail.com', '41', 'FEMALE', '8561546782', 'gurudwara chowk','Akurdi','saimotors');

insert into vehicles(user_id, make, model, year, color, license_plate) values(1, 'honda', 'activa', 2019, 'white', 'MH 12 PO 7458');
insert into services(mechanic_id, name, description, duration, price, location) values(1,'Paint Job','Full Body Paint','50','15000','Akurdi');