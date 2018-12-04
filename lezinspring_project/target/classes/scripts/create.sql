CREATE TABLE public.product
(
  id uuid NOT NULL,
  name text NOT NULL,
  unit character varying(256) NOT NULL,
  PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
);

ALTER TABLE public.product
  OWNER to postgres;

-- Table: public.seller

-- DROP TABLE public.seller;

CREATE TABLE public.seller
(
  id uuid NOT NULL,
  name text COLLATE pg_catalog."default" NOT NULL,
  birthday date,
  date_of_employment date,
  email text COLLATE pg_catalog."default",
  phone_number text COLLATE pg_catalog."default",
  address text COLLATE pg_catalog."default",
  CONSTRAINT seller_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.seller
  OWNER to postgres;


-- Table: public.buyer

-- DROP TABLE public.buyer;

CREATE TABLE public.buyer
(
  id uuid NOT NULL,
  name text COLLATE pg_catalog."default",
  birthday date,
  email text COLLATE pg_catalog."default",
  phone_number text COLLATE pg_catalog."default",
  address text COLLATE pg_catalog."default",
  CONSTRAINT buyer_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.buyer
  OWNER to postgres;


CREATE TABLE public.sale
(
  id uuid NOT NULL,
  order_date date,
  date_of_delivery date,
  quantity bigint,
  price bigint,
  comment text,
  address text,
  id_seller uuid NOT NULL,
  id_buyer uuid NOT NULL,
  id_product uuid NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_seller)
  REFERENCES public.seller (id) MATCH SIMPLE
  ON UPDATE CASCADE
  ON DELETE CASCADE,
  FOREIGN KEY (id_buyer)
  REFERENCES public.buyer (id) MATCH SIMPLE
  ON UPDATE CASCADE
  ON DELETE CASCADE,
  FOREIGN KEY (id_product)
  REFERENCES public.product (id) MATCH SIMPLE
  ON UPDATE CASCADE
  ON DELETE CASCADE
)
WITH (
OIDS = FALSE
);

ALTER TABLE public.sale
  OWNER to postgres;



-- Table: public.discount

-- DROP TABLE public.discount;

CREATE TABLE public.discount
(
  id uuid NOT NULL,
  min_quantity bigint,
  price bigint,
  "with" date,
  "in" date,
  id_seller uuid NOT NULL,
  id_product uuid NOT NULL,
  CONSTRAINT discount_pkey PRIMARY KEY (id),
  CONSTRAINT discount_id_product_fkey FOREIGN KEY (id_product)
  REFERENCES public.product (id) MATCH SIMPLE
  ON UPDATE CASCADE
  ON DELETE CASCADE,
  CONSTRAINT discount_id_seller_fkey FOREIGN KEY (id_seller)
  REFERENCES public.seller (id) MATCH SIMPLE
  ON UPDATE CASCADE
  ON DELETE CASCADE
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.discount
  OWNER to postgres;