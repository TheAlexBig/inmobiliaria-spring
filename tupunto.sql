CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE "user" (
  "u_code" UUID PRIMARY KEY DEFAULT uuid_generate_v4 (),
  "u_id" serial UNIQUE NOT NULL,
  "u_account_type" int DEFAULT 1,
  "u_email" varchar NOT NULL,
  "u_username" varchar NOT NULL,
  "u_password" varchar NOT NULL,
  "u_token_verification" varchar,
  "u_token_reset" varchar,
  "u_favorites" integer[],
  "u_not_liked" integer[],
  "u_active" boolean DEFAULT true,
  "u_date_created" varchar DEFAULT CURRENT_DATE,
  "u_last_updated" varchar
);

CREATE TABLE "profile" (
  "p_code" UUID PRIMARY KEY DEFAULT uuid_generate_v4 (),
  "p_id" serial UNIQUE NOT NULL,
  "u_code" UUID NOT NULL,
  "p_profile_photo" varchar,
  "p_address" jsonb NOT NULL,
  "p_document" jsonb NOT NULL,
  "p_phone" varchar,
  "p_names" varchar NOT NULL,
  "p_last_names" varchar NOT NULL,
  "p_sex" varchar NOT NULL,
  "p_currently_hired" boolean DEFAULT false,
  "p_last_updated" varchar
);

CREATE TABLE "appointment_profile" (
    "ap_code" UUID PRIMARY KEY DEFAULT uuid_generate_v4 (),
  "ap_id" serial UNIQUE NOT NULL,
  "rh_code" UUID NOT NULL,
  "u_code" UUID NOT NULL,
  "ap_date_requested" varchar,
  "ap_time_requested" varchar,
  "ap_accepted" boolean
);

CREATE TABLE "employee" (
  "e_code" UUID,
  "p_code" UUID,
  "m_since" varchar,
  "m_end" varchar,
  "m_hired" boolean DEFAULT true
);

CREATE TABLE "enterprise" (
  "e_code" UUID PRIMARY KEY DEFAULT uuid_generate_v4 (),
  "e_id" serial UNIQUE NOT NULL,
  "u_code" UUID,
  "e_address" jsonb,
  "e_document" jsonb,
  "e_name" varchar,
  "e_active_enterprise" boolean,
  "e_last_updated" varchar
);

CREATE TABLE "request_header" (
  "rh_code" UUID PRIMARY KEY DEFAULT uuid_generate_v4 (),
  "rh_id" serial UNIQUE NOT NULL,
  "rh_user_type" int,
  "rh_billing_method" int,
  "rh_package_selected" boolean,
  "rh_show_contact_info" boolean,
  "rh_personal_info" boolean,
  "rh_active_request" boolean,
  "rh_total_due" float,
  "rh_accepted_code" UUID,
  "rh_message" text,
  "rh_accepted" boolean DEFAULT false,
  "rh_paid" boolean DEFAULT false,
"rh_date_created" varchar DEFAULT CURRENT_DATE,
"rh_date_accepted" varchar,
  "rh_last_pay_day" varchar,
  "rh_owner" UUID NOT NULL,
  "ti_code" UUID NOT NULL,
  "pp_code" UUID NOT NULL
);

CREATE TABLE "property_type" (
  "pt_code" UUID PRIMARY KEY DEFAULT uuid_generate_v4 (),
  "pt_id" serial UNIQUE NOT NULL,
  "pt_name" varchar,
  "pt_fields" jsonb,
  "pt_conditions" jsonb
);

CREATE TABLE "premium_package" (
  "pp_code" UUID PRIMARY KEY DEFAULT uuid_generate_v4 (),
  "pp_id" serial UNIQUE NOT NULL,
  "pp_name" varchar
);

CREATE TABLE "time_online" (
  "tl_code" UUID PRIMARY KEY DEFAULT uuid_generate_v4 (),
  "tl_id" serial UNIQUE NOT NULL,
  "tl_days" int,
  "tl_price" float
);

