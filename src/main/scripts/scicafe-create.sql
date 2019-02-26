create table affiliations (
	id 						bigint primary key,
  	affiliation_description varchar(255) not null,
	full_name 				varchar(255) not null,
	affiliation_name 		varchar(255) not null
);

create table authorities (
	user_id 				bigint not null references users(id),
	role_id 				bigint not null references roles(id),
	primary key (user_id, role_id)
);

create table event_attendance (
	event_id 				bigint not null references events(id),
	user_id 				bigint not null references users(id)
);

create table event_tags (
	event_id 				bigint not null references events(id),
	tag_id 					bigint not null references tags(id)
);

create table events (
	id 						bigint primary key,
	approved 				boolean not null default false,
	event_description 		varchar(255) not null,
	end_time 				datetime(6),
	event_location 			varchar(255) not null,
	event_name 				varchar(255) not null,
	start_time 				datetime(6),
	administrator_id 		bigint references users(id),
	organizer_id 			bigint references users(id)
);

create table hibernate_sequence (
	next_val 				bigint
);

insert into hibernate_sequence values ( 100 );


create table organizations (
	id 						bigint primary key,
	organization_name 		varchar(255) not null
);

create table positions (
	id 						bigint primary key,
	name 					varchar(255) not null
);

create table program_affiliations (
	user_id 				bigint not null references users(id),
	affiliation_id 			bigint not null references affiliations(id),
	primary key (user_id, affiliation_id)
);

create table qualified_events (
	reward_id 				bigint not null references rewards(id),
	event_id 				bigint not null references events(id)
);

create table reward_criteria (
	reward_id 				bigint not null references rewards(id),
	tag_id 					bigint not null references tags(id)
);


create table rewards (
	id 						bigint primary key,
	approved 				boolean not null default false,
	end_time 				datetime(6),
	reward_organization 	varchar(255) not null,
	reward_poster 			varchar(255) not null,
	start_time 				datetime(6),
	administrator_id 		bigint references users(id),
	provider_id 			bigint references users(id)
);

create table roles (
	id 						bigint primary key,
	name 					varchar(255) not null
);

create table tags (
	id 						bigint primary key,
	name 					varchar(255) not null
);

create table titles (
	id 						bigint primary key,
	name 					varchar(255) not null
);


create table users (
	id 						bigint primary key,
	email 					varchar(255),
	enabled 				boolean not null default true,
	first_name 				varchar(255) not null,
	last_name 				varchar(255) not null,
	password 				varchar(255) not null,
	username 				varchar(255) not null,
	organization_id 		bigint references organizations(id),
	position_id 			bigint references positions(id),
	title_id 				bigint references titles(id)
);









