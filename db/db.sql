create database gestion_scolaire_JEE;

use gestion_scolaire_JEE;
create table filiere (
    id int primary key auto_increment,
    code varchar(50) not null,
    nom varchar(100) not null,
    departement varchar(100),
    nom_responsable varchar(100),
    prenom_responsable varchar(100),
    capacite int,
    description text
);

create table etudiant (
    id int primary key auto_increment,
    nom varchar(100) not null,
    prenom varchar(100) not null,
    email varchar(100),
    telephone varchar(20),
    carte_etudiant varchar(100),
    filiere_id int,
    foreign key (filiere_id) references filiere(id)
);

create table cours (
    id int primary key auto_increment,
    code varchar(50) not null,
    nom varchar(100) not null,
    description text,
    volume_horaire int,
    filiere_id int,
    foreign key (filiere_id) references filiere(id)
);

create table note (
    id int primary key auto_increment,
    etudiant_id int,
    cours_id int,
    note float,
    date_enregistrement datetime,
    foreign key (etudiant_id) references etudiant(id),
    foreign key (cours_id) references cours(id)
);

drop DATABASE gestion_scolaire_JEE;

DROP Table if EXISTS etudiant;