drop database if exists pokemon;

create database pokemon default character set utf8 default collate utf8_general_ci;

use pokemon;

create table players(
	id int primary key auto_increment,
	name varchar(50) unique not null,
	pokemon varchar(50),
	type varchar(50),
	level int(2) default 1,
	exp int(2) default 0,
	maxHp int(3),
	hp int(3),
	damage int(3),
	hunger int(3) default 0,
	move1 varchar(50),
	power1 int(3),
	move2 varchar(50),
	power2 int(3),
	move3 varchar(50),
	power3 int(3)
);

create table pokemons(
	id int primary key auto_increment,
	name varchar(50) not null,
    type varchar(50) not null,
    hp int(3) not null,
    damage int(3) not null,
    initial boolean default false,
    move1 varchar(50) not null,
	power1 int(3) not null,
	move2 varchar(50) not null,
    power2 int(3) not null,
    move3 varchar(50) not null,
    power3 int(3) not null
);

insert into pokemons values(null, 'Bulbasaur', 'Planta', 94, 49, true, 'Placaje', 50, 'Látigo cepa', 45, 'Derribo', 90);
insert into pokemons values(null, 'Charmander', 'Fuego', 82, 52, true, 'Arañazo', 40, 'Ascuas', 40, 'Colmillo ígneo', 65);
insert into pokemons values(null, 'Squirtle', 'Agua', 109, 48, true, 'Placaje', 50, 'Pistola de agua', 40, 'Burbujas', 40);
insert into pokemons values(null, 'Poliwag', 'Agua', 80, 50, default, 'Pistola de agua', 40, 'Burbujas', 40, 'Doble bofetón', 15);
insert into pokemons values(null, 'Cleffa', 'Hada', 78, 25, default, 'Destructor', 40, 'Canto', 0, 'Hoja mágica', 60);
insert into pokemons values(null, 'Bellsprout', 'Planta', 85, 75, default, 'Látigo cepa', 45, 'Constricción', 15, 'Ácido', 40);
insert into pokemons values(null, 'Onix', 'Roca', 195, 45, default, 'Placaje', 50, 'Atadura', 15, 'Lanzarrocas', 50);
insert into pokemons values(null, 'Chikorita', 'Planta', 110, 49, default, 'Placaje', 50, 'Hoja afilada', 55, 'Hoja mágica', 60);
insert into pokemons values(null, 'Haunter', 'Fantasma', 90, 50, default, 'Langüetazo', 30, 'Golpe bajo', 80, 'Puño sombra', 60);
insert into pokemons values(null, 'Gengar', 'Fantasma', 120, 65, default, 'Langüetazo', 30, 'Golpe bajo', 80, 'Puño sombra', 60);
