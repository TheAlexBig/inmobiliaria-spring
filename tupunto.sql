CREATE TABLE "user" (
  "u_code" UUID  PRIMARY KEY DEFAULT uuid_generate_v4 (),
  "u_id" SERIAL NOT NULL UNIQUE,
  "u_email" varchar NOT NULL,
  "u_username" varchar NOT NULL,
  "u_password" varchar NOT NULL,
  "u_account_type" int DEFAULT 1,
  "u_profile_photo" varchar NULL,
  "u_token_verification" varchar NULL,
  "u_token_reset" varchar NULL,
  "u_favorites" integer[],
  "u_unliked" integer[],
  "u_active" boolean DEFAULT true,
  "u_date_created" varchar DEFAULT CURRENT_DATE,
  "u_last_updated" varchar NULL
);

CREATE TABLE "client" (
  "c_code" UUID  PRIMARY KEY DEFAULT uuid_generate_v4 (),
  "c_id" SERIAL NOT NULL UNIQUE,
  "u_code" UUID,
  "e_code" UUID NULL,
  "c_address" jsonb NOT NULL,
  "c_document" jsonb NOT NULL,
  "c_names" varchar NOT NULL,
  "c_lastnames" varchar NOT NULL,
  "c_sex" varchar NOT NULL,
  "c_last_updated" varchar DEFAULT CURRENT_DATE
);

CREATE TABLE "enterprise" (
  "e_code" UUID  PRIMARY KEY DEFAULT uuid_generate_v4 (),
  "u_code" UUID,
	"e_id" SERIAL NOT NULL UNIQUE,
  "e_address" jsonb NOT NULL,
  "e_document" jsonb NOT NULL,
  "e_name" varchar NOT NULL,
  "e_active_enterprise" boolean,
  "e_last_updated" varchar
);


ALTER TABLE "client" ADD FOREIGN KEY ("u_code") REFERENCES "user" ("u_code");

ALTER TABLE "client" ADD FOREIGN KEY ("e_code") REFERENCES "enterprise" ("e_code");

ALTER TABLE "enterprise" ADD FOREIGN KEY ("u_code") REFERENCES "user" ("u_code");

SELECT * FROM public.user

dELETE from public.user

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

SELECT uuid_generate_v1();