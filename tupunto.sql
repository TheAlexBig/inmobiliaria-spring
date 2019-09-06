CREATE TABLE "user" (
  "u_code" UUID  PRIMARY KEY DEFAULT uuid_generate_v4 (),
  "u_id" SERIAL NOT NULL UNIQUE,
  "u_email" varchar NOT NULL,
  "u_username" varchar NOT NULL,
  "u_password" varchar NOT NULL,
  "u_account_type" int DEFAULT 1,
  "u_token_verification" varchar NULL,
  "u_token_reset" varchar NULL,
  "u_favorites" integer[],
  "u_not_liked" integer[],
  "u_active" boolean DEFAULT true,
  "u_date_created" varchar DEFAULT CURRENT_DATE,
  "u_last_updated" varchar NULL
);


CREATE TABLE "client" (
  "c_code" UUID  PRIMARY KEY DEFAULT uuid_generate_v4 (),
  "c_id" SERIAL NOT NULL UNIQUE,
  "e_code" UUID NULL,
  "u_code" UUID NOT NULL,
  "c_names" varchar NOT NULL,
  "c_last_names" varchar NOT NULL,
  "c_sex" varchar NOT NULL,
  "c_profile_photo" varchar NULL,
  "c_address" jsonb NULL,
  "c_document" jsonb NULL,
  "c_phone" jsonb NULL,
  "c_last_updated" varchar DEFAULT CURRENT_DATE
);

CREATE TABLE "enterprise" (
  "e_code" UUID  PRIMARY KEY DEFAULT uuid_generate_v4 (),
  "e_id" SERIAL NOT NULL UNIQUE,
  "u_code" UUID NOT NULL,
  "e_active_enterprise" boolean DEFAULT true,
  "e_name" varchar NOT NULL,
  "e_profile_photo" varchar NULL,
  "e_address" jsonb NULL,
  "e_document" jsonb NULL,
  "e_phone" jsonb NULL,
  "c_last_updated" varchar DEFAULT CURRENT_DATE
);


ALTER TABLE "client" ADD FOREIGN KEY ("u_code") REFERENCES "user" ("u_code");

ALTER TABLE "client" ADD FOREIGN KEY ("e_code") REFERENCES "enterprise" ("e_code");

ALTER TABLE "enterprise" ADD FOREIGN KEY ("u_code") REFERENCES "user" ("u_code");

SELECT * FROM public.user

dELETE from public.user

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

SELECT uuid_generate_v1();