CREATE TABLE "property" (
  "py_code" UUID PRIMARY KEY DEFAULT uuid_generate_v4 (),
  "py_id" serial UNIQUE NOT NULL,
  "py_address" jsonb,
  "py_transaction" int,
  "py_title_ad" varchar,
  "py_place_description" text,
  "py_display_fields" jsonb,
  "py_visible" boolean,
  "py_service" boolean,
  "py_thumbnail" varchar,
  "py_gallery" text,
  "rh_code" UUID NOT NULL,
  "pt_code" UUID NOT NULL,
  "py_lat" float,
  "py_lng" float,
  "py_ground_level" int DEFAULT 1
);

CREATE TABLE "points_interest" (
  "pi_code" UUID PRIMARY KEY DEFAULT uuid_generate_v4 (),
  "pi_id" serial UNIQUE NOT NULL,
  "py_code" UUID NOT NULL,
  "pi_name" varchar,
  "pi_icon" varchar,
  "pi_lat" float,
  "pi_lng" float
);

CREATE TABLE "premium_element" (
  "pe_code" UUID PRIMARY KEY DEFAULT uuid_generate_v4 (),
  "pe_id" serial UNIQUE NOT NULL,
  "pp_code" UUID NOT NULL,
  "pe_date_created" varchar DEFAULT CURRENT_DATE,
  "pe_name" varchar,
  "ve_type" varchar,
  "pe_price" float
);

CREATE TABLE "visual_element" (
  "ve_code" UUID PRIMARY KEY,
  "ve_id" serial UNIQUE NOT NULL,
  "ve_name" varchar,
  "ve_url" varchar,
  "ve_full_url" varchar,
  "ve_alt" varchar,
  "ve_uploaded" varchar,
  "py_code" UUID NOT NULL,
  "pe_code" UUID NOT NULL
);

CREATE TABLE "admin" (
  "ad_code" UUID PRIMARY KEY DEFAULT uuid_generate_v4 (),
  "ad_id" serial UNIQUE NOT NULL,
  "ad_email" varchar NOT NULL,
  "ad_username" varchar NOT NULL,
  "ad_password" varchar NOT NULL,
  "ad_names" varchar NOT NULL,
  "ad_last_names" varchar NOT NULL
);

ALTER TABLE "request_header" ADD FOREIGN KEY ("rh_owner") REFERENCES "profile" ("p_code");

ALTER TABLE "profile" ADD FOREIGN KEY ("u_code") REFERENCES "user" ("u_code");

ALTER TABLE "employee" ADD FOREIGN KEY ("e_code") REFERENCES "enterprise" ("e_code");

ALTER TABLE "employee" ADD FOREIGN KEY ("p_code") REFERENCES "profile" ("p_code");

ALTER TABLE "request_header" ADD FOREIGN KEY ("rh_owner") REFERENCES "enterprise" ("e_code");

ALTER TABLE "enterprise" ADD FOREIGN KEY ("u_code") REFERENCES "user" ("u_code");

ALTER TABLE "request_header" ADD FOREIGN KEY ("ti_code") REFERENCES "time_online" ("tl_code");

ALTER TABLE "request_header" ADD FOREIGN KEY ("pp_code") REFERENCES "premium_package" ("pp_code");

ALTER TABLE "property" ADD FOREIGN KEY ("rh_code") REFERENCES "request_header" ("rh_code");

ALTER TABLE "property" ADD FOREIGN KEY ("pt_code") REFERENCES "property_type" ("pt_code");

ALTER TABLE "points_interest" ADD FOREIGN KEY ("py_code") REFERENCES "property" ("py_code");

ALTER TABLE "premium_element" ADD FOREIGN KEY ("pp_code") REFERENCES "premium_package" ("pp_code");

ALTER TABLE "visual_element" ADD FOREIGN KEY ("py_code") REFERENCES "property" ("py_code");

ALTER TABLE "visual_element" ADD FOREIGN KEY ("pe_code") REFERENCES "premium_element" ("pe_code");

ALTER TABLE "appointment_profile" ADD FOREIGN KEY ("u_code") REFERENCES "user" ("u_code");

ALTER TABLE "appointment_profile" ADD FOREIGN KEY ("rh_code") REFERENCES "request_header" ("rh_code");

